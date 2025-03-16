package dev.jake.westward.models.adventurer.bonuses;

import dev.jake.westward.models.adventurer.AdventurerClass;
import dev.jake.westward.models.adventurer.Stats;

public class StatBonusStrategyFactory {
    private static final int CLASS_BONUS_MAJOR = 2;
    private static final int CLASS_BONUS_MINOR = 1;

    public static StatBonusStrategy getStrategy(AdventurerClass adventurerClass) {
        return switch (adventurerClass) {
            case MAGE -> new MageBonusStrategy();
            case ROGUE -> new RogueBonusStrategy();
            case WARRIOR -> new WarriorBonusStrategy();
            case PRIEST -> new PriestBonusStrategy();
        };
    }


    public static class MageBonusStrategy implements StatBonusStrategy {
        @Override
        public void applyBonus(Stats stats) {
            stats.setIntelligence(stats.getIntelligence() + CLASS_BONUS_MAJOR);
        }
    }

    public static class RogueBonusStrategy implements StatBonusStrategy {
        @Override
        public void applyBonus(Stats stats) {
            stats.setDexterity(stats.getDexterity() + CLASS_BONUS_MAJOR);
        }
    }

    public static class WarriorBonusStrategy implements StatBonusStrategy {
        @Override
        public void applyBonus(Stats stats) {
            stats.setStrength(stats.getStrength() + CLASS_BONUS_MINOR);
            stats.setConstitution(stats.getConstitution() + CLASS_BONUS_MINOR);
        }
    }

    public static class PriestBonusStrategy implements StatBonusStrategy {
        @Override
        public void applyBonus(Stats stats) {
            stats.setWisdom(stats.getWisdom() + CLASS_BONUS_MINOR);
            stats.setIntelligence(stats.getIntelligence() + CLASS_BONUS_MINOR);
        }
    }
}




