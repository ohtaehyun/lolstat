package vlrtstat.gg.match.domain;

import vlrtstat.gg.match.dto.SimpleMatchDto;
import vlrtstat.gg.match.dto.SimpleParticipantDto;

import java.util.Arrays;

public class Match {
    Metadata metadata;
    Info info;

    public Match(Metadata metadata, Info info) {
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
