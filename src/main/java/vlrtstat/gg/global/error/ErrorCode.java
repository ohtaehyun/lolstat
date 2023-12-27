package vlrtstat.gg.global.error;

public enum ErrorCode {
    USER_JOIN_FAIL(1000, "회원가입 실패"),
    USER_LOGIN_FAIL(1001, "로그인 실패"),
    INPUT_ERROR(9000, "입력값이 올바르지 않습니다.");

    private int errorNumberCode;
    private String message;

    ErrorCode(int errorNumberCode, String message) {
        this.errorNumberCode = errorNumberCode;
        this.message = message;
    }

    public int getErrorNumberCode() {
        return errorNumberCode;
    }

    public String getMessage() {
        return message;
    }
}
