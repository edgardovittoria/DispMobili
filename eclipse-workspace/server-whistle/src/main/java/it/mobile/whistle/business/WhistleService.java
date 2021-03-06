package it.mobile.whistle.business;

import java.util.List;

import it.mobile.whistle.domain.Whistle;
import it.mobile.whistle.domain.Chat;
import it.mobile.whistle.domain.Commento;
import it.mobile.whistle.domain.Messaggio;
import it.mobile.whistle.domain.Reactions;
import it.mobile.whistle.domain.Utente;


public interface WhistleService {

	Utente findUtenteByUsername(String username) throws BusinessException;
	
	Utente findUtenteById(Long id) throws BusinessException;

	Utente updateProfilo(Utente utente) throws BusinessException;
	
	void storeUtente(Utente utente) throws BusinessException;
	
	Utente findUtenteByEmail(Utente utente) throws BusinessException;
    
	List<Whistle> findWhistle(double latitude, double longitude) throws BusinessException;

	Whistle findWhistleById(Long id) throws BusinessException;

	List<Whistle> findAllCall() throws BusinessException;
	
	void createWhistle(Whistle whistle) throws BusinessException;
	
	void deleteWhistle(long idWhistle) throws BusinessException;
	
	List<Commento> findAllCommenti(long idWhistle) throws BusinessException;
	
	void createCommento(Commento commento) throws BusinessException;
	
	void deleteCommento(long idComment) throws BusinessException;
	
	void updateCommento(Commento commento) throws BusinessException;

    List<Reactions> findAllReactions(long idWhistle) throws BusinessException;
	
	void createReaction(Reactions reactions) throws BusinessException;

	//List<Reactions> findUtenteById(Long idUser) throws BusinessException;

	void deleteReaction(Long reactionsId) throws BusinessException;
	
	Reactions getReactionById(Long idReaction) throws BusinessException;
	
	Reactions getIdReaction(Long idUtente, Long idWhistle) throws BusinessException;
	
	List<Chat> findChatByUserOrPartecipant(Long idUtente, Long idPartecipant) throws BusinessException;
	
	void storeChat(Chat chat) throws BusinessException;
	
	void deleteChat(Long idChat) throws BusinessException;

    List<Messaggio> findMessageByChat(Long idChat) throws BusinessException;
    
    //List<Messaggio> findMessageByOpener_Partecipant(Long idChat) throws BusinessException;
    
    Chat findChat(Utente opener, Utente partecipant) throws BusinessException;
    
    /*List<Chat> findPartecipant(Utente Partecipant) throws BusinessException;
    
    List<Chat> findOpener(Utente Opener) throws BusinessException;*/
    
    void storeMessage(Messaggio messaggio) throws BusinessException;
    
    void deleteMessage(Long idMessage) throws BusinessException;
    
	

	
	
	

	

	

	

}
