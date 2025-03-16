package dev.jake.westward.dto.util;

import dev.jake.westward.dto.AdventurerDTO;
import dev.jake.westward.models.adventurer.Adventurer;
import dev.jake.westward.models.adventurer.AdventurerClass;

public class AdventurerMapper {
    private static final int BASE_EXPERIENCE = 0;
    private static final int BASE_LEVEL = 1;

    // Convert DTO to Entity
    public static Adventurer toEntity(AdventurerDTO dto) {
        Adventurer adventurer = new Adventurer();

        adventurer.setAdventurerName(dto.getAdventurerName());
        adventurer.setAdventurerClass(AdventurerClass.fromString(dto.getAdventurerClass()));

        if (dto.getLevel() != null && dto.getLevel() > 0) {
            adventurer.setLevel(dto.getLevel());
        } else {
            adventurer.setLevel(BASE_LEVEL);
        }

        if (dto.getExperience() != null && dto.getExperience() > 0) {
            adventurer.setExperience(dto.getExperience());
        } else {
            adventurer.setExperience(BASE_EXPERIENCE);
        }

        adventurer.setStats(StatsMapper.toEntity(dto.getStats()));

        return adventurer;
    }

    // Convert Entity to DTO
    public static AdventurerDTO toDto(Adventurer entity) {
        AdventurerDTO dto = new AdventurerDTO();
        dto.setId(entity.getId());
        dto.setAdventurerName(entity.getAdventurerName());
        dto.setAdventurerClass(entity.getAdventurerClass().toString());
        dto.setLevel(entity.getLevel());
        dto.setExperience(entity.getExperience());

        dto.setStats(StatsMapper.toDTO(entity.getStats()));

        return dto;
    }
}
