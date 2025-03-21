package dev.jake.westward.dto;

import dev.jake.westward.models.quests.Objective;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestResponse {
    private Long id;

    private String title;

    private String description;

    private String status;

    private List<Objective> objectives;

    private int experience;
}
