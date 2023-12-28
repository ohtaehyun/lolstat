package vlrtstat.gg.user.service;


import io.jsonwebtoken.Claims;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import vlrtstat.gg.jwt.JwtProvider;
import vlrtstat.gg.user.controller.error.DuplicatedEmailException;
import vlrtstat.gg.user.domain.User;
import vlrtstat.gg.user.dto.LoginRequest;
import vlrtstat.gg.user.dto.LoginResponse;
import vlrtstat.gg.user.repository.UserRepository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    public UserServiceImpl(UserRepository userRepository, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
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

        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());

        LocalDateTime accessExpireDate = LocalDateTime.now().plusMinutes(240);
        String accessToken = jwtProvider.generateToken(claims, Date.from(accessExpireDate.atZone(ZoneId.systemDefault()).toInstant()));

        LocalDateTime refreshExpireDate = LocalDateTime.now().plusDays(3);
        String refreshToken = jwtProvider.generateToken(claims, Date.from(refreshExpireDate.atZone(ZoneId.systemDefault()).toInstant()));


        return new LoginResponse(accessToken, refreshToken);
    }
}
