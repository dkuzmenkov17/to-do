package com.github.dkuzmenkov17.todo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonIgnoreProperties
public class ToDoDto {
    private Long id;
    private String title;
    private String description;
    private Status status;
}
