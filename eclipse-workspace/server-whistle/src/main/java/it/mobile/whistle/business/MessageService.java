package it.mobile.whistle.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.mobile.whistle.domain.Messaggio;
import it.mobile.whistle.business.impl.repositories.MessageRepository;


@Service
public class MessageService {
    
    private MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
    
    public List<Messaggio> findAll() {
        return messageRepository.findAll();
    }
    
    public void save(Messaggio Messaggio) {
        messageRepository.save(Messaggio);
    }
    
}