package com.waldek.demo.dto;

import org.springframework.data.annotation.Id;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {

    @Id
    private String id;

    private long creationTimestamp;

    private String message;

    private String author;

    public Message(long timestamp, String author, String message) {
        creationTimestamp = timestamp;
        this.author = author;
        this.message = message;
    }
    public Message() {}

    public long getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(long creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Message created on " + new Date(creationTimestamp) + ", by " + author + ", message: " + message;
    }
}
