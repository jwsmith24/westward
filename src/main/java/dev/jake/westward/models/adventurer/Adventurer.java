package dev.jake.westward.models.adventurer;

import dev.jake.westward.dto.AdventurerRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Adventurer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String adventurerName;
    @Enumerated(EnumType.STRING)
    private AdventurerClass adventurerClass;
    private int level;
    private int experience;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "stats_id", referencedColumnName = "id", nullable = false)
    private Stats stats;

    private static final int BASE_EXPERIENCE = 0;
    private static final int BASE_LEVEL = 1;

    public Adventurer() {}

    public Adventurer(AdventurerRequest request) {
        this.adventurerName = request.getAdventurerName();
        this.adventurerClass = request.getAdventurerClass();
        this.stats = new Stats(request.getStats());
        this.level = BASE_LEVEL;
        this.experience = BASE_EXPERIENCE;
    }


}