package it.mobile.whistle.business.impl.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import it.mobile.whistle.domain.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Long> {

	Utente findByUsername(String username);
	
	Utente findUsersByemail(String email);
	
	Utente findUserById(Long id);

}
