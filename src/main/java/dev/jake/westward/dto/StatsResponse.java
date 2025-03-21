package dev.jake.westward.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatsResponse {

    private int strength;

    private int dexterity;

    private int constitution;

    private int intelligence;

    private int wisdom;

    private int charisma;

    private int maxHealth;

    private int currentHealth;

    private int maxMana;

    private int currentMana;

    private int armor;
}
