package it.mobile.whistle.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.mobile.whistle.business.WhistleService;
import it.mobile.whistle.business.BusinessException;

import it.mobile.whistle.domain.Whistle;
import it.mobile.whistle.domain.Chat;
import it.mobile.whistle.domain.Commento;
import it.mobile.whistle.domain.Messaggio;
import it.mobile.whistle.domain.Reactions;
import it.mobile.whistle.domain.Utente;

import it.mobile.whistle.business.impl.repositories.WhistleRepository;
import it.mobile.whistle.business.impl.repositories.ChatRepository;
import it.mobile.whistle.business.impl.repositories.CommentoRepository;
import it.mobile.whistle.business.impl.repositories.MessaggioRepository;
import it.mobile.whistle.business.impl.repositories.ReactionsRepository;
import it.mobile.whistle.business.impl.repositories.UtenteRepository;

@Service
@Transactional
public class WhistleServiceImpl implements WhistleService {

	@Autowired
	private UtenteRepository utenteRepository;

	@Autowired
	private WhistleRepository whistleRepository;
	
	@Autowired
	private CommentoRepository commentoRepository;
	
	@Autowired
	private ReactionsRepository reactionsRepository;
	
	@Autowired
	private ChatRepository chatRepository;
	
	@Autowired
	private MessaggioRepository messaggioRepository;

    //Utente----------------------------------------------------------------------------------------------------------------
	@Override
	public Utente findUtenteByUsername(String username) throws BusinessException {
		return utenteRepository.findByUsername(username);
	}
	
	@Override
	public Utente updateProfilo(Utente profilo) throws BusinessException {
		Utente utente = utenteRepository.findByUsername(profilo.getUsername());
		utente.setEmail(profilo.getEmail());
		return utente;
	}

    
	
	//Whistle----------------------------------------------------------------------------------------------------------------
	@Override
	public Whistle findWhistleById(Long id) throws BusinessException {
		return whistleRepository.findById(id).get();
	}
	
	@Override
	public List<Whistle> findAllCall() throws BusinessException {
		return whistleRepository.findByTipologia_whistle();
	}
	
	@Override
	public List<Whistle> findWhistle(double latitude, double longitude) throws BusinessException {
		return whistleRepository.findBylonlat(latitude, longitude);
	}
	
	@Override
	public void createWhistle(Whistle whistle) throws BusinessException {
		whistleRepository.save(whistle);		
	}
	
	@Override
	public void deleteWhistle(long idWhistle) throws BusinessException {
		whistleRepository.deleteById(idWhistle);;		
	}
	
	
	
	
	//Commento----------------------------------------------------------------------------------------------------------------
	@Override
	public List<Commento> findAllCommenti(long idWhistle) throws BusinessException {
		return commentoRepository.findCommentiBywhistleId(idWhistle);
	}
	
	@Override
	public void createCommento(Commento commento) throws BusinessException {
		commentoRepository.save(commento);		
	}
	
	@Override
	public void deleteCommento(long idComment) throws BusinessException {
		commentoRepository.deleteById(idComment);;		
	}
	
	@Override
	public void updateCommento(Commento commento) throws BusinessException {
		commentoRepository.save(commento);		
	}
	
	
	
	
	
	//Reactions----------------------------------------------------------------------------------------------------------------
	@Override
	public List<Reactions> findAllReactions(long idWhistle) throws BusinessException {
		return reactionsRepository.findReactionsBywhistleId(idWhistle);
	}
	
	@Override
	public void createReaction(Reactions reactions) throws BusinessException {
		reactionsRepository.save(reactions);		
	}
	
	@Override
	public List<Reactions> findUtenteById(Long idUser) throws BusinessException {
		return reactionsRepository.findReactionsByreactionsOfId(idUser);
	}

	@Override
	public void deleteReaction(long reactionsId) throws BusinessException {
		reactionsRepository.deleteById(reactionsId);
	}
	
	@Override
	public Reactions getIdReaction(Long idUtente, Long idWhistle) {
		return reactionsRepository.findReactionsByreactionsOfIdAndWhistleId(idUtente, idWhistle);
	}
    
	
	
	
	
	//Chat----------------------------------------------------------------------------------------------------------------
	@Override
	public List<Chat> findChatByUser(Long idUtente) throws BusinessException {
		return chatRepository.findChatsByopenerId(idUtente);
	}
	
	@Override
	public void storeChat(Chat chat) throws BusinessException {
		chatRepository.save(chat);
	}
	
	@Override
	public void deleteChat(Long idChat) throws BusinessException {
		chatRepository.deleteById(idChat);
	}
    
	
	
	
	
	
	//Messaggio----------------------------------------------------------------------------------------------------------------
	@Override
	public List<Messaggio> findMessageByChat(Long idChat) throws BusinessException {
		return messaggioRepository.findMessagesByrelativoaId(idChat);
	}

	@Override
	public void storeMessage(Messaggio messaggio) throws BusinessException {
		messaggioRepository.save(messaggio);
		
	}

	@Override
	public void deleteMessage(Long idMessage) throws BusinessException {
		messaggioRepository.deleteById(idMessage);
	}

	

	
	


}
