package dev.jake.westward.services;

import dev.jake.westward.models.Adventurer;
import dev.jake.westward.repositories.AdventurerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdventurerService {
    @Autowired private AdventurerRepository repository;

    public Adventurer createAdventurer(String name, String adventurerClass) {
        Adventurer adventurer = new Adventurer(name, adventurerClass);
        return repository.save(adventurer);
    }

    public List<Adventurer> getAllAdventurers() {
        return repository.findAll();
    }
}