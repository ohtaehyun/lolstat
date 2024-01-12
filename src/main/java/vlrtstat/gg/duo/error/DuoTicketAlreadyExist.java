package vlrtstat.gg.duo.error;

import org.springframework.http.HttpStatus;
import vlrtstat.gg.global.error.CustomError;
import vlrtstat.gg.global.error.ErrorCode;

public class DuoTicketAlreadyExist extends CustomError {
    public DuoTicketAlreadyExist() {
        super(ErrorCode.DUO_TICKET_ALREADY_EXIST, HttpStatus.BAD_REQUEST);
    }
}
