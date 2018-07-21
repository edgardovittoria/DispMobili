package it.mobile.whistle.business.impl.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import it.mobile.whistle.domain.Messaggio;

public interface MessaggioRepository extends JpaRepository<Messaggio, Long>  {

	List<Messaggio> findMessagesByrelativoaId(Long idChat);

	
}