package com.waldek.demo.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;
import java.util.Date;

@Document(collection = "message")
public class Message {

    @Id
    private String id;

    private long creationTimestamp;

    private String message;

    @NotBlank
    @Size(max = 50)
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
