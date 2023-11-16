package vlrtstat.gg.match.service;

import org.springframework.stereotype.Service;
import vlrtstat.gg.champion.domain.Champion;
import vlrtstat.gg.champion.repository.ChampionRepository;
import vlrtstat.gg.item.domain.Item;
import vlrtstat.gg.item.repository.ItemRepository;
import vlrtstat.gg.match.client.response.MatchResponse;
import vlrtstat.gg.match.domain.Participant;
import vlrtstat.gg.match.domain.RiotMatch;
import vlrtstat.gg.match.dto.SimpleMatchDto;
import vlrtstat.gg.match.client.MatchClient;
import vlrtstat.gg.match.repository.MatchRepository;
import vlrtstat.gg.rune.domain.Rune;
import vlrtstat.gg.rune.domain.RuneGroup;
import vlrtstat.gg.rune.repository.RuneRepository;
import vlrtstat.gg.spell.domain.Spell;
import vlrtstat.gg.spell.repository.SpellRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MatchServiceImpl implements MatchService {
    private MatchClient matchClient;
    private MatchRepository matchRepository;
    private ItemRepository itemRepository;
    private SpellRepository spellRepository;
    private ChampionRepository championRepository;
    private RuneRepository runeRepository;

    public MatchServiceImpl(MatchClient matchClient, MatchRepository matchRepository, ItemRepository itemRepository, SpellRepository spellRepository, ChampionRepository championRepository, RuneRepository runeRepository) {
        this.matchClient = matchClient;
        this.matchRepository = matchRepository;
        this.itemRepository = itemRepository;
        this.spellRepository = spellRepository;
        this.championRepository = championRepository;
        this.runeRepository = runeRepository;
    }

    @Override
    public SimpleMatchDto[] searchSimpleMatchesByPuuid(String puuid, int page) {
        String[] MatchIds = matchClient.findIdsByPuuid(puuid, (page - 1) * 20);
        ArrayList<SimpleMatchDto> matches = new ArrayList<>();
        for (String matchId : MatchIds) {
            try {
                MatchResponse matchResponse = matchClient.findById(matchId);
                Participant[] participants = matchResponse.getInfo().getParticipants();
                for (Participant participant : participants) {
                    int[] itemIds = participant.getItemIds();
                    Item[] items = itemRepository.findByIds(itemIds);
                    participant.setItems(items);

                    int[] spellIds = participant.getSummonerSpellIds();
                    Spell[] spells = spellRepository.findByIds(spellIds);
                    participant.setSpells(spells);

                    int championId = participant.getChampionId();
                    Champion champion = championRepository.findById(championId);
                    participant.setChampion(champion);

                    int mainRuneId = participant.getPerks().getStyles()[0].getSelections()[0].getPerk();
                    Rune mainRune = runeRepository.findRuneByRuneId(mainRuneId);
                    if (mainRune == null) {
                        System.out.println("mainRune = " + mainRune);
                    }
                    participant.setMainRune(mainRune);

                    int subRuneGroupId = participant.getPerks().getStyles()[1].getStyle();
                    RuneGroup subRuneGroup = runeRepository.findRuneGroupByRuneId(subRuneGroupId);
                    participant.setSubRuneGroup(subRuneGroup);
                }
                matches.add(matchClient.findById(matchId).toSimpleMatchDto());
            } catch (Exception e) {

            }
        }

        return matches.stream().toArray(match -> new SimpleMatchDto[match]);
    }

    @Override
    public RiotMatch searchMatch(String matchId) {
        Optional<RiotMatch> match = matchRepository.find(matchId);
        if (match.isEmpty()) {
            try {
                MatchResponse matchResponse = matchClient.findById(matchId);
                RiotMatch riotMatch = new RiotMatch(matchResponse);
                matchRepository.save(riotMatch);
                return riotMatch;
            } catch (Exception e) {
                return null;
            }
        }
        return match.get();
    }

    @Override
    public RiotMatch[] searchMatchesByPuuid(String puuid, int page) {
        int start = (page - 1) * 20;
        String[] matchIds = matchClient.findIdsByPuuid(puuid, start);
        ArrayList<RiotMatch> riotMatches = new ArrayList<>();
        for (String matchId : matchIds) {
            RiotMatch match = searchMatch(matchId);
            if (match != null) riotMatches.add(match);
        }
        return riotMatches.toArray(riotMatch -> new RiotMatch[riotMatch]);
    }
}
