package dev.jake.westward.controllers;

import dev.jake.westward.models.Adventurer;
import dev.jake.westward.services.AdventurerService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/adventurer")
public class AdventurerController {
    @Autowired private AdventurerService service;

    @PostMapping
    public Adventurer createAdventurer(@RequestBody Adventurer adventurer) {
        return service.createAdventurer(adventurer.getName(), adventurer.getAdventurerClass());
    }

    @GetMapping
    public List<Adventurer> getAllAdventurers() {
        return service.getAllAdventurers();
    }




}