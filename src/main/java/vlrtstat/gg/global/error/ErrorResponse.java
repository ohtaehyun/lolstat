package vlrtstat.gg.global.error;


import org.springframework.http.HttpStatus;

public class ErrorResponse {
    private int errorCode;
    private HttpStatus httpStatus;
    private String message;

    private Object data;

    public ErrorResponse(ErrorCode errorCode) {
        this.errorCode = errorCode.getErrorNumberCode();
        this.message = errorCode.getMessage();
        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public ErrorResponse(ErrorCode errorCode, HttpStatus httpStatus) {
        this.errorCode = errorCode.getErrorNumberCode();
        this.message = errorCode.getMessage();
        this.httpStatus = httpStatus;
    }

    public ErrorResponse(ErrorCode errorCode, HttpStatus httpStatus, Object data) {
        this.errorCode = errorCode.getErrorNumberCode();
        this.message = errorCode.getMessage();
        this.httpStatus = httpStatus;
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
