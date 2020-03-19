package com.hudman.RestApiMail.service;

import com.hudman.RestApiMail.model.Message;

import java.util.List;

public interface IMessageService {

    Message createMessage(Message message);

    Iterable<Message> getMessages();

    List<Message> getListByMagicNumber(int magic_number);
}
