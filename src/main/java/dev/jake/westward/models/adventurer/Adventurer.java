package dev.jake.westward.models.adventurer;

import jakarta.persistence.*;

@Entity
public class Adventurer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private AdventurerClass adventurerClass;
    private int level;
    private int experience;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "stats_id", referencedColumnName = "id", nullable = false)
    private Stats stats;
    public Adventurer() {

    }

    public Adventurer(String name, AdventurerClass adventurerClass) {
        this.name = name;
        this.adventurerClass = adventurerClass;
        this.level = 1;
        this.experience = 0;
        this.stats = new Stats();
    }


    public long getId() {return id;}
    public String getName() {return name;}
    public AdventurerClass getAdventurerClass() {return adventurerClass;}
    public int getLevel() {return level;}
    public int getExperience() {return experience;}
    public Stats getStats() {return stats;}

    public void setStats(Stats stats) {this.stats = stats;}



}