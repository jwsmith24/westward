package dev.jake.westward.dto.util;

import dev.jake.westward.dto.StatsDTO;
import dev.jake.westward.models.adventurer.Stats;

public class StatsMapper {

    // DTO -> Entity
    public static Stats toEntity(StatsDTO statsDTO) {
        Stats stats = new Stats();

        stats.setStrength(statsDTO.getStrength());
        stats.setDexterity(statsDTO.getDexterity());
        stats.setConstitution(statsDTO.getConstitution());
        stats.setIntelligence(statsDTO.getIntelligence());
        stats.setWisdom(statsDTO.getWisdom());
        stats.setCharisma(statsDTO.getCharisma());

        stats.updateDerivedStats();

        return stats;
    }

    // Entity -> DTO

    public static StatsDTO toDTO(Stats stats) {
        StatsDTO statsDTO = new StatsDTO();

        statsDTO.setStrength(stats.getStrength());
        statsDTO.setDexterity(stats.getDexterity());
        statsDTO.setConstitution(stats.getConstitution());
        statsDTO.setIntelligence(stats.getIntelligence());
        statsDTO.setWisdom(stats.getWisdom());
        statsDTO.setCharisma(stats.getCharisma());

        statsDTO.setMaxHealth(stats.getMaxHealth());
        statsDTO.setMaxMana(stats.getMaxMana());
        statsDTO.setCurrentHealth(stats.getCurrentHealth());
        statsDTO.setCurrentMana(stats.getCurrentMana());
        statsDTO.setArmor(stats.getArmor());


        return statsDTO;
    }
}
