package dev.jake.westward.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Adventurer DTO for outgoing responses.
 */
@Getter
@Setter
public class AdventurerResponse {

    private Long id;
    private String adventurerName;
    private String adventurerClass;
    private StatsResponse stats;
    private Integer level;
    private Integer experience;
}
