package vlrtstat.gg.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import vlrtstat.gg.jwt.error.EmailAuthenticateError;
import vlrtstat.gg.jwt.error.NeedLoginError;
import vlrtstat.gg.jwt.error.TokenExpiredError;
import vlrtstat.gg.user.domain.User;
import vlrtstat.gg.user.repository.UserRepository;
import vlrtstat.gg.userEmailSend.service.UserEmailSendService;

import java.util.Optional;

@Component
public class JwtInterceptor implements HandlerInterceptor {
    private final JwtProvider jwtProvider;

    private final UserEmailSendService userEmailSendService;

    public JwtInterceptor(JwtProvider jwtProvider, UserEmailSendService userEmailSendService) {
        this.jwtProvider = jwtProvider;
        this.userEmailSendService = userEmailSendService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (HttpMethod.OPTIONS.matches(request.getMethod())) {
            return true;
        }
        String authorizationHeader = request.getHeader("Authorization");

        String accessToken = jwtProvider.extractToken(authorizationHeader);
        User user = jwtProvider.handleToken(accessToken);

        if (!request.getRequestURI().equals("/user/verify") && !user.isVerified()) {
            userEmailSendService.sendAuthenticateEmail(user);
            throw new EmailAuthenticateError();
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
