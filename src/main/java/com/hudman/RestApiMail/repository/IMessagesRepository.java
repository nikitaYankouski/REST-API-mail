package com.hudman.RestApiMail.repository;

import com.hudman.RestApiMail.entity.MessageEntity;
import com.hudman.RestApiMail.entity.MessagePrimaryKey;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;
import java.util.UUID;


public interface IMessagesRepository extends CassandraRepository<MessageEntity, MessagePrimaryKey> {

    List<MessageEntity> findAllByMessagePrimaryKey_MagicNumber(int magicNumber);

    List<MessageEntity> findAllByMessagePrimaryKey_Email(String email);

}
