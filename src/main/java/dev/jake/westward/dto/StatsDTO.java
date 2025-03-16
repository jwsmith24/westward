package dev.jake.westward.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object for Adventurer Stats.
 */
@Setter
@Getter
public class StatsDTO {

    @NotNull
    @Min(value = 0, message = "Strength must be at least 0")
    @Max(value = 17, message = "Strength cannot exceed 17")
    private int strength;

    @NotNull
    @Min(value = 0, message = "Dexterity must be at least 0")
    @Max(value = 17, message = "Dexterity cannot exceed 17")
    private int dexterity;

    @NotNull
    @Min(value = 0, message = "Constitution must be at least 0")
    @Max(value = 17, message = "Constitution cannot exceed 17")
    private int constitution;

    @NotNull
    @Min(value = 0, message = "Intelligence must be at least 0")
    @Max(value = 17, message = "Intelligence cannot exceed 17")
    private int intelligence;

    @NotNull
    @Min(value = 0, message = "Wisdom must be at least 0")
    @Max(value = 17, message = "Wisdom cannot exceed 17")
    private int wisdom;

    @NotNull
    @Min(value = 0, message = "Charisma must be at least 0")
    @Max(value = 17, message = "Charisma cannot exceed 17")
    private int charisma;

    // Derived stats -  don't really need them for incoming requests
    private int maxHealth;
    private int currentHealth;
    private int maxMana;
    private int currentMana;
    private int armor;

}

