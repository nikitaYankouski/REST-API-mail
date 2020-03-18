package com.hudman.RestApiMail.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
public class Message {

    @PrimaryKey
    private int magic_number;

    private String email;
    private String title;
    private String content;


    public Message() {}

    public Message(String email, String title, String content, int magic_number) {
        this.email = email;
        this.title = title;
        this.content = content;
        this.magic_number = magic_number;
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

    public int getMagic_number() {
        return magic_number;
    }

    public void setMagic_number(int magic_number) {
        this.magic_number = magic_number;
    }

    @Override // !!
    public String toString() {
        return "Message{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
