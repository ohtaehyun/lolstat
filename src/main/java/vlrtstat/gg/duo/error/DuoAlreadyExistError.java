package vlrtstat.gg.duo.error;

import org.springframework.http.HttpStatus;
import vlrtstat.gg.global.error.CustomError;
import vlrtstat.gg.global.error.ErrorCode;

public class DuoAlreadyExistError extends CustomError {
    public DuoAlreadyExistError() {
        super(ErrorCode.DUO_ALREADY_EXIST, HttpStatus.BAD_REQUEST);
    }
}
