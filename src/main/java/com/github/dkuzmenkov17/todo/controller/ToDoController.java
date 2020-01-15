package com.github.dkuzmenkov17.todo.controller;

import com.github.dkuzmenkov17.todo.dao.jpa.ToDoJpaEntity;
import com.github.dkuzmenkov17.todo.domain.ToDoDto;
import com.github.dkuzmenkov17.todo.service.ToDoService;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/to-dos")
public class ToDoController {

    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ToDoDto> getToDos(@QuerydslPredicate(root = ToDoJpaEntity.class) Predicate predicate, Pageable pageable) {
        return toDoService.getToDos(predicate, pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ToDoDto createToDo(@RequestBody ToDoDto todo) {
        return toDoService.createToDo(todo);
    }

    @DeleteMapping("/{toDoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteToDo(@PathVariable("toDoId") Long toDoId) {
        toDoService.deleteToDo(toDoId);
    }


}
