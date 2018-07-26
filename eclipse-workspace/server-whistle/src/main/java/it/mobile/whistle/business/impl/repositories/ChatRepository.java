package it.mobile.whistle.business.impl.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.mobile.whistle.domain.Chat;

import it.mobile.whistle.domain.Utente;


public interface ChatRepository extends JpaRepository<Chat, Long> {

	List<Chat> findChatsByopenerIdOrPartecipantId(Long idUtente, Long idPartecipant);
	
	public final static String FIND_CHAT = " SELECT c"
			 + " FROM Chat c"
			 + " WHERE c.opener = :opener OR c.opener = :partecipant";
	
	@Query(FIND_CHAT_PARTECIPANT)
	public Chat findChat(@Param("opener") Utente opener, @Param("partecipant") Utente Partecipant );
	
	public final static String FIND_CHAT_PARTECIPANT =  " SELECT c "
			 + " FROM Chat c, Chat d"
			 + " WHERE c.id IN ("
			 + "	SELECT o.id"
			 + "	FROM Chat o"
			 + "	WHERE o.opener = :opener OR o.partecipant = :opener) AND d.id IN ("
			 + "SELECT p.id "
			 + "FROM Chat p "
			 + "WHERE p.opener = :partecipant OR p.partecipant = :partecipant) AND c.id = d.id ";
	
	public Chat findChatsByPartecipantIdOrOpenerId(Long idOpener, Long idPartecipant);

}
