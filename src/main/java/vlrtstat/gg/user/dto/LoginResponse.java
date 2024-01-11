package vlrtstat.gg.user.dto;

import vlrtstat.gg.user.domain.User;

public class LoginResponse {
    private String accessToken;
    private String refreshToken;

    private UserInfoDto userInfo;

    public LoginResponse(String accessToken, String refreshToken, User user) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.userInfo = new UserInfoDto(user);
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public UserInfoDto getUserInfo() {
        return userInfo;
    }
}
