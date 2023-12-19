package vlrtstat.gg.user.dto;

public class CreateUesrRequest {
    private final String email;
    private final String password;
    private final String passwordCheck;

    public CreateUesrRequest(String email, String password, String passwordCheck) {
        this.email = email;
        this.password = password;
        this.passwordCheck = passwordCheck;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordCheck() {
        return passwordCheck;
    }
}
