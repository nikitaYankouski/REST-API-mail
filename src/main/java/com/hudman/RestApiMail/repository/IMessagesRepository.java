package com.hudman.RestApiMail.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface IMessagesRepository extends CassandraRepository<> {
}
