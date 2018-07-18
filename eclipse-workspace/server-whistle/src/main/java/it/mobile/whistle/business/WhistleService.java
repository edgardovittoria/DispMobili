package it.mobile.whistle.business;

import java.util.List;

import it.mobile.whistle.domain.Whistle;

import it.mobile.whistle.domain.Commento;
import it.mobile.whistle.domain.Reactions;
import it.mobile.whistle.domain.Utente;


public interface WhistleService {

	Utente findUtenteByUsername(String username) throws BusinessException;
	
	//Optional<Utente> findUtenteById(Long id) throws BusinessException;

	Utente updateProfilo(Utente utente) throws BusinessException;
    
	List<Whistle> findWhistle(double latitude, double longitude) throws BusinessException;

	Whistle findWhistleById(Long id) throws BusinessException;

	List<Whistle> findAllCall() throws BusinessException;
	
	void createWhistle(Whistle whistle) throws BusinessException;
	
	List<Commento> findAllCommenti(long idWhistle) throws BusinessException;
	
	void createCommento(Commento commento) throws BusinessException;
	
	void deleteCommento(Commento commento) throws BusinessException;

    List<Reactions> findAllReactions(long idWhistle) throws BusinessException;
	
	void createReaction(Reactions reactions) throws BusinessException;

	List<Reactions> findUtenteById(Long idUser) throws BusinessException;
	
	

	
	
	//int countReactionsByIdWhistle(long idWhistle);

	

	

	

}
