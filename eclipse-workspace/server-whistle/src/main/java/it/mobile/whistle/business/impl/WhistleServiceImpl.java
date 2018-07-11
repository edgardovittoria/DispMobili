package it.mobile.whistle.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.mobile.whistle.business.WhistleService;
import it.mobile.whistle.business.BusinessException;

import it.mobile.whistle.domain.Whistle;
import it.mobile.whistle.domain.Utente;

import it.mobile.whistle.business.impl.repositories.WhistleRepository;
import it.mobile.whistle.business.impl.repositories.UtenteRepository;

@Service
@Transactional
public class WhistleServiceImpl implements WhistleService {

	@Autowired
	private UtenteRepository utenteRepository;

	@Autowired
	private WhistleRepository whistleRepository;

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
	public List<Whistle> findAllWhistle() throws BusinessException {
		return whistleRepository.findAll(JpaSort.unsafe(Direction.DESC, "date"));
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
	public void createWhistle(Whistle whistle) throws BusinessException {
		whistleRepository.save(whistle);		
	}
	
	
	


}