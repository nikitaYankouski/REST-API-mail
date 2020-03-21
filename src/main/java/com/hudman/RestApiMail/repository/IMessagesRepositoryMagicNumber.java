package com.hudman.RestApiMail.repository;

import com.hudman.RestApiMail.entity.MessageEntityMagicNumber;
import com.hudman.RestApiMail.entity.MessageMagicNumberPrimaryKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMessagesRepositoryMagicNumber extends CassandraRepository<MessageEntityMagicNumber, MessageMagicNumberPrimaryKey> {

    List<MessageEntityMagicNumber> findAllByMessagePrimaryKey_MagicNumber(int magicNumber);
}
