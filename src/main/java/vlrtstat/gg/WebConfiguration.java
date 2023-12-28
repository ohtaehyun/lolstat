package vlrtstat.gg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import vlrtstat.gg.jwt.JwtInterceptor;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Autowired
    private JwtInterceptor jwtInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowedOriginPatterns("https://*.lolstat.net,https://localhost:[*],http://localhost:[*]");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor).excludePathPatterns(
                "/leaderboard/**",
                "/user/login",
                "/user",
                "/matches/**",
                "/summoner/**",
                "/api-docs",
                "/swagger-ui/**",
                "/v3/api-docs/**",
                "/error"
        );
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
