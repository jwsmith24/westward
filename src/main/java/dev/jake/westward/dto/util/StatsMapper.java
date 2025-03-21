package dev.jake.westward.dto.util;

import dev.jake.westward.dto.StatsRequest;
import dev.jake.westward.dto.StatsResponse;
import dev.jake.westward.models.adventurer.Stats;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface StatsMapper {

    Stats toEntity(StatsRequest stats);

    StatsResponse toResponse(Stats stats);


    @AfterMapping
    default void updateDerivedFields(@MappingTarget Stats stats) {
        stats.updateDerivedStats();
    }

}
