package vlrtstat.gg.summoner.domain;

import vlrtstat.gg.global.store.PropertyStore;

public class Summoner {
    private String gameName;
    private String tagLine;
    private String accountId;
    private int profileIconId;
    private Long revisionDate;
    private String name;
    private String id;
    private String puuid;
    private Long summonerLevel;

    public Summoner(String accountId, int profileIconId, Long revisionDate, String name, String id, String puuid, Long summonerLevel) {
        this.setAccountId(accountId);
        this.setProfileIconId(profileIconId);
        this.setRevisionDate(revisionDate);
        this.setName(name);
        this.setId(id);
        this.setPuuid(puuid);
        this.setSummonerLevel(summonerLevel);
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

    public Long getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(Long summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    public String getProfileIconUrl() {
        return PropertyStore.getProperty("aws.s3.url") + "/profileicon/" + profileIconId + ".png";
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getTagLine() {
        return tagLine;
    }

    public void setTagLine(String tagLine) {
        this.tagLine = tagLine;
    }
}
