package com.github.dkuzmenkov17.todo.service

import com.github.dkuzmenkov17.todo.dto.CreateToDoRequestDto
import com.github.dkuzmenkov17.todo.dto.ToDoDto

interface ToDoService {

    fun getToDo(id: Long): ToDoDto

    fun getToDos(): List<ToDoDto>

    fun createToDo(toDo: CreateToDoRequestDto): Long

    fun deleteToDo(id: Long)
}