package vlrtstat.gg.duo.error;

import org.springframework.http.HttpStatus;
import vlrtstat.gg.global.error.CustomError;
import vlrtstat.gg.global.error.ErrorCode;

public class DuoAlreadyMatchedError extends CustomError {
    public DuoAlreadyMatchedError() {
        super(ErrorCode.DUO_ALREADY_MATCHED, HttpStatus.BAD_REQUEST);
    }
}
