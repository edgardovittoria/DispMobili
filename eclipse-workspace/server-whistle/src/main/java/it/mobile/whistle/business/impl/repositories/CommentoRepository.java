package it.mobile.whistle.business.impl.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.mobile.whistle.domain.Commento;






public interface CommentoRepository extends JpaRepository<Commento, Long> {
	
	
	 /*public final static String FIND_COMMENTS_QUERY = "SELECT c "
			 + "FROM Commento c  "
			 + "WHERE c.id_whistle = :id";
	
	@Query(FIND_COMMENTS_QUERY)*/
	List<Commento> findCommentiBywhistleId(long idWhistle);
}
