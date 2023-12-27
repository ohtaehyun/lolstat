package vlrtstat.gg.user.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class CreateUesrRequest {
    @Email
    private final String email;
    @Size(max=16, min=8)
    private final String password;
    @Size(max=16, min=8)
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

    @AssertTrue(message = "비밀번호가 같아야 합니다.")
    public boolean isValidSamePassword() {
        return password.equals(passwordCheck);
    }
}
