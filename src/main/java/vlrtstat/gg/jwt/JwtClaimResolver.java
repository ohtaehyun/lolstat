package vlrtstat.gg.jwt;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import vlrtstat.gg.user.domain.User;
import vlrtstat.gg.user.service.UserService;

@Component
public class JwtClaimResolver implements HandlerMethodArgumentResolver {
    private final JwtProvider jwtProvider;

    public JwtClaimResolver(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(LoginUser.class);
    }

    @Override
    public User resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String accessToken = jwtProvider.extractToken(webRequest.getHeader("Authorization"));
        return jwtProvider.handleToken(accessToken);
    }
}
