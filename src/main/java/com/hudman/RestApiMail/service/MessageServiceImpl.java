package com.hudman.RestApiMail.service;

import com.hudman.RestApiMail.model.Message;
import com.hudman.RestApiMail.repository.IMessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements IMessageService {

    @Autowired
    private IMessagesRepository messagesRepository;

    @Override
    public Message createMessage(Message message) {
        return messagesRepository.save(message);
    }

    @Override
    public Iterable<Message> getMessages() {
        return messagesRepository.findAll();
    }
}
