package com.github.dkuzmenkov17.todo.converter;

import com.github.dkuzmenkov17.todo.dao.jpa.ToDoJpaEntity;
import com.github.dkuzmenkov17.todo.domain.ToDoDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ToDoJpaToDtoConverter implements Converter<ToDoJpaEntity, ToDoDto> {

    @Override
    public ToDoDto convert(ToDoJpaEntity toDoJpaEntity) {
        return ToDoDto.builder()
                .id(toDoJpaEntity.getId())
                .status(toDoJpaEntity.getStatus())
                .description(toDoJpaEntity.getDescription())
                .title(toDoJpaEntity.getTitle())
                .build();

    }
}
