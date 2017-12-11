package com.waldek.demo.controllers;

import com.waldek.demo.dto.Message;
import com.waldek.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageRepository repository;

    @RequestMapping(value = "/message/",method = RequestMethod.GET)
    public ResponseEntity<List<Message>> getAllMessages() {
        List<Message> allMessages = repository.findAll();
        return new ResponseEntity<List<Message>>(allMessages, HttpStatus.OK);
    }

    @RequestMapping(value = "/message/", method = RequestMethod.POST)
    public ResponseEntity<?> createMessage(@RequestBody Message message) {
        saveMessage("Guest",message.getMessage());
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

    public void saveMessage(String author, String message) {
        repository.save(new Message(System.currentTimeMillis(), author, message));
    }

}
