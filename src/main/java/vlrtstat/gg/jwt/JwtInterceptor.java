package vlrtstat.gg.jwt;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import vlrtstat.gg.jwt.error.NeedLoginError;
import vlrtstat.gg.user.domain.User;
import vlrtstat.gg.user.repository.UserRepository;
import vlrtstat.gg.userEmailSend.service.UserEmailSendService;

import java.util.Optional;

@Component
public class JwtInterceptor implements HandlerInterceptor {
    private final JwtProvider jwtProvider;

    private final UserRepository userRepository;

    private final UserEmailSendService userEmailSendService;

    public JwtInterceptor(JwtProvider jwtProvider, UserRepository userRepository, UserEmailSendService userEmailSendService) {
        this.jwtProvider = jwtProvider;
        this.userRepository = userRepository;
        this.userEmailSendService = userEmailSendService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new NeedLoginError();
        }

        String accessToken = authorizationHeader.substring(7);
        User user;

        try {
            Claims claims = jwtProvider.verifyToken(accessToken);
            long userId = claims.get("userId", Integer.class);
            Optional<User> optionalUser = userRepository.findById(userId);
            if (optionalUser.isEmpty()) {
                throw new Exception("사용자 검색 실패");
            }
            user = optionalUser.get();
        } catch (Exception e) {
            System.out.println("Jwt Interceptor e = " + e);
            throw new NeedLoginError();
        }
        
        if (!user.isVerified()) {
            userEmailSendService.sendAuthenticateEmail(user);
            System.out.println("user.isVerified() = " + user.isVerified());
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
