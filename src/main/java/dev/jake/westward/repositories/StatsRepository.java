package dev.jake.westward.repositories;

import dev.jake.westward.models.adventurer.Stats;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StatsRepository extends JpaRepository<Stats, Long> {
}
