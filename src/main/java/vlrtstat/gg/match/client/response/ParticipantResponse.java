package vlrtstat.gg.match.client.response;

import vlrtstat.gg.champion.domain.Champion;
import vlrtstat.gg.item.domain.Item;
import vlrtstat.gg.match.domain.Perk;
import vlrtstat.gg.match.domain.PerkStyle;
import vlrtstat.gg.participant.domain.Participant;
import vlrtstat.gg.rune.domain.Rune;
import vlrtstat.gg.rune.domain.RuneGroup;
import vlrtstat.gg.spell.domain.Spell;

public class ParticipantResponse {
    private int assists;
    private int baronKills;
    private int bountyLebel;
    private int champExperience;
    private int champLevel;
    private int championId;
    private String championName;
    private int championTransform;
    private int consumablesPurchased;
    private int damageDealtToBuildings;
    private int damageDealtToObjectives;
    private int damageDealtToTurrets;
    private int damageSelfMitigated;
    private int deaths;
    private int detectorWardsPlaced;
    private int doubleKills;
    private int dragonKills;
    private boolean firstBloodAssist;
    private boolean firstBloodKill;
    private boolean firstTowerAssist;
    private boolean firstTowerKill;
    private boolean gameEndedInEarlySurrender;
    private boolean gameEndedInSurrender;
    private int goldEarned;
    private int goldSpent;
    private String individualPosition;
    private int inhibitorKills;
    private int inhibitorTakedowns;
    private int inhibitorsLost;
    private int item0;
    private int item1;
    private int item2;
    private int item3;
    private int item4;
    private int item5;
    private int item6;
    private int itemsPurchased;
    private int killingSprees;
    private int kills;
    private String lane;
    private int largestCriticalStrike;
    private int largestKillingSpree;
    private int largestMultiKill;
    private int longestTimeSpentLiving;
    private int magicDamageDealt;
    private int magicDamageDealtToChampions;
    private int magicDamageTaken;
    private int neutralMinionsKilled;
    private int nexusKills;
    private int nexusTakedowns;
    private int nexusLost;
    private int objectivesStolen;
    private int objectivesStolenAssists;
    private int participantId;
    private int pentaKills;
    private Perk perks;
    private int physicalDamageDealt;
    private int physicalDamageDealtToChampions;
    private int physicalDamageTaken;
    private int profileIcon;
    private String puuid;
    private int quadraKills;
    private String riotName;
    private String riotIdTagline;
    private String role;
    private int sightWardsBoughtInGame;
    private int spell1Casts;
    private int spell2Casts;
    private int spell3Casts;
    private int spell4Casts;
    private int summoner1Casts;
    private int summoner1Id;
    private int summoner2Casts;
    private int summoner2Id;
    private String summonerId;
    private int summonerLevel;
    private String summonerName;
    private boolean teamEarlySurrendered;
    private int teamId;
    private String teamPosition;
    private int timeCCingOthers;
    private int timePlayed;
    private int totalDamageDealt;
    private int totalDamageDealtToChampions;
    private int totalDamageShieldedOnTeammates;
    private int totalDamageTaken;
    private int totalHeal;
    private int totalHealsOnTeammates;
    private int totalMinionsKilled;
    private int totalTimeCCDealt;
    private int totalTimeSpentDead;
    private int totalUnitsHealed;
    private int tripleKills;
    private int trueDamageDealt;
    private int trueDamageDealtToChampions;
    private int trueDamageTaken;
    private int turretKills;
    private int turretTakedowns;
    private int turretsLost;
    private int unrealKills;
    private int visionScore;
    private int visionWardsBoughtInGame;
    private int wardsKilled;
    private int wardsPlaced;
    private boolean win;
    private Item[] items;
    private Spell[] spells;
    private Champion champion;
    private Rune mainRune;
    private RuneGroup subRuneGroup;

    public ParticipantResponse(int assists, int baronKills, int bountyLebel, int champExperience, int champLevel, int championId, String championName, int championTransform, int consumablesPurchased, int damageDealtToBuildings, int damageDealtToObjectives, int damageDealtToTurrets, int damageSelfMitigated, int deaths, int detectorWardsPlaced, int doubleKills, int dragonKills, boolean firstBloodAssist, boolean firstBloodKill, boolean firstTowerAssist, boolean firstTowerKill, boolean gameEndedInEarlySurrender, boolean gameEndedInSurrender, int goldEarned, int goldSpent, String individualPosition, int inhibitorKills, int inhibitorTakedowns, int inhibitorsLost, int item0, int item1, int item2, int item3, int item4, int item5, int item6, int itemsPurchased, int killingSprees, int kills, String lane, int largestCriticalStrike, int largestKillingSpree, int largestMultiKill, int longestTimeSpentLiving, int magicDamageDealt, int magicDamageDealtToChampions, int magicDamageTaken, int neutralMinionsKilled, int nexusKills, int nexusTakedowns, int nexusLost, int objectivesStolen, int objectivesStolenAssists, int participantId, int pentaKills, Perk perks, int physicalDamageDealt, int physicalDamageDealtToChampions, int physicalDamageTaken, int profileIcon, String puuid, int quadraKills, String riotName, String riotIdTagline, String role, int sightWardsBoughtInGame, int spell1Casts, int spell2Casts, int spell3Casts, int spell4Casts, int summoner1Casts, int summoner1Id, int summoner2Casts, int summoner2Id, String summonerId, int summonerLevel, String summonerName, boolean teamEarlySurrendered, int teamId, String teamPosition, int timeCCingOthers, int timePlayed, int totalDamageDealt, int totalDamageDealtToChampions, int totalDamageShieldedOnTeammates, int totalDamageTaken, int totalHeal, int totalHealsOnTeammates, int totalMinionsKilled, int totalTimeCCDealt, int totalTimeSpentDead, int totalUnitsHealed, int tripleKills, int trueDamageDealt, int trueDamageDealtToChampions, int trueDamageTaken, int turretKills, int turretTakedowns, int turretsLost, int unrealKills, int visionScore, int visionWardsBoughtInGame, int wardsKilled, int wardsPlaced, boolean win) {
        this.setAssists(assists);
        this.setBaronKills(baronKills);
        this.setBountyLebel(bountyLebel);
        this.setChampExperience(champExperience);
        this.setChampLevel(champLevel);
        this.setChampionId(championId);
        this.setChampionName(championName);
        this.setChampionTransform(championTransform);
        this.setConsumablesPurchased(consumablesPurchased);
        this.setDamageDealtToBuildings(damageDealtToBuildings);
        this.setDamageDealtToObjectives(damageDealtToObjectives);
        this.setDamageDealtToTurrets(damageDealtToTurrets);
        this.setDamageSelfMitigated(damageSelfMitigated);
        this.setDeaths(deaths);
        this.setDetectorWardsPlaced(detectorWardsPlaced);
        this.setDoubleKills(doubleKills);
        this.setDragonKills(dragonKills);
        this.setFirstBloodAssist(firstBloodAssist);
        this.setFirstBloodKill(firstBloodKill);
        this.setFirstTowerAssist(firstTowerAssist);
        this.setFirstTowerKill(firstTowerKill);
        this.setGameEndedInEarlySurrender(gameEndedInEarlySurrender);
        this.setGameEndedInSurrender(gameEndedInSurrender);
        this.setGoldEarned(goldEarned);
        this.setGoldSpent(goldSpent);
        this.setIndividualPosition(individualPosition);
        this.setInhibitorKills(inhibitorKills);
        this.setInhibitorTakedowns(inhibitorTakedowns);
        this.setInhibitorsLost(inhibitorsLost);
        this.setItem0(item0);
        this.setItem1(item1);
        this.setItem2(item2);
        this.setItem3(item3);
        this.setItem4(item4);
        this.setItem5(item5);
        this.setItem6(item6);
        this.setItemsPurchased(itemsPurchased);
        this.setKillingSprees(killingSprees);
        this.setKills(kills);
        this.setLane(lane);
        this.setLargestCriticalStrike(largestCriticalStrike);
        this.setLargestKillingSpree(largestKillingSpree);
        this.setLargestMultiKill(largestMultiKill);
        this.setLongestTimeSpentLiving(longestTimeSpentLiving);
        this.setMagicDamageDealt(magicDamageDealt);
        this.setMagicDamageDealtToChampions(magicDamageDealtToChampions);
        this.setMagicDamageTaken(magicDamageTaken);
        this.setNeutralMinionsKilled(neutralMinionsKilled);
        this.setNexusKills(nexusKills);
        this.setNexusTakedowns(nexusTakedowns);
        this.setNexusLost(nexusLost);
        this.setObjectivesStolen(objectivesStolen);
        this.setObjectivesStolenAssists(objectivesStolenAssists);
        this.setParticipantId(participantId);
        this.setPentaKills(pentaKills);
        this.setPerks(perks);
        this.setPhysicalDamageDealt(physicalDamageDealt);
        this.setPhysicalDamageDealtToChampions(physicalDamageDealtToChampions);
        this.setPhysicalDamageTaken(physicalDamageTaken);
        this.setProfileIcon(profileIcon);
        this.setPuuid(puuid);
        this.setQuadraKills(quadraKills);
        this.setRiotName(riotName);
        this.setRiotIdTagline(riotIdTagline);
        this.setRole(role);
        this.setSightWardsBoughtInGame(sightWardsBoughtInGame);
        this.setSpell1Casts(spell1Casts);
        this.setSpell2Casts(spell2Casts);
        this.setSpell3Casts(spell3Casts);
        this.setSpell4Casts(spell4Casts);
        this.setSummoner1Casts(summoner1Casts);
        this.setSummoner1Id(summoner1Id);
        this.setSummoner2Casts(summoner2Casts);
        this.setSummoner2Id(summoner2Id);
        this.setSummonerId(summonerId);
        this.setSummonerLevel(summonerLevel);
        this.setSummonerName(summonerName);
        this.setTeamEarlySurrendered(teamEarlySurrendered);
        this.setTeamId(teamId);
        this.setTeamPosition(teamPosition);
        this.setTimeCCingOthers(timeCCingOthers);
        this.setTimePlayed(timePlayed);
        this.setTotalDamageDealt(totalDamageDealt);
        this.setTotalDamageDealtToChampions(totalDamageDealtToChampions);
        this.setTotalDamageShieldedOnTeammates(totalDamageShieldedOnTeammates);
        this.setTotalDamageTaken(totalDamageTaken);
        this.setTotalHeal(totalHeal);
        this.setTotalHealsOnTeammates(totalHealsOnTeammates);
        this.setTotalMinionsKilled(totalMinionsKilled);
        this.setTotalTimeCCDealt(totalTimeCCDealt);
        this.setTotalTimeSpentDead(totalTimeSpentDead);
        this.setTotalUnitsHealed(totalUnitsHealed);
        this.setTripleKills(tripleKills);
        this.setTrueDamageDealt(trueDamageDealt);
        this.setTrueDamageDealtToChampions(trueDamageDealtToChampions);
        this.setTrueDamageTaken(trueDamageTaken);
        this.setTurretKills(turretKills);
        this.setTurretTakedowns(turretTakedowns);
        this.setTurretsLost(turretsLost);
        this.setUnrealKills(unrealKills);
        this.setVisionScore(visionScore);
        this.setVisionWardsBoughtInGame(visionWardsBoughtInGame);
        this.setWardsKilled(wardsKilled);
        this.setWardsPlaced(wardsPlaced);
        this.setWin(win);
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getBaronKills() {
        return baronKills;
    }

    public void setBaronKills(int baronKills) {
        this.baronKills = baronKills;
    }

    public int getBountyLebel() {
        return bountyLebel;
    }

    public void setBountyLebel(int bountyLebel) {
        this.bountyLebel = bountyLebel;
    }

    public int getChampExperience() {
        return champExperience;
    }

    public void setChampExperience(int champExperience) {
        this.champExperience = champExperience;
    }

    public int getChampLevel() {
        return champLevel;
    }

    public void setChampLevel(int champLevel) {
        this.champLevel = champLevel;
    }

    public int getChampionId() {
        return championId;
    }

    public void setChampionId(int championId) {
        this.championId = championId;
    }

    public String getChampionName() {
        return championName;
    }

    public void setChampionName(String championName) {
        this.championName = championName;
    }

    public int getChampionTransform() {
        return championTransform;
    }

    public void setChampionTransform(int championTransform) {
        this.championTransform = championTransform;
    }

    public int getConsumablesPurchased() {
        return consumablesPurchased;
    }

    public void setConsumablesPurchased(int consumablesPurchased) {
        this.consumablesPurchased = consumablesPurchased;
    }

    public int getDamageDealtToBuildings() {
        return damageDealtToBuildings;
    }

    public void setDamageDealtToBuildings(int damageDealtToBuildings) {
        this.damageDealtToBuildings = damageDealtToBuildings;
    }

    public int getDamageDealtToObjectives() {
        return damageDealtToObjectives;
    }

    public void setDamageDealtToObjectives(int damageDealtToObjectives) {
        this.damageDealtToObjectives = damageDealtToObjectives;
    }

    public int getDamageDealtToTurrets() {
        return damageDealtToTurrets;
    }

    public void setDamageDealtToTurrets(int damageDealtToTurrets) {
        this.damageDealtToTurrets = damageDealtToTurrets;
    }

    public int getDamageSelfMitigated() {
        return damageSelfMitigated;
    }

    public void setDamageSelfMitigated(int damageSelfMitigated) {
        this.damageSelfMitigated = damageSelfMitigated;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getDetectorWardsPlaced() {
        return detectorWardsPlaced;
    }

    public void setDetectorWardsPlaced(int detectorWardsPlaced) {
        this.detectorWardsPlaced = detectorWardsPlaced;
    }

    public int getDoubleKills() {
        return doubleKills;
    }

    public void setDoubleKills(int doubleKills) {
        this.doubleKills = doubleKills;
    }

    public int getDragonKills() {
        return dragonKills;
    }

    public void setDragonKills(int dragonKills) {
        this.dragonKills = dragonKills;
    }

    public boolean isFirstBloodAssist() {
        return firstBloodAssist;
    }

    public void setFirstBloodAssist(boolean firstBloodAssist) {
        this.firstBloodAssist = firstBloodAssist;
    }

    public boolean isFirstBloodKill() {
        return firstBloodKill;
    }

    public void setFirstBloodKill(boolean firstBloodKill) {
        this.firstBloodKill = firstBloodKill;
    }

    public boolean isFirstTowerAssist() {
        return firstTowerAssist;
    }

    public void setFirstTowerAssist(boolean firstTowerAssist) {
        this.firstTowerAssist = firstTowerAssist;
    }

    public boolean isFirstTowerKill() {
        return firstTowerKill;
    }

    public void setFirstTowerKill(boolean firstTowerKill) {
        this.firstTowerKill = firstTowerKill;
    }

    public boolean isGameEndedInEarlySurrender() {
        return gameEndedInEarlySurrender;
    }

    public void setGameEndedInEarlySurrender(boolean gameEndedInEarlySurrender) {
        this.gameEndedInEarlySurrender = gameEndedInEarlySurrender;
    }

    public boolean isGameEndedInSurrender() {
        return gameEndedInSurrender;
    }

    public void setGameEndedInSurrender(boolean gameEndedInSurrender) {
        this.gameEndedInSurrender = gameEndedInSurrender;
    }

    public int getGoldEarned() {
        return goldEarned;
    }

    public void setGoldEarned(int goldEarned) {
        this.goldEarned = goldEarned;
    }

    public int getGoldSpent() {
        return goldSpent;
    }

    public void setGoldSpent(int goldSpent) {
        this.goldSpent = goldSpent;
    }

    public String getIndividualPosition() {
        return individualPosition;
    }

    public void setIndividualPosition(String individualPosition) {
        this.individualPosition = individualPosition;
    }

    public int getInhibitorKills() {
        return inhibitorKills;
    }

    public void setInhibitorKills(int inhibitorKills) {
        this.inhibitorKills = inhibitorKills;
    }

    public int getInhibitorTakedowns() {
        return inhibitorTakedowns;
    }

    public void setInhibitorTakedowns(int inhibitorTakedowns) {
        this.inhibitorTakedowns = inhibitorTakedowns;
    }

    public int getInhibitorsLost() {
        return inhibitorsLost;
    }

    public void setInhibitorsLost(int inhibitorsLost) {
        this.inhibitorsLost = inhibitorsLost;
    }

    public int getItem0() {
        return item0;
    }

    public void setItem0(int item0) {
        this.item0 = item0;
    }

    public int getItem1() {
        return item1;
    }

    public void setItem1(int item1) {
        this.item1 = item1;
    }

    public int getItem2() {
        return item2;
    }

    public void setItem2(int item2) {
        this.item2 = item2;
    }

    public int getItem3() {
        return item3;
    }

    public void setItem3(int item3) {
        this.item3 = item3;
    }

    public int getItem4() {
        return item4;
    }

    public void setItem4(int item4) {
        this.item4 = item4;
    }

    public int getItem5() {
        return item5;
    }

    public void setItem5(int item5) {
        this.item5 = item5;
    }

    public int getItem6() {
        return item6;
    }

    public void setItem6(int item6) {
        this.item6 = item6;
    }

    public int getItemsPurchased() {
        return itemsPurchased;
    }

    public void setItemsPurchased(int itemsPurchased) {
        this.itemsPurchased = itemsPurchased;
    }

    public int getKillingSprees() {
        return killingSprees;
    }

    public void setKillingSprees(int killingSprees) {
        this.killingSprees = killingSprees;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    public int getLargestCriticalStrike() {
        return largestCriticalStrike;
    }

    public void setLargestCriticalStrike(int largestCriticalStrike) {
        this.largestCriticalStrike = largestCriticalStrike;
    }

    public int getLargestKillingSpree() {
        return largestKillingSpree;
    }

    public void setLargestKillingSpree(int largestKillingSpree) {
        this.largestKillingSpree = largestKillingSpree;
    }

    public int getLargestMultiKill() {
        return largestMultiKill;
    }

    public void setLargestMultiKill(int largestMultiKill) {
        this.largestMultiKill = largestMultiKill;
    }

    public int getLongestTimeSpentLiving() {
        return longestTimeSpentLiving;
    }

    public void setLongestTimeSpentLiving(int longestTimeSpentLiving) {
        this.longestTimeSpentLiving = longestTimeSpentLiving;
    }

    public int getMagicDamageDealt() {
        return magicDamageDealt;
    }

    public void setMagicDamageDealt(int magicDamageDealt) {
        this.magicDamageDealt = magicDamageDealt;
    }

    public int getMagicDamageDealtToChampions() {
        return magicDamageDealtToChampions;
    }

    public void setMagicDamageDealtToChampions(int magicDamageDealtToChampions) {
        this.magicDamageDealtToChampions = magicDamageDealtToChampions;
    }

    public int getMagicDamageTaken() {
        return magicDamageTaken;
    }

    public void setMagicDamageTaken(int magicDamageTaken) {
        this.magicDamageTaken = magicDamageTaken;
    }

    public int getNeutralMinionsKilled() {
        return neutralMinionsKilled;
    }

    public void setNeutralMinionsKilled(int neutralMinionsKilled) {
        this.neutralMinionsKilled = neutralMinionsKilled;
    }

    public int getNexusKills() {
        return nexusKills;
    }

    public void setNexusKills(int nexusKills) {
        this.nexusKills = nexusKills;
    }

    public int getNexusTakedowns() {
        return nexusTakedowns;
    }

    public void setNexusTakedowns(int nexusTakedowns) {
        this.nexusTakedowns = nexusTakedowns;
    }

    public int getNexusLost() {
        return nexusLost;
    }

    public void setNexusLost(int nexusLost) {
        this.nexusLost = nexusLost;
    }

    public int getObjectivesStolen() {
        return objectivesStolen;
    }

    public void setObjectivesStolen(int objectivesStolen) {
        this.objectivesStolen = objectivesStolen;
    }

    public int getObjectivesStolenAssists() {
        return objectivesStolenAssists;
    }

    public void setObjectivesStolenAssists(int objectivesStolenAssists) {
        this.objectivesStolenAssists = objectivesStolenAssists;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public int getPentaKills() {
        return pentaKills;
    }

    public void setPentaKills(int pentaKills) {
        this.pentaKills = pentaKills;
    }

    public Perk getPerks() {
        return perks;
    }

    public void setPerks(Perk perks) {
        this.perks = perks;
    }

    public int getPhysicalDamageDealt() {
        return physicalDamageDealt;
    }

    public void setPhysicalDamageDealt(int physicalDamageDealt) {
        this.physicalDamageDealt = physicalDamageDealt;
    }

    public int getPhysicalDamageDealtToChampions() {
        return physicalDamageDealtToChampions;
    }

    public void setPhysicalDamageDealtToChampions(int physicalDamageDealtToChampions) {
        this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
    }

    public int getPhysicalDamageTaken() {
        return physicalDamageTaken;
    }

    public void setPhysicalDamageTaken(int physicalDamageTaken) {
        this.physicalDamageTaken = physicalDamageTaken;
    }

    public int getProfileIcon() {
        return profileIcon;
    }

    public void setProfileIcon(int profileIcon) {
        this.profileIcon = profileIcon;
    }

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public int getQuadraKills() {
        return quadraKills;
    }

    public void setQuadraKills(int quadraKills) {
        this.quadraKills = quadraKills;
    }

    public String getRiotName() {
        return riotName;
    }

    public void setRiotName(String riotName) {
        this.riotName = riotName;
    }

    public String getRiotIdTagline() {
        return riotIdTagline;
    }

    public void setRiotIdTagline(String riotIdTagline) {
        this.riotIdTagline = riotIdTagline;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getSightWardsBoughtInGame() {
        return sightWardsBoughtInGame;
    }

    public void setSightWardsBoughtInGame(int sightWardsBoughtInGame) {
        this.sightWardsBoughtInGame = sightWardsBoughtInGame;
    }

    public int getSpell1Casts() {
        return spell1Casts;
    }

    public void setSpell1Casts(int spell1Casts) {
        this.spell1Casts = spell1Casts;
    }

    public int getSpell2Casts() {
        return spell2Casts;
    }

    public void setSpell2Casts(int spell2Casts) {
        this.spell2Casts = spell2Casts;
    }

    public int getSpell3Casts() {
        return spell3Casts;
    }

    public void setSpell3Casts(int spell3Casts) {
        this.spell3Casts = spell3Casts;
    }

    public int getSpell4Casts() {
        return spell4Casts;
    }

    public void setSpell4Casts(int spell4Casts) {
        this.spell4Casts = spell4Casts;
    }

    public int getSummoner1Casts() {
        return summoner1Casts;
    }

    public void setSummoner1Casts(int summoner1Casts) {
        this.summoner1Casts = summoner1Casts;
    }

    public int getSummoner1Id() {
        return summoner1Id;
    }

    public void setSummoner1Id(int summoner1Id) {
        this.summoner1Id = summoner1Id;
    }

    public int getSummoner2Casts() {
        return summoner2Casts;
    }

    public void setSummoner2Casts(int summoner2Casts) {
        this.summoner2Casts = summoner2Casts;
    }

    public int getSummoner2Id() {
        return summoner2Id;
    }

    public void setSummoner2Id(int summoner2Id) {
        this.summoner2Id = summoner2Id;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(String summonerId) {
        this.summonerId = summonerId;
    }

    public int getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(int summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public boolean isTeamEarlySurrendered() {
        return teamEarlySurrendered;
    }

    public void setTeamEarlySurrendered(boolean teamEarlySurrendered) {
        this.teamEarlySurrendered = teamEarlySurrendered;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamPosition() {
        return teamPosition;
    }

    public void setTeamPosition(String teamPosition) {
        this.teamPosition = teamPosition;
    }

    public int getTimeCCingOthers() {
        return timeCCingOthers;
    }

    public void setTimeCCingOthers(int timeCCingOthers) {
        this.timeCCingOthers = timeCCingOthers;
    }

    public int getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(int timePlayed) {
        this.timePlayed = timePlayed;
    }

    public int getTotalDamageDealt() {
        return totalDamageDealt;
    }

    public void setTotalDamageDealt(int totalDamageDealt) {
        this.totalDamageDealt = totalDamageDealt;
    }

    public int getTotalDamageDealtToChampions() {
        return totalDamageDealtToChampions;
    }

    public void setTotalDamageDealtToChampions(int totalDamageDealtToChampions) {
        this.totalDamageDealtToChampions = totalDamageDealtToChampions;
    }

    public int getTotalDamageShieldedOnTeammates() {
        return totalDamageShieldedOnTeammates;
    }

    public void setTotalDamageShieldedOnTeammates(int totalDamageShieldedOnTeammates) {
        this.totalDamageShieldedOnTeammates = totalDamageShieldedOnTeammates;
    }

    public int getTotalDamageTaken() {
        return totalDamageTaken;
    }

    public void setTotalDamageTaken(int totalDamageTaken) {
        this.totalDamageTaken = totalDamageTaken;
    }

    public int getTotalHeal() {
        return totalHeal;
    }

    public void setTotalHeal(int totalHeal) {
        this.totalHeal = totalHeal;
    }

    public int getTotalHealsOnTeammates() {
        return totalHealsOnTeammates;
    }

    public void setTotalHealsOnTeammates(int totalHealsOnTeammates) {
        this.totalHealsOnTeammates = totalHealsOnTeammates;
    }

    public int getTotalMinionsKilled() {
        return totalMinionsKilled;
    }

    public void setTotalMinionsKilled(int totalMinionsKilled) {
        this.totalMinionsKilled = totalMinionsKilled;
    }

    public int getTotalTimeCCDealt() {
        return totalTimeCCDealt;
    }

    public void setTotalTimeCCDealt(int totalTimeCCDealt) {
        this.totalTimeCCDealt = totalTimeCCDealt;
    }

    public int getTotalTimeSpentDead() {
        return totalTimeSpentDead;
    }

    public void setTotalTimeSpentDead(int totalTimeSpentDead) {
        this.totalTimeSpentDead = totalTimeSpentDead;
    }

    public int getTotalUnitsHealed() {
        return totalUnitsHealed;
    }

    public void setTotalUnitsHealed(int totalUnitsHealed) {
        this.totalUnitsHealed = totalUnitsHealed;
    }

    public int getTripleKills() {
        return tripleKills;
    }

    public void setTripleKills(int tripleKills) {
        this.tripleKills = tripleKills;
    }

    public int getTrueDamageDealt() {
        return trueDamageDealt;
    }

    public void setTrueDamageDealt(int trueDamageDealt) {
        this.trueDamageDealt = trueDamageDealt;
    }

    public int getTrueDamageDealtToChampions() {
        return trueDamageDealtToChampions;
    }

    public void setTrueDamageDealtToChampions(int trueDamageDealtToChampions) {
        this.trueDamageDealtToChampions = trueDamageDealtToChampions;
    }

    public int getTrueDamageTaken() {
        return trueDamageTaken;
    }

    public void setTrueDamageTaken(int trueDamageTaken) {
        this.trueDamageTaken = trueDamageTaken;
    }

    public int getTurretKills() {
        return turretKills;
    }

    public void setTurretKills(int turretKills) {
        this.turretKills = turretKills;
    }

    public int getTurretTakedowns() {
        return turretTakedowns;
    }

    public void setTurretTakedowns(int turretTakedowns) {
        this.turretTakedowns = turretTakedowns;
    }

    public int getTurretsLost() {
        return turretsLost;
    }

    public void setTurretsLost(int turretsLost) {
        this.turretsLost = turretsLost;
    }

    public int getUnrealKills() {
        return unrealKills;
    }

    public void setUnrealKills(int unrealKills) {
        this.unrealKills = unrealKills;
    }

    public int getVisionScore() {
        return visionScore;
    }

    public void setVisionScore(int visionScore) {
        this.visionScore = visionScore;
    }

    public int getVisionWardsBoughtInGame() {
        return visionWardsBoughtInGame;
    }

    public void setVisionWardsBoughtInGame(int visionWardsBoughtInGame) {
        this.visionWardsBoughtInGame = visionWardsBoughtInGame;
    }

    public int getWardsKilled() {
        return wardsKilled;
    }

    public void setWardsKilled(int wardsKilled) {
        this.wardsKilled = wardsKilled;
    }

    public int getWardsPlaced() {
        return wardsPlaced;
    }

    public void setWardsPlaced(int wardsPlaced) {
        this.wardsPlaced = wardsPlaced;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public int[] getItemIds() {
        return new int[] {item0, item1, item2, item3, item4, item5, item6};
    }

    public int[] getSummonerSpellIds() {
        return new int[] {summoner1Id, summoner2Id};
    }

    public Spell[] getSpells() {
        return spells;
    }

    public void setSpells(Spell[] spells) {
        this.spells = spells;
    }

    public Champion getChampion() {
        return champion;
    }

    public void setChampion(Champion champion) {
        this.champion = champion;
    }

    public Rune getMainRune() {
        return mainRune;
    }

    public void setMainRune(Rune mainRune) {
        this.mainRune = mainRune;
    }

    public RuneGroup getSubRuneGroup() {
        return subRuneGroup;
    }

    public void setSubRuneGroup(RuneGroup subRuneGroup) {
        this.subRuneGroup = subRuneGroup;
    }

    public Participant toDomain() {
        Participant participant = new Participant();
        participant.setSummonerId(summonerId);
        participant.setSummonerName(summonerName);
        participant.setSummonerLevel(summonerLevel);
        participant.setPuuid(puuid);
        participant.setKills(kills);
        participant.setDeaths(deaths);
        participant.setAssists(assists);
        participant.setItem0Id(item0);
        participant.setItem1Id(item1);
        participant.setItem2Id(item2);
        participant.setItem3Id(item3);
        participant.setItem4Id(item4);
        participant.setItem5Id(item5);
        participant.setItem6Id(item6);
        participant.setGoldEarned(goldEarned);
        participant.setGoldSpent(goldSpent);
        participant.setSummoner1Id(summoner1Id);
        participant.setSummoner2Id(summoner2Id);
        participant.setSpell1Casts(spell1Casts);
        participant.setSpell2Casts(spell2Casts);
        participant.setSpell3Casts(spell3Casts);
        participant.setSpell4Casts(spell4Casts);
        participant.setSummoner1Casts(summoner1Casts);
        participant.setSummoner2Casts(summoner2Casts);
        participant.setChampionId(championId);
        participant.setChampLevel(champLevel);
        participant.setTeamId(teamId);
        participant.setLane(lane);
        participant.setRole(role);
        participant.setWin(win);

        PerkStyle[] styles = perks.getStyles();
        participant.setMainRuneGroupId(styles[0].getStyle());
        participant.setMainRuneIds(styles[0].getPerkIds());

        participant.setSubRuneGroupId(styles[1].getStyle());
        participant.setSubRuneIds(styles[1].getPerkIds());

        return participant;
    }
}
