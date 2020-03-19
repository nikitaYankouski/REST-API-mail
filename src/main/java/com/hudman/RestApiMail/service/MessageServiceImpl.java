package com.hudman.RestApiMail.service;

import com.hudman.RestApiMail.model.Message;
import com.hudman.RestApiMail.repository.IMessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageServiceImpl implements IMessageService {

    @Autowired
    private IMessagesRepository messagesRepository;

    @Override
    public Message createMessage(Message message) {
        return messagesRepository.save(message);
    }

    @Override
    public List<Message> getMessagesByEmail(String email) {
        return messagesRepository.findAllByEmail(email);
    }

    @Override
    public List<Message> getListByMagicNumber(int magic_number) {
        return messagesRepository.findAllByMagicNumber(magic_number);
    }

    @Override
    public void deleteListMessages(List<Message> messageList) {
        messageList.forEach(
                message -> deleteMessage(message)
        );
    }

    @Override
    public void deleteMessage(Message message) {
        messagesRepository.delete(message);
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
}
