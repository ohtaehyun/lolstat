package vlrtstat.gg.match.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import vlrtstat.gg.match.client.response.MatchResponse;
import vlrtstat.gg.match.client.response.ParticipantResponse;
import vlrtstat.gg.global.filter.QueueIdFilter;
import vlrtstat.gg.match.domain.RiotMatch;
import vlrtstat.gg.match.dto.MatchDto;
import vlrtstat.gg.match.client.MatchClient;
import vlrtstat.gg.match.repository.MatchRepository;
import vlrtstat.gg.participant.domain.Participant;
import vlrtstat.gg.participant.repository.ParticipantRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MatchServiceImpl implements MatchService {
    private final MatchClient matchClient;
    private final MatchRepository matchRepository;
    private final ParticipantRepository participantRepository;

    public MatchServiceImpl(MatchClient matchClient, MatchRepository matchRepository, ParticipantRepository participantRepository) {
        this.matchClient = matchClient;
        this.matchRepository = matchRepository;
        this.participantRepository = participantRepository;
    }

    @Override
    @Transactional
    public RiotMatch searchMatch(String matchId) {
        Optional<RiotMatch> match = matchRepository.findByMatchId(matchId);
        if (match.isEmpty()) {
            try {
                MatchResponse matchResponse = matchClient.findById(matchId);
                RiotMatch riotMatch = new RiotMatch(matchResponse);

                ParticipantResponse[] participantResponses = matchResponse.getInfo().getParticipants();
                List<Participant> participants = new ArrayList<>();
                for (ParticipantResponse pr : participantResponses) {
                    Participant participant = pr.toDomain();
                    participant.setMatch(riotMatch);
                    participants.add(participant);
                }

                riotMatch.setParticipants(participants);
                matchRepository.save(riotMatch);
                participantRepository.saveAll(participants);
                return riotMatch;
            } catch (Exception e) {
                System.out.println("e.getMessage() = " + e.getMessage());
                return null;
            }
        }
        return match.get();
    }

    @Override
    @Transactional
    public MatchDto[] searchMatchesByPuuid(String puuid, int page, int size) {
        return searchMatchedByPuuid(puuid, page, size, QueueIdFilter.ALL);
    }

    @Override
    public MatchDto[] searchMatchedByPuuid(String puuid, int page, int size, QueueIdFilter queueIdFilter) {
        int start = (page - 1) * 20;
        String[] matchIds;
        if (queueIdFilter.equals(QueueIdFilter.ALL)) {
           matchIds = matchClient.findIdsByPuuid(puuid, start, size);
        } else {
            matchIds = matchClient.findIdsByPuuid(puuid, start, size, queueIdFilter.getQueueId().getId());
        }
        ArrayList<RiotMatch> riotMatches = new ArrayList<>();
        for (String matchId : matchIds) {
            try {
                RiotMatch match = searchMatch(matchId);
                if (match != null) {
                    riotMatches.add(match);
                }
            } catch (Exception e) {
                System.out.println("e = " + e);
            }
        }
        return riotMatches.stream().map(MatchDto::new).toArray(MatchDto[]::new);
    }
}
