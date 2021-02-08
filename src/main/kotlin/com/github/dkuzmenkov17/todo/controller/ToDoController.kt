package com.github.dkuzmenkov17.todo.controller

import com.github.dkuzmenkov17.todo.dto.CreateToDoRequestDto
import com.github.dkuzmenkov17.todo.service.ToDoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/v1/todos")
class ToDoController(val toDoService: ToDoService) {

    @GetMapping
    fun getToDos() = ResponseEntity.ok(toDoService.getToDos())

    @GetMapping("{todoId}")
    fun getToDo(@PathVariable("todoId") id: Long) = ResponseEntity.ok(toDoService.getToDo(id))

    @PostMapping
    fun createToDo(@RequestBody createToDoDto: CreateToDoRequestDto,
                   uriComponentsBuilder: UriComponentsBuilder): ResponseEntity<Any> {
        val id = toDoService.createToDo(createToDoDto)

        val uriComponents = uriComponentsBuilder.path("/v1/todos/$id").build()
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @DeleteMapping("{todoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteToDo(@PathVariable("todoId") id: Long) = toDoService.deleteToDo(id)

}