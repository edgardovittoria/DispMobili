package it.mobile.whistle.business.impl.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.mobile.whistle.domain.Whistle;

public interface WhistleRepository extends JpaRepository<Whistle, Long>{
	
    public final static String FIND_BY_TYPE_QUERY = "SELECT c "
			 + "FROM Call c  "
			 + "WHERE c.callsType IS NOT NULL";
	
	@Query(FIND_BY_TYPE_QUERY)
	public List<Whistle> findByTipologia_whistle();
	
	float x=0;
    float y=0;
    
    public final static String FIND_BY_LON_LAT_QUERY = "SELECT w "
    		+ "FROM Whistle w "
    		+ "WHERE w.longitude >= 14.094336 - 0.01 AND w.longitude <= 14.094336 + 0.01  AND w.latitude >= 41.762816 - 0.01 AND w.latitude <= 41.762816 + 0.01";
    @Query(FIND_BY_LON_LAT_QUERY)
    public List<Whistle> findBylonlat(/*@Param("x") float x, @Param("y") float y*/);

}




