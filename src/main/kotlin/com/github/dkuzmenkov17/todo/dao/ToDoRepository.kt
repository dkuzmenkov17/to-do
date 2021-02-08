package com.github.dkuzmenkov17.todo.dao

import com.github.dkuzmenkov17.todo.dao.jpa.ToDoEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface ToDoRepository : JpaRepository<ToDoEntity, Long>