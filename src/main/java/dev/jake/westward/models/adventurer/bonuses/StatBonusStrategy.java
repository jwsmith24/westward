package dev.jake.westward.models.adventurer.bonuses;

import dev.jake.westward.models.adventurer.Stats;

public interface StatBonusStrategy {
    void applyBonus(Stats stats);
}