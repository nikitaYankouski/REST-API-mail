package com.hudman.RestApiMail.service;

import com.hudman.RestApiMail.model.Message;
import com.hudman.RestApiMail.repository.IMessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Iterable<Message> getMessages() {
        return messagesRepository.findAll();
    }

    @Override
    public List<Message> getListByMagicNumber(int magic_number) {
        List<Message> messageList = messagesRepository.findAllByMagic_number(magic_number);
        return messageList;
    }
}
