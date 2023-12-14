package vlrtstat.gg.summoner.service;

import org.springframework.stereotype.Service;
import vlrtstat.gg.league.repository.LeagueRepository;
import vlrtstat.gg.match.client.MatchClient;
import vlrtstat.gg.summoner.domain.Account;
import vlrtstat.gg.summoner.domain.Summoner;
import vlrtstat.gg.summoner.repository.AccountRepository;
import vlrtstat.gg.summoner.repository.SummonerRepository;

@Service
public class SummonerServiceImpl implements SummonerService {
    private SummonerRepository summonerRepository;
    private MatchClient matchClient;
    private LeagueRepository leagueRepository;
    private AccountRepository accountRepository;

    public SummonerServiceImpl(SummonerRepository summonerRepository, MatchClient matchClient, LeagueRepository leagueRepository, AccountRepository accountRepository) {
        this.summonerRepository = summonerRepository;
        this.matchClient = matchClient;
        this.leagueRepository = leagueRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public Summoner searchSummoner(String gameName, String tagLine) {
        Account account = accountRepository.findByNameAndTag(gameName, tagLine);
        Summoner summoner = summonerRepository.findByPuuid(account.getPuuid());
        return summoner;
    }

//    @Override
//    public SummonerProfileDto searchSummonerProfile(String summonerName) {
//        Summoner summoner = summonerRepository.findByName(summonerName);
//
//        LeagueEntry[] leagueEntry = leagueRepository.findBySummonerId(summoner.getId());
//
//        String[] MatchIds = matchRepository.findIdsByPuuid(summoner.getPuuid());
//        ArrayList<SimpleMatchDto> matches = new ArrayList<>();
//        for (String matchId : MatchIds) {
//            matches.add(matchRepository.findById(matchId).toSimpleMatchDto());
//        }
//
//        ProfileDto profileDto = new ProfileDto(summoner, leagueEntry[0]);
//        SummonerProfileDto summonerProfile = new SummonerProfileDto(profileDto, matches.stream().toArray(match -> new SimpleMatchDto[match]));
//
//        return summonerProfile;
//    }
}
