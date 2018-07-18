package it.mobile.whistle.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.mobile.whistle.business.WhistleService;
import it.mobile.whistle.business.BusinessException;

import it.mobile.whistle.domain.Whistle;
import it.mobile.whistle.domain.Commento;
import it.mobile.whistle.domain.Reactions;
import it.mobile.whistle.domain.Utente;

import it.mobile.whistle.business.impl.repositories.WhistleRepository;
import it.mobile.whistle.business.impl.repositories.CommentoRepository;
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
	public List<Commento> findAllCommenti(long idWhistle) throws BusinessException {
		return commentoRepository.findCommentiBywhistleId(idWhistle);
	}
	
	@Override
	public void createCommento(Commento commento) throws BusinessException {
		commentoRepository.save(commento);		
	}
	
	@Override
	public void deleteCommento(Commento commento) throws BusinessException {
		commentoRepository.delete(commento);		
	}
	
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
	/*@Override
	public List<Reactions> countReactionsByIdWhistle(long idWhistle) {
		return reactionsRepository.findReactionsBywhistleId(idWhistle);
	}*/
	
	


}
