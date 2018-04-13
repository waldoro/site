package com.waldek.demo.repository;

import com.waldek.demo.dto.Message;
import com.waldek.demo.dto.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<Todo,String> {
}
