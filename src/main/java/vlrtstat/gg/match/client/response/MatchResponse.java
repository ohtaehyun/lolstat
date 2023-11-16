package vlrtstat.gg.match.client.response;

import vlrtstat.gg.match.domain.Info;
import vlrtstat.gg.match.domain.Metadata;
import vlrtstat.gg.match.domain.Participant;
import vlrtstat.gg.match.dto.SimpleMatchDto;
import vlrtstat.gg.match.dto.SimpleParticipantDto;

import java.util.Arrays;

public class MatchResponse {
    Metadata metadata;
    Info info;

    public MatchResponse(Metadata metadata, Info info) {
        this.metadata = metadata;
        this.info = info;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public SimpleMatchDto toSimpleMatchDto() {
        SimpleMatchDto simpleMatchDto = new SimpleMatchDto();
        simpleMatchDto.setMatchId(metadata.getMatchId());
        simpleMatchDto.setGameMode(info.getGameMode());
        simpleMatchDto.setGameType(info.getGameType());
        simpleMatchDto.setQueueId(info.getQueueId());

        Participant[] participants = info.getParticipants();
        simpleMatchDto.setParticipants(
            Arrays.stream(participants)
                    .map(participant -> participant.toSimpleDto())
                    .toArray(participant -> new SimpleParticipantDto[participant])
        );

        return simpleMatchDto;
    }
}
