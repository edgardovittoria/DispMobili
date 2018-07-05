package it.mobile.whistle.business.impl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.mobile.whistle.domain.Whistle;

public interface WhistleRepository extends JpaRepository<Whistle, Long>{
	

}
