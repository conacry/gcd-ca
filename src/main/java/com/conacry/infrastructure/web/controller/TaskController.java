package com.conacry.infrastructure.web.controller;

import com.conacry.application.usecase.CreateTask;
import com.conacry.application.usecase.FetchTaskStatus;
import com.conacry.infrastructure.web.dto.TaskIdentifierDto;
import com.conacry.infrastructure.web.dto.TaskStatusDto;
import com.conacry.infrastructure.web.mapper.TaskDataMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Tag(name = "GCD",
        description = "API for work with task to calculate gcd")
@RestController
@RequestMapping("/api/v1")
public class TaskController {

    private final CreateTask createTask;
    private final FetchTaskStatus fetchTaskStatus;
    private final TaskDataMapper taskDataMapper;

    public TaskController(
            CreateTask createTask,
            FetchTaskStatus fetchTaskStatus,
            TaskDataMapper taskDataMapper
    ) {
        this.createTask = createTask;
        this.fetchTaskStatus = fetchTaskStatus;
        this.taskDataMapper = taskDataMapper;
    }

    @Operation(
            summary = "Create task to calculate GCD",
            description = "Create task to calculate GCD of two integers",
            method = "POST",
            parameters = {
                    @Parameter(
                            name = "n1",
                            description = "First integer param",
                            example = "100",
                            in = ParameterIn.QUERY,
                            required = true
                    ),
                    @Parameter(name = "n2",
                            description = "Second integer param",
                            example = "40",
                            in = ParameterIn.QUERY,
                            required = true
                    )
            }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Task to calculate GCD has created",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TaskIdentifierDto.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Error",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "User not authorized"
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Access forbidden"
            )
    })
    @PostMapping("/task")
    public TaskIdentifierDto createTask(
            @RequestParam("n1") @NotEmpty Integer n1,
            @RequestParam("n2") @NotEmpty Integer n2
    ) {
        var taskData = taskDataMapper.fromParam(n1, n2);
        var identifier = createTask.execute(taskData);

        return taskDataMapper.toIdentifierDto(identifier);
    }

    @Operation(
            summary = "Get status of task",
            description = "Get status of task",
            method = "GET",
            parameters = {
                    @Parameter(
                            name = "identifier",
                            description = "Task identifier",
                            example = "58eb1eca-3ae2-4f8e-8e41-957a1507c764",
                            in = ParameterIn.PATH,
                            required = true
                    )
            }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Task status",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TaskStatusDto.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Error",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "User not authorized"
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Access forbidden"
            )
    })
    @GetMapping("/task/{identifier}")
    public TaskStatusDto getTaskStatus(@PathVariable("identifier") String identifier) {
        var uuid = UUID.fromString(identifier);
        var status = fetchTaskStatus.execute(uuid);

        return taskDataMapper.toStatusDto(status);
    }
}
