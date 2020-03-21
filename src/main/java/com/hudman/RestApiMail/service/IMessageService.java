package com.hudman.RestApiMail.service;

import com.hudman.RestApiMail.entity.MessageEntityEmail;
import com.hudman.RestApiMail.entity.MessageEntityMagicNumber;
import com.hudman.RestApiMail.model.Message;

import java.util.List;

public interface IMessageService {

    MessageEntityMagicNumber createMessage(Message message);

    List<MessageEntityEmail> getMessagesByEmail(String email);

    MessageEntityEmail getMessageByEmail(String email);

    List<MessageEntityMagicNumber> getListByMagicNumber(int magicNumber);

    void deleteMessage(MessageEntityMagicNumber messageEntity, MessageEntityEmail messageEntityEmail);

    void deleteListMessages(List<MessageEntityMagicNumber> messageEntityList);

    void deleteMessagesOlderFiveMin();
}
