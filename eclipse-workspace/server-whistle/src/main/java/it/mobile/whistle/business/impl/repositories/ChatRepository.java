package it.mobile.whistle.business.impl.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.mobile.whistle.domain.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long> {

	List<Chat> findChatsByopenerId(Long idUtente);

}
