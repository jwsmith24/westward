package dev.jake.westward.services;

import dev.jake.westward.dto.AdventurerRequest;
import dev.jake.westward.dto.AdventurerResponse;
import dev.jake.westward.dto.util.AdventurerMapper;
import dev.jake.westward.dto.util.StatsBuilder;
import dev.jake.westward.models.adventurer.Adventurer;
import dev.jake.westward.repositories.AdventurerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AdventurerService {
    private final AdventurerRepository adventurerRepository;
    private final AdventurerMapper mapper;
    private final StatsBuilder statsBuilder;


    @Autowired
    public AdventurerService(AdventurerRepository adventurerRepository, AdventurerMapper mapper, StatsBuilder statsBuilder) {
        this.adventurerRepository = adventurerRepository;
        this.mapper = mapper;
        this.statsBuilder = statsBuilder;
    }

    public AdventurerResponse createAdventurer(AdventurerRequest request) {

        // map the data transfer object from the API request to an entity
        Adventurer adventurer = mapper.toEntity(request);
        adventurer.setStats(statsBuilder.buildWithBonuses(request.getStats(),
                request.getAdventurerClass()));
        Adventurer savedAdventurer = adventurerRepository.save(adventurer);

        return mapper.toResponse(savedAdventurer);
    }

    public List<AdventurerResponse> getAllAdventurers() {
        return mapper.toResponseList(adventurerRepository.findAll());
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