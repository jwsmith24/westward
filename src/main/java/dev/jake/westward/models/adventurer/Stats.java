package dev.jake.westward.models.adventurer;

import dev.jake.westward.dto.StatsDTO;
import dev.jake.westward.models.adventurer.bonuses.StatBonusStrategy;
import dev.jake.westward.models.adventurer.bonuses.StatBonusStrategyFactory;
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

    private static final int BASE_HP = 10;
    private static final int BASE_MP = 5;
    private static final int BASE_ARMOR = 5;


    public Stats() {

    }

    public Stats(StatsDTO stats, AdventurerClass adventurerClass) {
        this.strength = stats.getStrength();
        this.dexterity = stats.getDexterity();
        this.constitution = stats.getConstitution();
        this.intelligence = stats.getIntelligence();
        this.wisdom = stats.getWisdom();
        this.charisma = stats.getCharisma();

        // use a strategy pattern to apply class bonuses
        StatBonusStrategy bonusStrategy = StatBonusStrategyFactory.getStrategy(adventurerClass);
        bonusStrategy.applyBonus(this);

        updateDerivedStats();
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