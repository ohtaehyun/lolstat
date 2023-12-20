package vlrtstat.gg.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Component
public class JwtProvider {
    private final SecretKey secretKey;

    public JwtProvider(@Value("${jwt.key}") String secret) {
        secretKey = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateToken(Map<String, Object> claims, Date expireDate) {
        return Jwts.builder().claims(claims).expiration(expireDate).signWith(secretKey).compact();
    }

    public Claims verifyToken(String token) {
        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload();
    }
}
