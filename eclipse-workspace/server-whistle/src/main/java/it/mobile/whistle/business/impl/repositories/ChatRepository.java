package it.mobile.whistle.business.impl.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.mobile.whistle.domain.Chat;
import it.mobile.whistle.domain.Messaggio;
import it.mobile.whistle.domain.Whistle;

public interface ChatRepository extends JpaRepository<Chat, Long> {

	List<Chat> findChatsByopenerIdOrPartecipantId(Long idUtente, Long idPartecipant);
	
	public final static String FIND_BY_OPENER_AND_PARTECIPANT_QUERY = "SELECT m"
			 + " FROM Messaggio m"
			 + " WHERE m.relativoa IN ("
			 + " SELECT c.id"
			 + " FROM Chat c"
			 + " WHERE c.opener = :opener OR c.opener = :partecipant AND c.partecipant IN ("
			 + " SELECT d.partecipant"
			 + " FROM Chat d"
			 + " WHERE d.partecipant = :partecipant OR d.partecipant = :opener))";
	
	@Query(FIND_BY_OPENER_AND_PARTECIPANT_QUERY)
	public List<Messaggio> findByOpener_Partecipant(@Param("opener") long idOpener, @Param("partecipant") long idPartecipant);

}
