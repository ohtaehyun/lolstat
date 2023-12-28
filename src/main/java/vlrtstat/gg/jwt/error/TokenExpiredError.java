package vlrtstat.gg.jwt.error;

import org.springframework.http.HttpStatus;
import vlrtstat.gg.global.error.CustomError;
import vlrtstat.gg.global.error.ErrorCode;

public class TokenExpiredError extends CustomError {
    public TokenExpiredError() {
        super(ErrorCode.TOKEN_EXPIRED, HttpStatus.UNAUTHORIZED);
    }
}
