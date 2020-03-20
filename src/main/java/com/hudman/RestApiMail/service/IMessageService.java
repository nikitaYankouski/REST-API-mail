package com.hudman.RestApiMail.service;

import com.hudman.RestApiMail.entity.MessageEntity;
import com.hudman.RestApiMail.model.Message;

import java.util.List;

public interface IMessageService {

    MessageEntity createMessage(Message message);

    List<MessageEntity> getMessagesByEmail(String email);

    List<MessageEntity> getListByMagicNumber(int magicNumber);

    void deleteMessage(MessageEntity messageEntity);

    void deleteListMessages(List<MessageEntity> messageEntityList);

    void deleteMessagesOlderFiveMin();
}
