package dev.jake.westward.controllers;

import dev.jake.westward.models.adventurer.Adventurer;
import dev.jake.westward.services.AdventurerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/adventurers")
public class AdventurerController {
    private final AdventurerService service;

    /**
     * Best practice is to inject dependencies in the constructor over the fields directly. This
     * makes dependencies explicit and ensures the object is always created with valid dependencies
     * and avoids having null values.
     * <p>
     *     Spring boot will automatically inject the service dependency when the controller is
     *     instantiated.
     * </p>
     *
     * <p>
     *     It also makes the class structure more obvious, clearly showing the dependencies. Also
     *     makes unit testing easier because we can manually pass a fake service/mock.
     * </p>
     */
    @Autowired
    public AdventurerController(AdventurerService service) {
        this.service = service;
    }

    @PostMapping
    public Adventurer createAdventurer(@RequestBody Adventurer adventurer) {

        try {
            return service.createAdventurer(adventurer.getAdventurerName(),
                    adventurer.getAdventurerClass());
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    @GetMapping
    public ResponseEntity<List<Adventurer>> getAllAdventurers() {
        List<Adventurer> adventurers = service.getAllAdventurers();
        return ResponseEntity.ok().body(adventurers);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllAdventurers() {
        service.deleteAllAdventurers();
        return ResponseEntity.ok("All adventurers have been purged.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdventurerById(@PathVariable Long id) {
        service.deleteAdventurerById(id);
        return ResponseEntity.ok("Adventurer with ID: " + id + " has been purged.");
    }


}