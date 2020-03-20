package com.hudman.RestApiMail.controller;

import com.hudman.RestApiMail.entity.MessageEntity;
import com.hudman.RestApiMail.model.Message;
import com.hudman.RestApiMail.service.EmailService;
import com.hudman.RestApiMail.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    IMessageService messageService;

    @Autowired
    EmailService emailService;

    @GetMapping(value = "api/messages/{emailValue}")
    public @ResponseBody ResponseEntity<List<MessageEntity>> getMessage(@PathVariable final String emailValue) {
        List<MessageEntity> getMessageEntityList = messageService.getMessagesByEmail(emailValue);
        return new ResponseEntity<List<MessageEntity>>(getMessageEntityList, HttpStatus.OK);
    }

    @PostMapping(value = "/api/message")
    public @ResponseBody ResponseEntity<MessageEntity> createMessage(@RequestBody Message message) {
        MessageEntity messageEntityBuf = messageService.createMessage(message);
        return new ResponseEntity<>(messageEntityBuf, HttpStatus.OK);
    }

    @PostMapping(value = "/api/send")
    public String sendMessage(@RequestParam final int magicNumber) {
        List<MessageEntity> messageEntityList = messageService.getListByMagicNumber(magicNumber);
        emailService.sendListMail(messageEntityList);
        messageService.deleteListMessages(messageEntityList);
        return "sended and deleted";
    }
}
