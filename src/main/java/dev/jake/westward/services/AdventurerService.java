package dev.jake.westward.services;

import dev.jake.westward.models.Adventurer;
import dev.jake.westward.models.AdventurerClass;
import dev.jake.westward.repositories.AdventurerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AdventurerService {
    private final AdventurerRepository repository;

    @Autowired
    public AdventurerService (AdventurerRepository repository) {
        this.repository = repository;
    }

    public Adventurer createAdventurer(String name, AdventurerClass adventurerClass) {

        if (name == null || name.trim().isBlank()) {
            throw new IllegalArgumentException("Adventurer name cannot be empty.");
        }

        Adventurer adventurer = new Adventurer(name.trim(), adventurerClass);
        return repository.save(adventurer);
    }

    public List<Adventurer> getAllAdventurers() {
        return repository.findAll();
    }

    public void deleteAllAdventurers() {
        repository.deleteAll();
    }

    public void deleteAdventurerById(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Adventurer with ID:" + id +
                    "not found.");
        }
        repository.deleteById(id);
    }
}