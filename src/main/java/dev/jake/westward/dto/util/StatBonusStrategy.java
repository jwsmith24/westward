package dev.jake.westward.dto.util;

import dev.jake.westward.models.adventurer.Stats;

public interface StatBonusStrategy {
    void applyBonus(Stats stats);
}