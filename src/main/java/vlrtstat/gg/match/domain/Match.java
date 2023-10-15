package vlrtstat.gg.match.domain;

import vlrtstat.gg.match.dto.SimpleMatchDto;

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

        return simpleMatchDto;
    }
}
