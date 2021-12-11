package com.conacry.infrastructure.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Schema(name = "Task status", description = "DTO of task")
public class TaskStatusDto {

    @Schema(description = "Task identifier", example = "58eb1eca-3ae2-4f8e-8e41-957a1507c764")
    @NotBlank
    private String identifier;

    @Schema(description = "Task status", example = "DONE")
    @NotBlank
    private String status;

    @Schema(description = "The first param")
    @NotBlank
    private Integer n1;

    @Schema(description = "The second param")
    @NotBlank
    private Integer n2;

    @Schema(description = "Result of calculation", nullable = true)
    private Integer result;
}
