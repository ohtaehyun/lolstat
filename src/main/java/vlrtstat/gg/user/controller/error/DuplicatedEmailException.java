package vlrtstat.gg.user.controller.error;

import org.springframework.http.HttpStatus;
import vlrtstat.gg.global.error.CustomError;
import vlrtstat.gg.global.error.ErrorCode;

public class DuplicatedEmailException extends CustomError {
    public DuplicatedEmailException() {
        super(ErrorCode.USER_JOIN_FAIL, HttpStatus.BAD_REQUEST);
    }
}
