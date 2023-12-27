package vlrtstat.gg.global.error;

import org.springframework.http.HttpStatus;

public class CustomError extends RuntimeException {
    private ErrorCode errorCode;
    private HttpStatus httpStatus;
    private Object data = new Object();

    public CustomError(ErrorCode errorCode, HttpStatus httpStatus) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }

    public CustomError(ErrorCode errorCode, HttpStatus httpStatus, Object data) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.httpStatus =httpStatus;
        this.data = data;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public Object getData() {
        return data;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
