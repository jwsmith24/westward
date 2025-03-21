package dev.jake.westward.controllers;

import dev.jake.westward.dto.QuestRequest;
import dev.jake.westward.dto.QuestResponse;
import dev.jake.westward.services.QuestService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public ResponseEntity<List<QuestResponse>> getQuests() {
        List<QuestResponse> quests = questService.getQuests();
        return ResponseEntity.ok().body(quests);

    }

    // Create a new quest
    @PostMapping
    public ResponseEntity<QuestResponse> createQuest(@Valid @RequestBody QuestRequest questDTO) {
        try {
            QuestResponse dto = questService.addQuest(questDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(dto);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    // Delete all quests
    @DeleteMapping
    public ResponseEntity<String> deleteAllQuests() {
        questService.deleteAllQuests();
        return ResponseEntity.ok().body("All quests have been deleted");
    }


}
