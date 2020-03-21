package com.hudman.RestApiMail.service;

import com.hudman.RestApiMail.entity.MessageEntityEmail;
import com.hudman.RestApiMail.entity.MessageEntityMagicNumber;
import com.hudman.RestApiMail.entity.MessageMagicNumberPrimaryKey;
import com.hudman.RestApiMail.model.Message;
import com.hudman.RestApiMail.repository.IMessagesRepositoryEmail;
import com.hudman.RestApiMail.repository.IMessagesRepositoryMagicNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class MessageServiceImpl implements IMessageService {

    @Autowired
    private IMessagesRepositoryMagicNumber messagesRepositoryMagicNumber;

    @Autowired
    private IMessagesRepositoryEmail messagesRepositoryEmail;

    @Autowired
    private ConverterService converterService;

    @Override
    public MessageEntityMagicNumber createMessage(Message message) {
        UUID uuid = UUID.randomUUID();
        messagesRepositoryEmail.save(converterService.converterMessageEmail(message, uuid));
        return messagesRepositoryMagicNumber.save(converterService.converterMessageMagicNumber(message, uuid));
    }

    @Override
    public List<MessageEntityEmail> getMessagesByEmail(String email) {
        return messagesRepositoryEmail.findAllByMessageEmailPrimaryKey_Email(email);
    }

    @Override
    public MessageEntityEmail getMessageByEmail(String email) {
        return messagesRepositoryEmail.findByMessageEmailPrimaryKey_Email(email);
    }

    @Override
    public List<MessageEntityMagicNumber> getListByMagicNumber(int magic_number) {
        return messagesRepositoryMagicNumber.findAllByMessagePrimaryKey_MagicNumber(magic_number);
    }

    @Override
    public void deleteListMessages(List<MessageEntityMagicNumber> messageEntityMagicNumberList) {
        messageEntityMagicNumberList.forEach(
                message -> deleteMessage(message, getMessageByEmail(message.getEmail()))
        );
    }

    @Override
    public void deleteMessage(MessageEntityMagicNumber messageEntityMagicNumber, MessageEntityEmail messageEntityEmail) {
        messagesRepositoryMagicNumber.delete(messageEntityMagicNumber);
        messagesRepositoryEmail.delete(messageEntityEmail);

    }

    @Override
    @Scheduled(fixedRate = 10000)
    public void deleteMessagesOlderFiveMin() {
        messagesRepositoryMagicNumber.findAll().forEach(
                message -> {
                    if (message.getLocalDateTimeCreateMessage().isBefore(LocalDateTime.now().minusMinutes(5)) ||
                    message.getLocalDateTimeCreateMessage().isEqual(LocalDateTime.now().minusMinutes(5)))
                        deleteMessage(message, getMessageByEmail(message.getEmail()));
                }
        );
    }
}
