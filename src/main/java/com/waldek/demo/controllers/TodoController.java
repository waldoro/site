package com.waldek.demo.controllers;

import com.waldek.demo.dto.Todo;
import com.waldek.demo.repository.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TodoController {

   private final Logger logger = LoggerFactory.getLogger(this.getClass());

   @Autowired
   private TodoRepository todoRepository;

   @GetMapping(value = "/todo")
    public ResponseEntity<List<Todo>> getAllTodo(){
       return new ResponseEntity<List<Todo>>(todoRepository.findAll(), HttpStatus.OK);
   }

   @PostMapping(value = "/todo")
    public ResponseEntity<?> createTodo(@RequestBody @Valid Todo todo){
       logger.info("save todo to the database " + todo.getId() );
       todo.setCreated(System.currentTimeMillis());
       return new ResponseEntity<Todo>(todoRepository.save(todo), HttpStatus.OK);
   }

}
