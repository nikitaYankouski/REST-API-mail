package com.hudman.RestApiMail.controller;

import com.hudman.RestApiMail.model.Message;
import com.hudman.RestApiMail.repository.IMessagesRepository;
import com.hudman.RestApiMail.service.EmailService;
import com.hudman.RestApiMail.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@RestController
public class MessageController {

    @Autowired
    IMessageService messageService;

    @Autowired
    EmailService emailService;

    @GetMapping(value = "api/messages/{emailValue}")
    public @ResponseBody ResponseEntity<List<Message>> getMessage(@PathVariable final String emailValue) {
        List<Message> getMessageList = messageService.getMessagesByEmail(emailValue);
        return new ResponseEntity<List<Message>>(getMessageList, HttpStatus.OK);
    }

    @PostMapping(value = "/api/message")
    public @ResponseBody ResponseEntity<Message> createMessage(@RequestBody final Message message) {
        message.setId(UUID.randomUUID());
        Message messageBuf = messageService.createMessage(message);
        return new ResponseEntity<>(messageBuf, HttpStatus.OK);
    }

    @PostMapping(value = "/api/send")
    public String sendMessage(@RequestParam final int magicNumber) {
        List<Message> messageList = messageService.getListByMagicNumber(magicNumber);
        emailService.sendListMail(messageList);
        messageService.deleteListMessages(messageList);
        return "sended and deleted";
    }
}
