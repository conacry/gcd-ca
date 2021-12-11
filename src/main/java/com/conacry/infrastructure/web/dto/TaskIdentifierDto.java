package com.conacry.infrastructure.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Schema(name = "Task identifier", description = "DTO of task creation")
public class TaskIdentifierDto {

    @Schema(description = "Created task identifier", example = "58eb1eca-3ae2-4f8e-8e41-957a1507c764")
    @NotBlank
    private String identifier;
}
