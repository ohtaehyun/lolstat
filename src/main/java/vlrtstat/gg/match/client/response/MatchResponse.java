package vlrtstat.gg.match.client.response;

import vlrtstat.gg.match.domain.Info;
import vlrtstat.gg.match.domain.Metadata;

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
}
