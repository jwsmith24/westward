package dev.jake.westward.services;

import dev.jake.westward.dto.QuestDTO;
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

    @Autowired
    public QuestService(QuestRepository questRepository) {
        this.questRepository = questRepository;
    }


    public List<QuestDTO> getQuests() {
        return questRepository.findAll()
                .stream()
                .map(QuestMapper::toDto)
                .collect(Collectors.toList());
    }


    public QuestDTO addQuest(QuestDTO quest) {

        Quest newQuest = QuestMapper.toEntity(quest);
        Quest savedQuest = questRepository.save(newQuest);

        return QuestMapper.toDto(savedQuest);
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
