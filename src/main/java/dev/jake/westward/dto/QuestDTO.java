package dev.jake.westward.dto;

import dev.jake.westward.models.quests.Objective;
import dev.jake.westward.models.quests.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestDTO {

    private Long id;

    @NotBlank(message = "Quest must have a title.")
    private String title;

    @NotBlank(message = "Quest must have a description.")
    private String description;

    @NotNull(message = "Quest must have a status.")
    private Status status;


    private List<Objective> objectives;
    private int experience;
}
