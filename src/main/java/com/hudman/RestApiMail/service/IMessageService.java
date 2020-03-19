package com.hudman.RestApiMail.service;

import com.hudman.RestApiMail.model.Message;

public interface IMessageService {

    Message createMessage(Message message);

    Iterable<Message> getMessages();
}
