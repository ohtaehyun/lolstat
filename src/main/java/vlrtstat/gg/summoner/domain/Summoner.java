package vlrtstat.gg.summoner.domain;

public class Summoner {
    String accountId;
    int profileIconId;
    Long revisionDate;
    String name;
    String id;
    String puuid;
    Long summonerName;

    public Summoner(String accountId, int profileIconId, Long revisionDate, String name, String id, String puuid, Long summonerName) {
        this.accountId = accountId;
        this.profileIconId = profileIconId;
        this.revisionDate = revisionDate;
        this.name = name;
        this.id = id;
        this.puuid = puuid;
        this.summonerName = summonerName;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(int profileIconId) {
        this.profileIconId = profileIconId;
    }

    public Long getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(Long revisionDate) {
        this.revisionDate = revisionDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public Long getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(Long summonerName) {
        this.summonerName = summonerName;
    }
}
