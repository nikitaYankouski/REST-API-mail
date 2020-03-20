package com.hudman.RestApiMail.entity;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;

@Table("message")
public class MessageEntity {

    private static final long serialVersionUID = 1L;

    @PrimaryKey
    private MessagePrimaryKey messagePrimaryKey;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private LocalDateTime localDateTimeCreateMessage;

    public MessageEntity() {}

    public MessageEntity(MessagePrimaryKey primaryKeyObj, LocalDateTime localDateTime,
                         String title, String content) {
        this.messagePrimaryKey = primaryKeyObj;
        this.localDateTimeCreateMessage = localDateTime;
        this.title = title;
        this.content = content;
    }

    public MessagePrimaryKey getMessagePrimaryKey() {
        return messagePrimaryKey;
    }

    public void setMessagePrimaryKey(MessagePrimaryKey messagePrimaryKey) {
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


}
