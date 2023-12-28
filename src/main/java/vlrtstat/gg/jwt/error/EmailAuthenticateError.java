package vlrtstat.gg.jwt.error;

import org.springframework.http.HttpStatus;
import vlrtstat.gg.global.error.CustomError;
import vlrtstat.gg.global.error.ErrorCode;

public class EmailAuthenticateError extends CustomError {
    public EmailAuthenticateError() {
        super(ErrorCode.NEED_EMAIL_AUTHENTICATION, HttpStatus.FORBIDDEN);
    }
}
