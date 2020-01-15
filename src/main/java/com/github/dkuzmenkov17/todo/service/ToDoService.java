package com.github.dkuzmenkov17.todo.service;

import com.github.dkuzmenkov17.todo.dao.ToDoRepository;
import com.github.dkuzmenkov17.todo.dao.jpa.ToDoJpaEntity;
import com.github.dkuzmenkov17.todo.domain.Status;
import com.github.dkuzmenkov17.todo.domain.ToDoDto;
import com.querydsl.core.types.Predicate;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;
    private final Converter<ToDoJpaEntity, ToDoDto> toDoJpaToDtoConverter;

    public ToDoService(ToDoRepository toDoRepository,
                       Converter<ToDoJpaEntity, ToDoDto> toDoJpaToDtoConverter) {
        this.toDoRepository = toDoRepository;
        this.toDoJpaToDtoConverter = toDoJpaToDtoConverter;
    }


    public List<ToDoDto> getToDos(Predicate predicate, Pageable pageable) {
        Page<ToDoJpaEntity> page = predicate == null ? toDoRepository.findAll(pageable) :
                toDoRepository.findAll(predicate, pageable);
        return page.get().map(toDoJpaToDtoConverter::convert).collect(Collectors.toList());
    }

    @Transactional
    public void deleteToDo(Long id) {
        toDoRepository.deleteById(id);
    }

    @Transactional
    public ToDoDto createToDo(ToDoDto toDoDto) {
        ToDoJpaEntity toDoJpa = new ToDoJpaEntity();
        toDoJpa.setStatus(Status.CREATED);
        toDoJpa.setTitle(toDoDto.getTitle());
        toDoJpa.setDescription(toDoDto.getDescription());
        toDoJpa = toDoRepository.save(toDoJpa);
        return toDoJpaToDtoConverter.convert(toDoJpa);
    }

}
