package vlrtstat.gg.duo.error;

import org.springframework.http.HttpStatus;
import vlrtstat.gg.global.error.CustomError;
import vlrtstat.gg.global.error.ErrorCode;

public class DuoOwnerTryTicketError extends CustomError {
    public DuoOwnerTryTicketError() {
        super(ErrorCode.DUO_OWNER_TRY_TICKET, HttpStatus.BAD_REQUEST);
    }
}
