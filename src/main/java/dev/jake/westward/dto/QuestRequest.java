package dev.jake.westward.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestRequest {

    @NotBlank(message = "Quest must have a title.")
    private String title;

    @NotBlank(message = "Quest must have a description.")
    private String description;

    @NotNull(message = "Quest must have a status.")
    private String status;
}
