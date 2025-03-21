package dev.jake.westward.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Adventurer DTO for incoming requests.
 */
@Getter
@Setter
public class AdventurerRequest {


    @NotEmpty(message = "Adventurer name cannot be empty.")
    private String adventurerName;

    @NotNull(message = "Adventurer class is required.")
    private String adventurerClass;

    @NotNull(message = "Stats are required.")
    private StatsRequest stats;



}
