package com.github.dkuzmenkov17.todo.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Calendar

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ToDoDto(@JsonProperty("id") val id: Long,
                   @JsonProperty("title") val title: String = "Title $id",
                   @JsonProperty("is_done") val isDone: Boolean = false,
                   @JsonProperty("updated_at") val updatedAt: Calendar)