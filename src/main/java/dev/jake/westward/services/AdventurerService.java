package dev.jake.westward.services;

import dev.jake.westward.dto.AdventurerDTO;
import dev.jake.westward.dto.util.AdventurerMapper;
import dev.jake.westward.models.adventurer.Adventurer;
import dev.jake.westward.repositories.AdventurerRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AdventurerService {
    private final AdventurerRepository adventurerRepository;


    @Autowired
    public AdventurerService(AdventurerRepository adventurerRepository) {
        this.adventurerRepository = adventurerRepository;
    }

    public AdventurerDTO createAdventurer(AdventurerDTO dto) {

        // map the data transfer object from the API request to an entity
        Adventurer adventurer = AdventurerMapper.toEntity(dto);
        Adventurer savedAdventurer = adventurerRepository.save(adventurer);

        return AdventurerMapper.toDto(savedAdventurer);
    }

    public List<AdventurerDTO> getAllAdventurers() {
        return adventurerRepository.findAll()
                .stream()
                .map(AdventurerMapper::toDto)
                .collect(Collectors.toList());
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