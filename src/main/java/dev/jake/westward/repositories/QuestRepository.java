package dev.jake.westward.repositories;

import dev.jake.westward.models.quests.Quest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestRepository extends JpaRepository<Quest, Long> {
}
