package com.conacry.infrastructure.web.mapper;

import com.conacry.application.model.TaskData;
import com.conacry.application.model.TaskStatusModel;
import com.conacry.infrastructure.web.dto.TaskIdentifierDto;
import com.conacry.infrastructure.web.dto.TaskStatusDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface TaskDataMapper {

    @Mapping(target = "n1", source = "n1")
    @Mapping(target = "n2", source = "n2")
    TaskData fromParam(Integer n1, Integer n2);

    @Mapping(target = "identifier", expression = "java( identifier.toString() )")
    TaskIdentifierDto toIdentifierDto(UUID identifier);

    TaskStatusDto toStatusDto(TaskStatusModel status);
}
