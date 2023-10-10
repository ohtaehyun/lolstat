package vlrtstat.gg.riotLeaderBoard.service;

import org.springframework.stereotype.Service;
import vlrtstat.gg.riotContent.domain.Act;
import vlrtstat.gg.riotContent.repository.RiotContentRepository;
import vlrtstat.gg.riotLeaderBoard.repository.RiotLeaderBoardRepository;

@Service
public class RiotLeaderBoardServiceImpl implements RiotLeaderBoardService {
    private RiotContentRepository riotContentRepository;
    private RiotLeaderBoardRepository riotLeaderBoardRepository;

    public RiotLeaderBoardServiceImpl(RiotLeaderBoardRepository riotLeaderBoardRepository) {
        this.riotLeaderBoardRepository = riotLeaderBoardRepository;
    }

    public String getLeaderBoard(int episode, int act) {
        Act[] acts = riotContentRepository.getContents().getActs();
        return "";
    }
}
