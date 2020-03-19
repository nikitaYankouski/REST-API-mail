package com.hudman.RestApiMail.repository;

import com.hudman.RestApiMail.model.Message;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;


public interface IMessagesRepository extends CassandraRepository<Message, Integer> {

    List<Message> findAllByMagic_number(int magic_number);
}
