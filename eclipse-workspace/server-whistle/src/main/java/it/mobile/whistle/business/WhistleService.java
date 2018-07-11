package it.mobile.whistle.business;

import java.util.List;


import it.mobile.whistle.domain.Whistle;
import it.mobile.whistle.domain.Utente;


public interface WhistleService {

	Utente findUtenteByUsername(String username) throws BusinessException;

	Utente updateProfilo(Utente utente) throws BusinessException;

	List<Whistle> findAllWhistle() throws BusinessException;

	Whistle findWhistleById(Long id) throws BusinessException;

	List<Whistle> findAllCall() throws BusinessException;
	
	void createWhistle(Whistle whistle) throws BusinessException;


	

	

	

}
