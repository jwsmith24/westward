package dev.jake.westward.services;

import dev.jake.westward.dto.QuestRequest;
import dev.jake.westward.dto.QuestResponse;
import dev.jake.westward.dto.util.QuestMapper;
import dev.jake.westward.models.quests.Quest;
import dev.jake.westward.repositories.QuestRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class QuestService {
    private final QuestRepository questRepository;
    private final QuestMapper mapper;

    @Autowired
    public QuestService(QuestRepository questRepository, QuestMapper mapper) {
        this.questRepository = questRepository;
        this.mapper = mapper;
    }


    public List<QuestResponse> getQuests() {
        return mapper.toResponseList(questRepository.findAll());
    }


    public QuestResponse addQuest(QuestRequest quest) {

        Quest newQuest = mapper.toEntity(quest);
        Quest savedQuest = questRepository.save(newQuest);

        return mapper.toResponse(savedQuest);
    }

    public void deleteAllQuests() {
        questRepository.deleteAll();
    }

    public void deleteQuestById(Long id) {
        if (!questRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Quest not found.");
        }

        questRepository.deleteById(id);
    }


}
