package com.waldek.demo.repository;

import com.waldek.demo.dto.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message,String> {

}
