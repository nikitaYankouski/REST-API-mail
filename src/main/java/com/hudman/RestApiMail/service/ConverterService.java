package com.hudman.RestApiMail.service;

import com.hudman.RestApiMail.entity.MessageEmailPrimaryKey;
import com.hudman.RestApiMail.entity.MessageEntityEmail;
import com.hudman.RestApiMail.entity.MessageEntityMagicNumber;
import com.hudman.RestApiMail.entity.MessageMagicNumberPrimaryKey;
import com.hudman.RestApiMail.model.Message;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ConverterService {

    public MessageEntityEmail converterMessageEmail(Message message, UUID uuid) {
        MessageEmailPrimaryKey messageEmailPrimaryKey = new MessageEmailPrimaryKey();

        messageEmailPrimaryKey.setEmail(message.getEmail());
        messageEmailPrimaryKey.setUuid(UUID.randomUUID());

        MessageEntityEmail messageEntityEmail = new MessageEntityEmail(messageEmailPrimaryKey, LocalDateTime.now(),
                message.getTitle(), message.getContent(), message.getMagicNumber());

        return messageEntityEmail;
    }

    public MessageEntityMagicNumber converterMessageMagicNumber(Message message, UUID uuid) {
        MessageMagicNumberPrimaryKey messageMagicNumberPrimaryKey = new MessageMagicNumberPrimaryKey();

        messageMagicNumberPrimaryKey.setMagicNumber(message.getMagicNumber());
        messageMagicNumberPrimaryKey.setUuid(UUID.randomUUID());


        MessageEntityMagicNumber messageEntityMagicNumber = new MessageEntityMagicNumber(messageMagicNumberPrimaryKey, LocalDateTime.now(),
                message.getTitle(), message.getContent(), message.getEmail());

        return messageEntityMagicNumber;
    }
}
