package vlrtstat.gg.user.controller.error;

import org.springframework.http.HttpStatus;
import vlrtstat.gg.global.error.CustomError;
import vlrtstat.gg.global.error.ErrorCode;

public class WrongEmailAuthenticationError extends CustomError {

    public WrongEmailAuthenticationError() {
        super(ErrorCode.WRONG_EMAIL_AUTHENTICATION, HttpStatus.BAD_REQUEST);
    }
}
