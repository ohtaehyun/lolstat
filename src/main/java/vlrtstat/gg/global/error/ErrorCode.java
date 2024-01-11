package vlrtstat.gg.global.error;

public enum ErrorCode {
    USER_JOIN_FAIL(1000, "회원가입 실패"),
    USER_LOGIN_FAIL(1001, "로그인 실패"),
    NEED_LOGIN(1002, "로그인 필요"),
    NEED_EMAIL_AUTHENTICATION(1003, "이메일 인증 필요"),
    WRONG_EMAIL_AUTHENTICATION(1004, "이메일 인증 오류"),
    TOKEN_EXPIRED(1005, "만료된 토큰"),
    DUO_ALREADY_EXIST(2000, "이미 등록한 듀오 찾기가 존재합니다."),
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
