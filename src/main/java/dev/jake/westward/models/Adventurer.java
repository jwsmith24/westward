package dev.jake.westward.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Adventurer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String adventurerClass;
    private int level;

    public Adventurer() {

    }

    public Adventurer(String name, String adventurerClass) {
        this.name = name;
        this.adventurerClass = adventurerClass;
        this.level = 1;
    }


    public long getId() {return id;}
    public String getName() {return name;}
    public String getAdventurerClass() {return adventurerClass;}
    public int getLevel() {return level;}



}