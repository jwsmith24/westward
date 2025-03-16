package dev.jake.westward.dto.util;

import dev.jake.westward.dto.QuestDTO;
import dev.jake.westward.models.quests.Quest;

public class QuestMapper {

    // DTO -> Entity
    public static Quest toEntity(QuestDTO dto) {
        Quest quest = new Quest();
        quest.setTitle(dto.getTitle());
        quest.setDescription(dto.getDescription());
        quest.setStatus(dto.getStatus());
        quest.setObjectives(dto.getObjectives());
        quest.setExperience(dto.getExperience());

        return quest;
    }

    // Entity -> DTO
    public static QuestDTO toDto(Quest quest) {
        QuestDTO questDTO = new QuestDTO();
        questDTO.setId(quest.getId());
        questDTO.setTitle(quest.getTitle());
        questDTO.setDescription(quest.getDescription());
        questDTO.setStatus(quest.getStatus());
        questDTO.setObjectives(quest.getObjectives());
        questDTO.setExperience(quest.getExperience());

        return questDTO;
    }
}
