package dev.jake.westward.controllers;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/adventurer")
public class AdventurerController {

    @GetMapping
    public Map<String, Object> getAdventurer() {
        return Map.of(
                "name", "Frieren the Mage",
                "class", "Mage",
                "level", 1
        );
    }
}