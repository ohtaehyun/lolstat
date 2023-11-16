//package vlrtstat.gg.match.domain;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "Participant", indexes = {
//        @Index(name = "idx_participant_matchid", columnList = "matchId")
//}, uniqueConstraints = {
//        @UniqueConstraint(name = "uc_participant_puuid_matchid", columnNames = {"puuid", "matchId"})
//})
//public class Participant {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column
//    private Long id;
//
//    @Column
//    private String summonerId;
//
//    @Column
//    private String summonerName;
//
//    @Column
//    private int summonerLevel;
//
//    @Column
//    private String puuid;
//
//    @ManyToOne
//    @JoinColumn(name = "matchId")
//    private RiotMatch match;
//
//    @Column
//    private int kills;
//
//    @Column
//    private int deaths;
//
//    @Column
//    private int assists;
//
//    @Column
//    private int goldEarned;
//
//    @Column
//    private int goldSpent;
//
//    @Column
//    private int championId;
//
//    @Column
//    private int champLevel;
//
//    @Column
//    private int item0;
//
//    @Column
//    private int item1;
//
//    @Column
//    private int item2;
//
//    @Column
//    private int item3;
//
//    @Column
//    private int item4;
//
//    @Column
//    private int item5;
//
//    @Column
//    private int item6;
//
//    @Column
//    private int spell1Casts;
//
//    @Column
//    private int spell2Casts;
//
//    @Column
//    private int spell3Casts;
//
//    @Column
//    private int spell4Casts;
//
//    @Column
//    private int summoner1Casts;
//
//    @Column
//    private int summoner2Casts;
//
//    @Column
//    private int summoner1Id;
//
//    @Column
//    private int summoner2Id;
//
//    @Column
//    private boolean teamEarlySurrendered;
//
//    @Column
//    private int teamId;
//
//    @Column
//    private String teamPosition;
//
//    @Column
//    private boolean win;
//
//    @Column
//    private int visionScore;
//
//    @Column
//    private int visionWardsBoughtInGame;
//
//    @Column
//    private int wardsPlaced;
//
//    @Column
//    private int totalDamageDealt;
//
//    @Column
//    private int totalDamageDealtToChampions;
//
//    @Column
//    private int totalDamageTaken;
//
//    @Column
//    private int totalMinionsKilled;
//}
