package vlrtstat.gg.user.dto;

public class RefreshTokenResponse {
    private final String accessToken;

    public RefreshTokenResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
