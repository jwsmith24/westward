package dev.jake.westward.dto;

import dev.jake.westward.models.adventurer.AdventurerClass;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for request validation.
 */
@NoArgsConstructor
@Getter
public class AdventurerRequest {

    @NotEmpty(message = "Adventurer name cannot be empty.")
    private String adventurerName;

    @NotNull(message = "Adventurer class is required.")
    private AdventurerClass adventurerClass;

    @NotNull(message = "Stats are required.")
    private StatsDTO stats;


}
