package it.mobile.whistle.business.impl.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import it.mobile.whistle.domain.Messaggio;

@Repository
public class MessageRepositoryImpl implements MessageRepository {

    private final List<Messaggio> messages = new ArrayList<>();
    
    @Override
    public List<Messaggio> findAll() {
        return messages;
    }

    @Override
    public void save(Messaggio Messaggio) {
        messages.add(Messaggio);
    }

}

    