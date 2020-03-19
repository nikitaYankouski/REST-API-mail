package com.hudman.RestApiMail.service;

import com.hudman.RestApiMail.model.Message;

import java.util.List;

public interface IMessageService {

    Message createMessage(Message message);

    List<Message> getMessagesByEmail(String email);

    List<Message> getListByMagicNumber(int magicNumber);

    void deleteMessage(Message message);

    void deleteListMessages(List<Message> messageList);
}
