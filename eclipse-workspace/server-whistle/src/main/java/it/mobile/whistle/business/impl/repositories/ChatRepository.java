package it.mobile.whistle.business.impl.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.mobile.whistle.domain.Chat;
import it.mobile.whistle.domain.Messaggio;
import it.mobile.whistle.domain.Whistle;

public interface ChatRepository extends JpaRepository<Chat, Long> {

	List<Chat> findChatsByopenerIdOrPartecipantId(Long idUtente, Long idPartecipant);
	
	public final static String FIND_BY_OPENERE_AND_PARTECIPANT_QUERY = "SELECT c "
			 + "FROM Chat c  "
			 + "WHERE c.opener = :idOpener OR c.opener = :idPartecipant AND c.partecipant IN"
			 + " (SELECT c "
			 + " FROM Chat c "
			 + " WHERE c.partecipant = :idPartecipant OR c.partecipant = :idOpener)";
	
	@Query(FIND_BY_OPENERE_AND_PARTECIPANT_QUERY)
	public List<Messaggio> findByOpener_Partecipant(Long idOpener, Long idPartecipant);

}
