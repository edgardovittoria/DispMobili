package it.mobile.whistle.business.impl.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.mobile.whistle.domain.Whistle;

public interface WhistleRepository extends JpaRepository<Whistle, Long>{
	
    public final static String FIND_BY_TYPE_QUERY = "SELECT c "
			 + "FROM Call c  "
			 + "WHERE c.callsType IS NOT NULL";
	
	@Query(FIND_BY_TYPE_QUERY)
	public List<Whistle> findByTipologia_whistle();


}




