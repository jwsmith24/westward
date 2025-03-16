package dev.jake.westward.dto.util;

import dev.jake.westward.dto.QuestDTO;
import dev.jake.westward.models.quests.Quest;
import dev.jake.westward.models.quests.Status;

public class QuestMapper {

    // DTO -> Entity
    public static Quest toEntity(QuestDTO dto) {
        Quest quest = new Quest();
        quest.setTitle(dto.getTitle());
        quest.setDescription(dto.getDescription());
        quest.setStatus(Status.fromString(dto.getStatus()));
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
        questDTO.setStatus(quest.getStatus().toString());
        questDTO.setObjectives(quest.getObjectives());
        questDTO.setExperience(quest.getExperience());

        return questDTO;
    }
}
