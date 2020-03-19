package com.hudman.RestApiMail.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Table
public class Message {

    @PrimaryKey
    private UUID id;

    private String email;
    private String title;
    private String content;
    private int magicNumber;

    private LocalDateTime localDateTimeCreateMessage;

    public Message() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getMagicNumber() {
        return magicNumber;
    }

    public void setMagicNumber(int magicNumber) {
        this.magicNumber = magicNumber;
    }

    public LocalDateTime getLocalDateTimeCreateMessage() {
        return localDateTimeCreateMessage;
    }

    public void setLocalDateTimeCreateMessage(LocalDateTime localDateTimeCreateMessage) {
        this.localDateTimeCreateMessage = localDateTimeCreateMessage;
    }
}
