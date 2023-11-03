package vlrtstat.gg.match.service;

import org.springframework.stereotype.Service;
import vlrtstat.gg.champion.domain.Champion;
import vlrtstat.gg.champion.repository.ChampionRepository;
import vlrtstat.gg.item.domain.Item;
import vlrtstat.gg.item.repository.ItemRepository;
import vlrtstat.gg.match.domain.Match;
import vlrtstat.gg.match.domain.Participant;
import vlrtstat.gg.match.dto.SimpleMatchDto;
import vlrtstat.gg.match.repository.MatchRepository;
import vlrtstat.gg.rune.domain.Rune;
import vlrtstat.gg.rune.domain.RuneGroup;
import vlrtstat.gg.rune.repository.RuneRepository;
import vlrtstat.gg.spell.domain.Spell;
import vlrtstat.gg.spell.repository.SpellRepository;

import java.util.ArrayList;

@Service
public class MatchServiceImpl implements MatchService {
    private MatchRepository matchRepository;
    private ItemRepository itemRepository;
    private SpellRepository spellRepository;
    private ChampionRepository championRepository;
    private RuneRepository runeRepository;

    public MatchServiceImpl(MatchRepository matchRepository, ItemRepository itemRepository, SpellRepository spellRepository, ChampionRepository championRepository, RuneRepository runeRepository) {
        this.matchRepository = matchRepository;
        this.itemRepository = itemRepository;
        this.spellRepository = spellRepository;
        this.championRepository = championRepository;
        this.runeRepository = runeRepository;
    }

    @Override
    public SimpleMatchDto[] searchSimpleMatchesByPuuid(String puuid, int page) {
        String[] MatchIds = matchRepository.findIdsByPuuid(puuid, (page - 1) * 20);
        ArrayList<SimpleMatchDto> matches = new ArrayList<>();
        for (String matchId : MatchIds) {
            try {
                Match match = matchRepository.findById(matchId);
                Participant[] participants = match.getInfo().getParticipants();
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
                matches.add(matchRepository.findById(matchId).toSimpleMatchDto());
            } catch (Exception e) {

            }
        }

        return matches.stream().toArray(match -> new SimpleMatchDto[match]);
    }

//    @Override
//    public Match[] searchMatchesByPuuid(String puuid, int page) {
//        String[] MatchIds = matchRepository.findIdsByPuuid(puuid, (page - 1) * 20);
//        ArrayList<SimpleMatchDto> matches = new ArrayList<>();
//        for (String matchId : MatchIds) {
//            matches.add(matchRepository.findById(matchId).toSimpleMatchDto());
//        }
//
//        return matches.stream().toArray(match -> new Match[match]);
//    }
}
