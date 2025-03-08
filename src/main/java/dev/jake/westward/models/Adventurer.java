package dev.jake.westward.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Adventurer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private AdventurerClass adventurerClass;
    private int level;

    public Adventurer() {

    }

    public Adventurer(String name, AdventurerClass adventurerClass) {
        this.name = name;
        this.adventurerClass = adventurerClass;
        this.level = 1;
    }


    public long getId() {return id;}
    public String getName() {return name;}
    public AdventurerClass getAdventurerClass() {return adventurerClass;}
    public int getLevel() {return level;}



}