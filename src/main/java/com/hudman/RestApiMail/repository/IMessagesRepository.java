package com.hudman.RestApiMail.repository;

import com.hudman.RestApiMail.model.Message;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;


public interface IMessagesRepository extends CassandraRepository<Message, Integer> {
    @AllowFiltering
    List<Message> findAllByMagicNumber(int magicNumber);

}
