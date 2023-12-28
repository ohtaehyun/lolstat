package vlrtstat.gg.jwt.error;

import org.springframework.http.HttpStatus;
import vlrtstat.gg.global.error.CustomError;
import vlrtstat.gg.global.error.ErrorCode;

public class NeedLoginError extends CustomError {
    public NeedLoginError() {
        super(ErrorCode.NEED_LOGIN, HttpStatus.UNAUTHORIZED);
    }
}