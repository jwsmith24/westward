package dev.jake.westward.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object for Adventurer Stats.
 */
@Setter
@Getter
public class StatsDTO {

    @Min(value = 0, message = "Strength must be at least 0")
    @Max(value = 17, message = "Strength cannot exceed 17")
    private int strength;

    @Min(value = 0, message = "Dexterity must be at least 0")
    @Max(value = 17, message = "Dexterity cannot exceed 17")
    private int dexterity;

    @Min(value = 0, message = "Constitution must be at least 0")
    @Max(value = 17, message = "Constitution cannot exceed 17")
    private int constitution;

    @Min(value = 0, message = "Intelligence must be at least 0")
    @Max(value = 17, message = "Intelligence cannot exceed 17")
    private int intelligence;

    @Min(value = 0, message = "Wisdom must be at least 0")
    @Max(value = 17, message = "Wisdom cannot exceed 17")
    private int wisdom;

    @Min(value = 0, message = "Charisma must be at least 0")
    @Max(value = 17, message = "Charisma cannot exceed 17")
    private int charisma;

}

