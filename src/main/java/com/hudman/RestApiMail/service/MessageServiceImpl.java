package com.hudman.RestApiMail.service;

import com.hudman.RestApiMail.entity.MessageEntity;
import com.hudman.RestApiMail.entity.MessagePrimaryKey;
import com.hudman.RestApiMail.model.Message;
import com.hudman.RestApiMail.repository.IMessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class MessageServiceImpl implements IMessageService {

    @Autowired
    private IMessagesRepository messagesRepository;

    @Override
    public MessageEntity createMessage(Message message) {
        return messagesRepository.save(requestObjectToEntity(message));
    }

    @Override
    public List<MessageEntity> getMessagesByEmail(String email) {
        return messagesRepository.findAllByMessagePrimaryKey_Email(email);
    }

    @Override
    public List<MessageEntity> getListByMagicNumber(int magic_number) {
        return messagesRepository.findAllByMessagePrimaryKey_MagicNumber(magic_number);
    }

    @Override
    public void deleteListMessages(List<MessageEntity> messageEntityList) {
        messageEntityList.forEach(
                message -> deleteMessage(message)
        );
    }

    @Override
    public void deleteMessage(MessageEntity messageEntity) {
        messagesRepository.delete(messageEntity);
    }

    @Override
    @Scheduled(fixedRate = 10000)
    public void deleteMessagesOlderFiveMin() {
        messagesRepository.findAll().forEach(
                message -> {
                    if (message.getLocalDateTimeCreateMessage().isBefore(LocalDateTime.now().minusMinutes(5)) ||
                    message.getLocalDateTimeCreateMessage().isEqual(LocalDateTime.now().minusMinutes(5)))
                        deleteMessage(message);
                }
        );
    }

    public MessageEntity requestObjectToEntity(Message message) {
        MessagePrimaryKey messagePrimaryKey = new MessagePrimaryKey();

        messagePrimaryKey.setMagicNumber(message.getMagicNumber());
        messagePrimaryKey.setEmail(message.getEmail());
        messagePrimaryKey.setUuid(UUID.randomUUID());

        MessageEntity messageEntity = new MessageEntity(messagePrimaryKey, LocalDateTime.now(),
                message.getTitle(), message.getContent());

        return messageEntity;
    }
}
