package dev.jake.westward.dto.util;

import dev.jake.westward.dto.AdventurerRequest;
import dev.jake.westward.dto.AdventurerResponse;
import dev.jake.westward.models.adventurer.Adventurer;
import dev.jake.westward.models.adventurer.AdventurerClass;
import java.util.List;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {StatsMapper.class})
public interface AdventurerMapper {

    @Mapping(source = "adventurerClass", target = "adventurerClass", qualifiedByName = "stringToClass")
    Adventurer toEntity(AdventurerRequest request);

    @Mapping(source = "adventurerClass", target = "adventurerClass", qualifiedByName = "classToString")
    AdventurerResponse toResponse(Adventurer adventurer);

    List<AdventurerResponse> toResponseList(List<Adventurer> adventurers);

    @Named("classToString")
    static String mapClassToString(AdventurerClass ac) {
        System.out.print(ac);
        return ac != null ? ac.toString() : null;
    }

    @Named("stringToClass")
    static AdventurerClass toClassFromString(String ac) {
        return AdventurerClass.fromString(ac);
    }
}
