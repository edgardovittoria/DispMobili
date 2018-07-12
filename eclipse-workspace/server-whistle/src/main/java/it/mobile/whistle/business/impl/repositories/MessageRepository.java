package it.mobile.whistle.business.impl.repositories;


import org.springframework.data.jpa.repository.JpaRepository;


import it.mobile.whistle.domain.Messaggio;

public interface MessageRepository extends JpaRepository<Messaggio, Long>  {

	
}