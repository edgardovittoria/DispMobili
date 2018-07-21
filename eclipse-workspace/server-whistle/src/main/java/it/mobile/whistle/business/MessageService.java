package it.mobile.whistle.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.mobile.whistle.domain.Messaggio;
import it.mobile.whistle.business.impl.repositories.MessaggioRepository;


@Service
public class MessageService {
    
    private MessaggioRepository messageRepository;

    @Autowired
    public MessageService(MessaggioRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
    
    public List<Messaggio> findAll() {
        return messageRepository.findAll();
    }
    
    public void save(Messaggio Messaggio) {
        messageRepository.save(Messaggio);
    }
    
}