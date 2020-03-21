package com.hudman.RestApiMail.entity;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;

@Table("messageMagicNumber")
public class MessageEntityMagicNumber {

    private static final long serialVersionUID = 1L;

    @PrimaryKey
    private MessageMagicNumberPrimaryKey messagePrimaryKey;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private String email;

    @Column
    private LocalDateTime localDateTimeCreateMessage;

    public MessageEntityMagicNumber() {}

    public MessageEntityMagicNumber(MessageMagicNumberPrimaryKey primaryKeyObj, LocalDateTime localDateTime,
                                    String title, String content, String email) {
        this.messagePrimaryKey = primaryKeyObj;
        this.localDateTimeCreateMessage = localDateTime;
        this.title = title;
        this.content = content;
        this.email = email;
    }

    public MessageMagicNumberPrimaryKey getMessagePrimaryKey() {
        return messagePrimaryKey;
    }

    public void setMessagePrimaryKey(MessageMagicNumberPrimaryKey messagePrimaryKey) {
        this.messagePrimaryKey = messagePrimaryKey;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
