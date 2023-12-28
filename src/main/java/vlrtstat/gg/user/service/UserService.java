package vlrtstat.gg.user.service;

import vlrtstat.gg.user.dto.LoginResponse;
import vlrtstat.gg.user.dto.RefreshTokenResponse;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public interface UserService {
    void createUser(String email, String password, String passwordCheck);
    LoginResponse login(String email, String password);
    default String getSalt() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);

        StringBuilder sb = new StringBuilder();
        for (byte b : salt) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }

    default String encrypt(String str, String salt) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update((str + salt).getBytes());
            byte[] digest = messageDigest.digest();

            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : digest) {
                stringBuilder.append(String.format("%02x", b));
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    void verifyUser(String accessToken, String verificationCode);

    RefreshTokenResponse refreshAccessToken(String refreshToken);

    LoginResponse testLogin();
}
