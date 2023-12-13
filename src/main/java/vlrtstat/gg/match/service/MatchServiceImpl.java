package vlrtstat.gg.match.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vlrtstat.gg.champion.domain.Champion;
import vlrtstat.gg.champion.repository.ChampionRepository;
import vlrtstat.gg.item.domain.Item;
import vlrtstat.gg.item.repository.ItemRepository;
import vlrtstat.gg.match.client.response.MatchResponse;
import vlrtstat.gg.match.client.response.ParticipantResponse;
import vlrtstat.gg.match.domain.RiotMatch;
import vlrtstat.gg.match.dto.MatchDto;
import vlrtstat.gg.match.dto.SimpleMatchDto;
import vlrtstat.gg.match.client.MatchClient;
import vlrtstat.gg.match.repository.MatchRepository;
import vlrtstat.gg.participant.domain.Participant;
import vlrtstat.gg.participant.repository.ParticipantRepository;
import vlrtstat.gg.rune.domain.Rune;
import vlrtstat.gg.rune.domain.RuneGroup;
import vlrtstat.gg.rune.repository.RuneRepository;
import vlrtstat.gg.spell.domain.Spell;
import vlrtstat.gg.spell.repository.SpellRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MatchServiceImpl implements MatchService {
    private MatchClient matchClient;
    private MatchRepository matchRepository;
    private ItemRepository itemRepository;
    private SpellRepository spellRepository;
    private ChampionRepository championRepository;
    private RuneRepository runeRepository;
    private ParticipantRepository participantRepository;

    public MatchServiceImpl(MatchClient matchClient, MatchRepository matchRepository, ItemRepository itemRepository, SpellRepository spellRepository, ChampionRepository championRepository, RuneRepository runeRepository, ParticipantRepository participantRepository) {
        this.matchClient = matchClient;
        this.matchRepository = matchRepository;
        this.itemRepository = itemRepository;
        this.spellRepository = spellRepository;
        this.championRepository = championRepository;
        this.runeRepository = runeRepository;
        this.participantRepository = participantRepository;
    }

    @Override
    public SimpleMatchDto[] searchSimpleMatchesByPuuid(String puuid, int page) {
        String[] MatchIds = matchClient.findIdsByPuuid(puuid, (page - 1) * 20);
        ArrayList<SimpleMatchDto> matches = new ArrayList<>();
        for (String matchId : MatchIds) {
            try {
                MatchResponse matchResponse = matchClient.findById(matchId);
                ParticipantResponse[] participantResponses = matchResponse.getInfo().getParticipants();
                for (ParticipantResponse participantResponse : participantResponses) {
                    int[] itemIds = participantResponse.getItemIds();
                    Item[] items = itemRepository.findByIds(itemIds);
                    participantResponse.setItems(items);

                    int[] spellIds = participantResponse.getSummonerSpellIds();
                    Spell[] spells = spellRepository.findByIds(spellIds);
                    participantResponse.setSpells(spells);

                    int championId = participantResponse.getChampionId();
                    Champion champion = championRepository.findById(championId);
                    participantResponse.setChampion(champion);

                    int mainRuneId = participantResponse.getPerks().getStyles()[0].getSelections()[0].getPerk();
                    Rune mainRune = runeRepository.findRuneByRuneId(mainRuneId);
                    if (mainRune == null) {
                        System.out.println("mainRune = " + mainRune);
                    }
                    participantResponse.setMainRune(mainRune);

                    int subRuneGroupId = participantResponse.getPerks().getStyles()[1].getStyle();
                    RuneGroup subRuneGroup = runeRepository.findRuneGroupByRuneId(subRuneGroupId);
                    participantResponse.setSubRuneGroup(subRuneGroup);
                }
                matches.add(matchClient.findById(matchId).toSimpleMatchDto());
            } catch (Exception e) {

            }
        }

        return matches.stream().toArray(match -> new SimpleMatchDto[match]);
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
    public MatchDto[] searchMatchesByPuuid(String puuid, int page) {
        int start = (page - 1) * 20;
        String[] matchIds = matchClient.findIdsByPuuid(puuid, start);
        ArrayList<RiotMatch> riotMatches = new ArrayList<>();
        for (String matchId : matchIds) {
            RiotMatch match = searchMatch(matchId);
            if (match != null) riotMatches.add(match);
        }
        return riotMatches.stream().map(riotMatch -> new MatchDto(riotMatch)).toArray(MatchDto[]::new);
    }
}
