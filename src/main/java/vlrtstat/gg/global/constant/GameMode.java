package vlrtstat.gg.global.constant;

public enum GameMode {
    CLASSIC,
    ODIN,
    ARAM,
    TUTORIAL,
    URF,
    DOOMBOTSTEEMO,
    ONEFORALL,
    ASCENSION,
    FIRSTBLOOD,
    KINGPORO,
    SIEGE,
    ASSASSINATE,
    ARSR,
    DARKSTAR,
    STARGUARDIAN,
    PROJECT,
    GAMEMODEX,
    ODYSSEY,
    NEXUSBLITZ,
    ULTBOOK,
    CHERRY,
    UNKNOWN;

    public static GameMode fromString(String mode) {
        for (GameMode gameMode : values()) {
            if (gameMode.toString().equals(mode)) return gameMode;
        }
        return UNKNOWN;
    }
}