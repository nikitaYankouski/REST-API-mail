package com.hudman.RestApiMail.entity;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;

@Table("messageEmail")
public class MessageEntityEmail {

    private static final long serialVersionUID = 1L;

    @PrimaryKey
    private MessageEmailPrimaryKey messageEmailPrimaryKey;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private int magicNumber;

    @Column
    private LocalDateTime localDateTimeCreateMessage;

    public MessageEntityEmail() {}

    public MessageEntityEmail(MessageEmailPrimaryKey messageEmailPrimaryKey, LocalDateTime localDateTime,
                              String title, String content, int magicNumber) {
        this.messageEmailPrimaryKey = messageEmailPrimaryKey;
        this.localDateTimeCreateMessage = localDateTime;
        this.title = title;
        this.content = content;
        this.magicNumber = magicNumber;
    }

    public MessageEmailPrimaryKey getMessageEmailPrimaryKey() {
        return messageEmailPrimaryKey;
    }

    public void setMessageEmailPrimaryKey(MessageEmailPrimaryKey messageEmailPrimaryKey) {
        this.messageEmailPrimaryKey = messageEmailPrimaryKey;
    }

    public int getMagicNumber() {
        return magicNumber;
    }

    public void setMagicNumber(int magicNumber) {
        this.magicNumber = magicNumber;
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

    public LocalDateTime getLocalDateTimeCreateMessage() {
        return localDateTimeCreateMessage;
    }

    public void setLocalDateTimeCreateMessage(LocalDateTime localDateTimeCreateMessage) {
        this.localDateTimeCreateMessage = localDateTimeCreateMessage;
    }

}
