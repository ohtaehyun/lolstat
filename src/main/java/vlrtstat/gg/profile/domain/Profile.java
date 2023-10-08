package vlrtstat.gg.profile.domain;

public class Profile {
    private String puuid;

    public Profile(String puuid) {
        this.puuid = puuid;
    }

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }
}
