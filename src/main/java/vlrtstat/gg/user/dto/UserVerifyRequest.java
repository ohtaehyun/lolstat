package vlrtstat.gg.user.dto;


import jakarta.validation.constraints.Size;

import java.beans.ConstructorProperties;

public class UserVerifyRequest {
    @Size(max = 8, min = 8)
    private final String verificationCode;

    @ConstructorProperties({"verificationCode"})
    public UserVerifyRequest(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getVerificationCode() {
        return verificationCode;
    }
}
