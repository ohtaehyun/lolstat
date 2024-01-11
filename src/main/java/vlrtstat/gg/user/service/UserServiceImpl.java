package vlrtstat.gg.user.service;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import vlrtstat.gg.global.constant.TokenType;
import vlrtstat.gg.jwt.JwtProvider;
import vlrtstat.gg.jwt.error.NeedLoginError;
import vlrtstat.gg.jwt.error.TokenExpiredError;
import vlrtstat.gg.user.controller.error.DuplicatedEmailException;
import vlrtstat.gg.user.controller.error.WrongEmailAuthenticationError;
import vlrtstat.gg.user.domain.User;
import vlrtstat.gg.user.dto.LoginResponse;
import vlrtstat.gg.user.dto.RefreshTokenResponse;
import vlrtstat.gg.user.repository.UserRepository;
import vlrtstat.gg.userEmailSend.domain.UserEmailSend;
import vlrtstat.gg.userEmailSend.repository.UserEmailSendRepository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserEmailSendRepository userEmailSendRepository;
    private final JwtProvider jwtProvider;

    public UserServiceImpl(UserRepository userRepository, UserEmailSendRepository userEmailSendRepository, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.userEmailSendRepository = userEmailSendRepository;
        this.jwtProvider = jwtProvider;
    }

    @Override
    @Transactional
    public void createUser(String email, String password, String passwordCheck) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            throw new DuplicatedEmailException();
        }

        String salt = this.getSalt();

        User user = new User();
        user.setEmail(email);
        user.setPassword(this.encrypt(password, salt));
        user.setVerified(false);
        user.setSalt(salt);
        user.setCreatedAt(new Date());
        userRepository.save(user);
    }

    @Override
    public LoginResponse login(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        }

        User user = userOptional.get();

        String encryptedPassword = this.encrypt(password, user.getSalt());

        if (!encryptedPassword.equals(user.getPassword())) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        }

        String accessToken = generateAccessToken(user);
        String refreshToken = generateRefreshToken(user);

        return new LoginResponse(accessToken, refreshToken, user);
    }

    @Override
    public void verifyUser(String accessToken, String verificationCode) {
        User user = getUserFromToken(accessToken);

        Optional<UserEmailSend> optionalEmailSend = userEmailSendRepository.findFirstByUserIdOrderByExpiredAtDesc(user.getId());
        if (optionalEmailSend.isEmpty()) {
            throw new NeedLoginError();
        }

        UserEmailSend userEmailSend = optionalEmailSend.get();
        if (!userEmailSend.getCode().equals(verificationCode) || userEmailSend.getExpiredAt().isBefore(LocalDateTime.now())) {
            throw new WrongEmailAuthenticationError();
        }

        user.setVerified(true);
        userRepository.save(user);
    }

    @Override
    public RefreshTokenResponse refreshAccessToken(String refreshToken) {
        User user = getUserFromToken(refreshToken);
        Claims claims = jwtProvider.verifyToken(refreshToken);
        TokenType tokenType = TokenType.fromText(claims.get("tokenType", String.class));
        if (tokenType != TokenType.REFRESH) throw new NeedLoginError();

        String accessToken = generateAccessToken(user);
        return new RefreshTokenResponse(accessToken);
    }

    private String generateAccessToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("tokenType", TokenType.ACCESS.getText());

        LocalDateTime accessExpireDate = LocalDateTime.now().plusHours(1);
        return jwtProvider.generateToken(claims, Date.from(accessExpireDate.atZone(ZoneId.systemDefault()).toInstant()));
    }

    private String generateRefreshToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("tokenType", TokenType.REFRESH.getText());

        LocalDateTime refreshExpireDate = LocalDateTime.now().plusDays(3);
        return jwtProvider.generateToken(claims, Date.from(refreshExpireDate.atZone(ZoneId.systemDefault()).toInstant()));
    }

    private User getUserFromToken(String token) {
        try {
            Claims claims = jwtProvider.verifyToken(token);
            long userId = claims.get("userId", Integer.class);
            Optional<User> optionalUser = userRepository.findById(userId);
            if (optionalUser.isEmpty()) throw new NeedLoginError();
            return optionalUser.get();
        } catch (ExpiredJwtException e) {
            throw new TokenExpiredError();
        } catch (Exception e) {
            throw new NeedLoginError();
        }
    }
    
    public LoginResponse testLogin() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", 2);

        claims.put("tokenType", TokenType.ACCESS.toString());
        LocalDateTime accessExpireDate = LocalDateTime.now().plusMinutes(1);
        String accessToken = jwtProvider.generateToken(claims, Date.from(accessExpireDate.atZone(ZoneId.systemDefault()).toInstant()));

        claims.put("tokenType", TokenType.REFRESH.toString());
        LocalDateTime refreshExpireDate = LocalDateTime.now().plusMinutes(2);
        String refreshToken = jwtProvider.generateToken(claims, Date.from(refreshExpireDate.atZone(ZoneId.systemDefault()).toInstant()));
        User user = userRepository.findById(2L).orElse(new User());
        return new LoginResponse(accessToken, refreshToken, user);
    }

    @Override
    public void withdrawl(String accessToken) {
        User user = jwtProvider.handleToken(accessToken);
        user.setDeleted(true);
        userRepository.save(user);
    }
}
