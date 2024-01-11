package vlrtstat.gg.user.dto;

import vlrtstat.gg.user.domain.User;

public class UserInfoDto {
    private Long userId;
    private boolean isVerified;
    private String email;

    public UserInfoDto(User user) {
        this.userId = user.getId();
        this.email = user.getEmail();
        this.isVerified = user.isVerified();
    }

    public Long getUserId() {
        return userId;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public String getEmail() {
        return email;
    }
}
