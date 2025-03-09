package dev.jake.westward.models.adventurer;

import jakarta.persistence.*;

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

        this.strength = 0;
        this.dexterity = 0;
        this.constitution = 0;
        this.intelligence = 0;
        this.wisdom = 0;
        this.charisma = 0;


        this.maxHealth = 0;
        this.currentHealth = 0;
        this.maxMana = 0;
        this.currentMana = 0;
        this.armor = 0;

    }


    public Long getId() {
        return id;
    }


    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public int getArmor() {
        return armor;
    }
}