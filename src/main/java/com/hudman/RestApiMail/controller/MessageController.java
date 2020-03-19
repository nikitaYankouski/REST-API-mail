package com.hudman.RestApiMail.controller;

import com.hudman.RestApiMail.model.Message;
import com.hudman.RestApiMail.repository.IMessagesRepository;
import com.hudman.RestApiMail.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@RestController
public class MessageController {

    @Autowired()
    IMessageService messageService;

    @PostMapping("/api/message")
    public ResponseEntity<Message> createMessage(@RequestBody final Message message) {
        message.setId(UUID.randomUUID());
        Message messageBuf = messageService.createMessage(message);
        return new ResponseEntity<>(messageBuf, HttpStatus.OK);
    }

    @PostMapping("/api/send")
    public ResponseEntity<Message> sendMessage(@RequestParam int magic_number) {
        List<Message> messageList = messageService.getListByMagicNumber(magic_number);

    }
}
