package vlrtstat.gg.jwt;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import vlrtstat.gg.jwt.error.NeedLoginError;
import vlrtstat.gg.user.repository.UserRepository;

@Component
public class JwtInterceptor implements HandlerInterceptor {
    private JwtProvider jwtProvider;

    private UserRepository userRepository;

    public JwtInterceptor(JwtProvider jwtProvider, UserRepository userRepository) {
        this.jwtProvider = jwtProvider;
        this.userRepository = userRepository;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new NeedLoginError();
        }

        String accessToken = authorizationHeader.substring(7);

        try {
            Claims claims = jwtProvider.verifyToken(accessToken);
        } catch (Exception e) {
            System.out.println("Jwt Interceptor e = " + e);
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
