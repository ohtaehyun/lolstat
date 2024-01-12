package vlrtstat.gg.global.error;

public enum ErrorCode {
    USER_JOIN_FAIL(1000, "회원가입 실패"),
    USER_LOGIN_FAIL(1001, "로그인 실패"),
    NEED_LOGIN(1002, "로그인 필요"),
    NEED_EMAIL_AUTHENTICATION(1003, "이메일 인증 필요"),
    WRONG_EMAIL_AUTHENTICATION(1004, "이메일 인증 오류"),
    TOKEN_EXPIRED(1005, "만료된 토큰"),
    DUO_ALREADY_EXIST(2000, "이미 등록한 듀오 찾기가 존재합니다."),
    DUO_EXPIRED(2001, "만료된 듀오 찾기 입니다."),
    DUO_ALREADY_MATCHED(2002, "이미 매칭이 종료된 듀오입니다."),
    DUO_OWNER_TRY_TICKET(2003, "본인의 듀오 찾기에 본인이 신청 할 수 없습니다."),
    DUO_TICKET_ALREADY_EXIST(2004, "이미 신청한 듀오찾기 입니다."),
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
