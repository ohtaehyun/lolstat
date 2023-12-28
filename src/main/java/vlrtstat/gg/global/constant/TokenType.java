package vlrtstat.gg.global.constant;

public enum TokenType {
    REFRESH("REFRESH"),
    ACCESS("ACCESS");

    private final String text;

    TokenType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static TokenType fromText(String text) {
        for (TokenType tokenType : values()) {
            if (tokenType.getText().equals(text)) return tokenType;
        }
        throw new RuntimeException("정의되지 않은 토큰 타입");
    }
}
