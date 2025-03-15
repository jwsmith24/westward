package dev.jake.westward.models.adventurer;

import dev.jake.westward.dto.AdventurerRequest;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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

    public Adventurer() {
    }

    public Adventurer(AdventurerRequest request) {
        this.adventurerName = request.getAdventurerName();
        this.adventurerClass = request.getAdventurerClass();
        this.stats = new Stats(request.getStats());
        this.level = BASE_LEVEL;
        this.experience = BASE_EXPERIENCE;
    }


}