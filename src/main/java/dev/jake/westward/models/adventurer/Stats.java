package dev.jake.westward.models.adventurer;


import static dev.jake.westward.dto.util.BaseValues.BASE_ARMOR;
import static dev.jake.westward.dto.util.BaseValues.BASE_HP;
import static dev.jake.westward.dto.util.BaseValues.BASE_MP;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Stats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Base stats
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    // Derived stats
    private int maxHealth;
    private int currentHealth;
    private int maxMana;
    private int currentMana;

    private int armor;




    public Stats() {

    }


    /**
     * Refresh derived stats after a change to base stats.
     */
    public void updateDerivedStats() {
        // set derived stats
        int maxHP = this.constitution + BASE_HP;
        this.maxHealth = maxHP;
        this.currentHealth = maxHP;

        int maxMana = this.intelligence + BASE_MP;
        this.maxMana = maxMana;
        this.currentMana = maxMana;

        this.armor = BASE_ARMOR;
    }

    }


