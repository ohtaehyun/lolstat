package vlrtstat.gg.match.service;

import org.springframework.stereotype.Service;
import vlrtstat.gg.item.domain.Item;
import vlrtstat.gg.item.repository.ItemRepository;
import vlrtstat.gg.match.domain.Match;
import vlrtstat.gg.match.domain.Participant;
import vlrtstat.gg.match.dto.SimpleMatchDto;
import vlrtstat.gg.match.repository.MatchRepository;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class MatchServiceImpl implements MatchService {
    private MatchRepository matchRepository;
    private ItemRepository itemRepository;

    public MatchServiceImpl(MatchRepository matchRepository, ItemRepository itemRepository) {
        this.matchRepository = matchRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public String[] getMatchHistories(String puuid) {
        return matchRepository.findIdsByPuuid(puuid);
    }

    @Override
    public SimpleMatchDto[] searchSimpleMatchesByPuuid(String puuid) {
        String[] MatchIds = matchRepository.findIdsByPuuid(puuid);
        ArrayList<SimpleMatchDto> matches = new ArrayList<>();
        for (String matchId : MatchIds) {
            Match match = matchRepository.findById(matchId);
            Participant[] participants = match.getInfo().getParticipants();
            for (Participant participant : participants) {
                int[] itemIds = participant.getItemIds();
                Item[] items = itemRepository.findByIds(itemIds);
                participant.setItems(items);
            }
            matches.add(matchRepository.findById(matchId).toSimpleMatchDto());
        }

        return matches.stream().toArray(match -> new SimpleMatchDto[match]);
    }

    @Override
    public Match[] searchMatchesByPuuid(String puuid) {
        String[] MatchIds = matchRepository.findIdsByPuuid(puuid);
        ArrayList<SimpleMatchDto> matches = new ArrayList<>();
        for (String matchId : MatchIds) {
            matches.add(matchRepository.findById(matchId).toSimpleMatchDto());
        }

        return matches.stream().toArray(match -> new Match[match]);
    }
}
