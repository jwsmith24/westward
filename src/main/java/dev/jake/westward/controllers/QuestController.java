package dev.jake.westward.controllers;

import dev.jake.westward.dto.QuestDTO;
import dev.jake.westward.services.QuestService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/quests")
public class QuestController {

    private final QuestService questService;

    public QuestController(QuestService questService) {
        this.questService = questService;
    }

    // Get all quests
    @GetMapping
    public ResponseEntity<List<QuestDTO>> getQuests() {
        List<QuestDTO> quests = questService.getQuests();
        return ResponseEntity.ok().body(quests);

    }

    // Create a new quest
    @PostMapping
    public ResponseEntity<QuestDTO> createQuest(@Valid @RequestBody QuestDTO questDTO) {
        try {
            QuestDTO dto = questService.addQuest(questDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(dto);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


}
