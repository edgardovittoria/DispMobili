package it.mobile.whistle.business.impl.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.mobile.whistle.domain.Reactions;

public interface ReactionsRepository extends JpaRepository<Reactions, Long> {

	List<Reactions> findReactionsBywhistleId(long idWhistle);
}
