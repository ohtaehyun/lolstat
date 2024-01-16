package vlrtstat.gg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import vlrtstat.gg.duo.constant.DuoMatchFilterConverter;
import vlrtstat.gg.global.converter.QueueIdFilterConverter;
import vlrtstat.gg.jwt.JwtClaimResolver;
import vlrtstat.gg.jwt.JwtInterceptor;

import java.util.List;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Autowired
    private JwtInterceptor jwtInterceptor;

    @Autowired
    private  JwtClaimResolver jwtClaimResolver;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowCredentials(true)
                .allowedOriginPatterns("https://*.lolstat.net,https://localhost:[*],http://localhost:[*]");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        WebMvcConfigurer.super.addArgumentResolvers(resolvers);
        resolvers.add(jwtClaimResolver);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor).excludePathPatterns(
                "/leaderboard/**",
                "/user/login",
                "/user",
                "/user/refresh",
                "/user/login/test",
                "/matches/**",
                "/summoner/**",
                "/api-docs",
                "/swagger-ui/**",
                "/v3/api-docs/**",
                "/error"
        );
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        WebMvcConfigurer.super.addFormatters(registry);
        registry.addConverter(new QueueIdFilterConverter());
        registry.addConverter(new DuoMatchFilterConverter());
    }
}
