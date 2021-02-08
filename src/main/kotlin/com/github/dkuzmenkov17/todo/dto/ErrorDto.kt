package com.github.dkuzmenkov17.todo.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ErrorDto(@JsonProperty("message") val message : String?)
