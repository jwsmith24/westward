package dev.jake.westward.dto.util;

import dev.jake.westward.dto.StatsRequest;
import dev.jake.westward.models.adventurer.AdventurerClass;
import dev.jake.westward.models.adventurer.Stats;
import org.springframework.stereotype.Component;

@Component
public class StatsBuilder {
    private final StatsMapper mapper;

    public StatsBuilder(StatsMapper mapper) {
        this.mapper = mapper;
    }

    public Stats buildWithBonuses(StatsRequest request, String adventurerClass) {

        Stats stats = mapper.toEntity(request);
        StatBonusStrategy strategy = StatBonusStrategyFactory.getStrategy(AdventurerClass.valueOf(adventurerClass));
        strategy.applyBonus(stats);
        stats.updateDerivedStats();
        return stats;
    }
}
