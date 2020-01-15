package com.github.dkuzmenkov17.todo.dao;

import com.github.dkuzmenkov17.todo.dao.jpa.ToDoJpaEntity;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends PagingAndSortingRepository<ToDoJpaEntity, Long>,
        QuerydslPredicateExecutor<ToDoJpaEntity> {
}
