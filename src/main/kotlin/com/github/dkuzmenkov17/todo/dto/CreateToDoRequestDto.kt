package com.github.dkuzmenkov17.todo.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class CreateToDoRequestDto(@JsonProperty("title") val title : String)