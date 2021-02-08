package com.github.dkuzmenkov17.todo.service

import com.github.dkuzmenkov17.todo.dao.ToDoRepository
import com.github.dkuzmenkov17.todo.dao.jpa.ToDoEntity
import com.github.dkuzmenkov17.todo.dto.CreateToDoRequestDto
import com.github.dkuzmenkov17.todo.dto.ToDoDto
import com.github.dkuzmenkov17.todo.exception.NotFoundException
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class ToDoServiceImpl(val toDoRepository: ToDoRepository,
                      val todoConverter: Converter<ToDoEntity, ToDoDto>) : ToDoService {

    override fun getToDo(id: Long): ToDoDto {
        val todoJpa = toDoRepository.findById(id).orElseThrow { NotFoundException("Could not find resource with id - $id") }
        return todoConverter.convert(todoJpa)!!
    }

    override fun getToDos() =
            toDoRepository.findAll().mapNotNull { todoConverter.convert(it) }


    @Transactional
    override fun createToDo(toDo: CreateToDoRequestDto): Long {
        var jpa = ToDoEntity(title = toDo.title)
        jpa = toDoRepository.save(jpa);
        return jpa.id!!
    }

    @Transactional
    override fun deleteToDo(id: Long) {
        toDoRepository.deleteById(id)
    }

}