package dev.jake.westward.services;

import dev.jake.westward.models.adventurer.Adventurer;
import dev.jake.westward.models.adventurer.AdventurerClass;
import dev.jake.westward.models.adventurer.Stats;
import dev.jake.westward.repositories.AdventurerRepository;
import java.util.List;

import dev.jake.westward.repositories.StatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AdventurerService {
    private final AdventurerRepository adventurerRepository;

    @Autowired
    public AdventurerService (AdventurerRepository adventurerRepository) {
        this.adventurerRepository = adventurerRepository;
    }

    public Adventurer createAdventurer(String name, AdventurerClass adventurerClass) {

        if (name == null || name.trim().isBlank()) {
            throw new IllegalArgumentException("Adventurer name cannot be empty.");
        }

        Adventurer adventurer = new Adventurer(name.trim(), adventurerClass);
        Stats stats = new Stats();
        adventurer.setStats(stats);


        return adventurerRepository.save(adventurer);
    }

    public List<Adventurer> getAllAdventurers() {
        return adventurerRepository.findAll();
    }

    public void deleteAllAdventurers() {
        adventurerRepository.deleteAll();
    }

    public void deleteAdventurerById(Long id) {
        if (!adventurerRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Adventurer with ID:" + id +
                    "not found.");
        }
        adventurerRepository.deleteById(id);
    }
}