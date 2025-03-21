package dev.jake.westward.dto.util;

import dev.jake.westward.dto.QuestRequest;
import dev.jake.westward.dto.QuestResponse;
import dev.jake.westward.models.quests.Quest;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestMapper {
    Quest toEntity(QuestRequest questRequest);
    QuestResponse toResponse(Quest quest);
    List<QuestResponse> toResponseList(List<Quest> quests);
}
