package vlrtstat.gg.duo.error;

import org.springframework.http.HttpStatus;
import vlrtstat.gg.global.error.CustomError;
import vlrtstat.gg.global.error.ErrorCode;

public class DuoExpiredError extends CustomError {
    public DuoExpiredError() {
        super(ErrorCode.DUO_EXPIRED, HttpStatus.BAD_REQUEST);
    }
}
