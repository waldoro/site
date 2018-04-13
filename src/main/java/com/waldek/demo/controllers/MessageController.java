package com.waldek.demo.controllers;

import com.waldek.demo.dto.Message;
import com.waldek.demo.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.stream.Stream;

@RestController
public class MessageController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MessageRepository repository;

    public MessageController () {
        log.info("enter controller");
    }

    @RequestMapping(value = "/message/",method = RequestMethod.GET)
    public ResponseEntity<List<Message>> getAllMessages() {
        List<Message> allMessages = repository.findAll();
        return new ResponseEntity<List<Message>>(allMessages, HttpStatus.OK);
    }

    @PostMapping(value = "/message/")
    public ResponseEntity<?> createMessage(@RequestBody Message message) {
        saveMessage("Guest",message.getMessage());
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

    public void saveMessage(String author, String message) {
        repository.save(new Message(System.currentTimeMillis(), author, message));
    }

    private void test(List<Message> allMessages) {
        //Function<Message,Message> funkcja = mes -> mes.setAuthor("waldek");
        //allMessages.stream().for
        //List<String> strList= new ArrayList<>();
    }
}
