package com.hudman.RestApiMail.controller;

import com.hudman.RestApiMail.entity.MessageEntityEmail;
import com.hudman.RestApiMail.entity.MessageEntityMagicNumber;
import com.hudman.RestApiMail.model.Message;
import com.hudman.RestApiMail.repository.IMessagesRepositoryMagicNumber;
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
    public @ResponseBody ResponseEntity<List<MessageEntityEmail>> getMessage(@PathVariable final String emailValue) {
        List<MessageEntityEmail> getMessageEntityList = messageService.getMessagesByEmail(emailValue);
        return new ResponseEntity<List<MessageEntityEmail>>(getMessageEntityList, HttpStatus.OK);
    }

    @PostMapping(value = "/api/message")
    public @ResponseBody ResponseEntity<MessageEntityMagicNumber> createMessage(@RequestBody Message message) {
        MessageEntityMagicNumber messageEntityBuf = messageService.createMessage(message);
        return new ResponseEntity<>(messageEntityBuf, HttpStatus.OK);
    }

    @PostMapping(value = "/api/send")
    public String sendMessage(@RequestParam final int magicNumber) {
        List<MessageEntityMagicNumber> messageEntityList = messageService.getListByMagicNumber(magicNumber);
        emailService.sendListMail(messageEntityList);
        messageService.deleteListMessages(messageEntityList);
        return "sended and deleted";
    }
}
