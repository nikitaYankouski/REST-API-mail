package com.hudman.RestApiMail.controller;

import com.hudman.RestApiMail.model.Message;
import com.hudman.RestApiMail.repository.IMessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class MessageController {

    @Autowired
    IMessagesRepository messagesRepository;

    @PostMapping("/api/message")
    public ResponseEntity<Message> createMessage(@Valid @RequestBody Message message) {
        Message messageBuf = messagesRepository.save(message);
        return new ResponseEntity<>(messageBuf, HttpStatus.OK);
    }
}
