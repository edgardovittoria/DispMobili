package it.mobile.whistle.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.mobile.whistle.domain.Messaggio;
import it.mobile.whistle.business.MessageService;

@RestController
@RequestMapping("/messages")
@CrossOrigin
public class MessageController {
    
    private static final String MESSAGES_CHANNEL = "/topic/messages";
    
    private MessageService messageService;
    
    private SimpMessagingTemplate messagingTemplate;
    
    @Autowired
    public MessageController(MessageService messageService, SimpMessagingTemplate messagingTemplate) {
        this.messageService = messageService;
        this.messagingTemplate = messagingTemplate;
    }
    
    @GetMapping
    public List<Messaggio> findAll() {
        return messageService.findAll();
    }
    
    @PostMapping
    public void save(@RequestBody Messaggio Messaggio) {
        messageService.save(Messaggio);
        messagingTemplate.convertAndSend(MESSAGES_CHANNEL, Messaggio);
    }

}