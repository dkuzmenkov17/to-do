package com.github.dkuzmenkov17.todo.controller

import com.github.dkuzmenkov17.todo.dto.ErrorDto
import com.github.dkuzmenkov17.todo.exception.NotFoundException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class GlobalExceptionHandler {

    val logger: Logger = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    fun handleNotFoundException(ex: NotFoundException): ErrorDto {
        logger.error("Not found exception catch - ${ex.message}")
        return ErrorDto(ex.message)
    }
}