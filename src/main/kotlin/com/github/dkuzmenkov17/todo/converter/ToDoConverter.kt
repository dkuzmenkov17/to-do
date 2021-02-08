package com.github.dkuzmenkov17.todo.converter

import com.github.dkuzmenkov17.todo.dao.jpa.ToDoEntity
import com.github.dkuzmenkov17.todo.dto.ToDoDto
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class ToDoConverter : Converter<ToDoEntity, ToDoDto> {

    override fun convert(entity: ToDoEntity) =
            ToDoDto(entity.id!!, entity.title, entity.isComplete, entity.updatedAt)

}