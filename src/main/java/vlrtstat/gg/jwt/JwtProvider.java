package vlrtstat.gg.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import vlrtstat.gg.jwt.error.NeedLoginError;
import vlrtstat.gg.jwt.error.TokenExpiredError;
import vlrtstat.gg.user.domain.User;
import vlrtstat.gg.user.repository.UserRepository;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Component
public class JwtProvider {
    private final SecretKey secretKey;
    private final UserRepository userRepository;

    public JwtProvider(@Value("${jwt.key}") String secret, UserRepository userRepository) {
        secretKey = Keys.hmacShaKeyFor(secret.getBytes());
        this.userRepository = userRepository;
    }

    public String generateToken(Map<String, Object> claims, Date expireDate) {
        return Jwts.builder().claims(claims).expiration(expireDate).signWith(secretKey).compact();
    }

    public Claims verifyToken(String token) {
        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload();
    }

    public String extractToken(String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new NeedLoginError();
        }

        return authorizationHeader.substring(7);
    }

    public User handleToken(String accessToken) {
        User user;

        try {
            Claims claims = verifyToken(accessToken);
            long userId = claims.get("userId", Integer.class);
            Optional<User> optionalUser = userRepository.findById(userId);
            if (optionalUser.isEmpty()) {
                throw new Exception("사용자 검색 실패");
            }
            user = optionalUser.get();
            if (user.isDeleted()) {
                throw new Exception("삭제된 유저의 토큰\nid: " + user.getId() + "\n이메일: " + user.getEmail());
            }
        } catch (ExpiredJwtException e) {
            throw new TokenExpiredError();
        } catch (Exception e) {
            System.out.println("Jwt Interceptor e = " + e);
            throw new NeedLoginError();
        }

        return user;
    }
}
