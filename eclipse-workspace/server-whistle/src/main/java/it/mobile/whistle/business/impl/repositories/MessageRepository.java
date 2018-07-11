package it.mobile.whistle.business.impl.repositories;

import java.util.List;

import it.mobile.whistle.domain.Messaggio;

public interface MessageRepository {

    List<Messaggio> findAll();
    void save(Messaggio message);
    
}