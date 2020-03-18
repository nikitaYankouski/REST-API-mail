package com.hudman.RestApiMail.repository;

import com.hudman.RestApiMail.model.Message;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface IMessagesRepository extends CassandraRepository<Message, UUID> {
}
