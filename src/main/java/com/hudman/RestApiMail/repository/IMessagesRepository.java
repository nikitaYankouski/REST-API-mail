package com.hudman.RestApiMail.repository;

import com.hudman.RestApiMail.model.Message;
import org.springframework.data.cassandra.repository.CassandraRepository;


public interface IMessagesRepository extends CassandraRepository<Message, Integer> {
}
