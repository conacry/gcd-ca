package com.conacry.application.model;

import lombok.Data;

@Data
public final class TaskStatusModel {

    private String identifier;
    private String status;
    private Integer n1;
    private Integer n2;
    private Integer result;
}
