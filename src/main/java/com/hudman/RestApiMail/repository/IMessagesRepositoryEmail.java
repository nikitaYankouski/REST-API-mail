package com.hudman.RestApiMail.repository;

import com.hudman.RestApiMail.entity.MessageEntityEmail;
import com.hudman.RestApiMail.entity.MessageMagicNumberPrimaryKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMessagesRepositoryEmail extends CassandraRepository<MessageEntityEmail, MessageMagicNumberPrimaryKey> {

    List<MessageEntityEmail> findAllByMessageEmailPrimaryKey_Email(String email);

    MessageEntityEmail findByMessageEmailPrimaryKey_Email(String email);
}
