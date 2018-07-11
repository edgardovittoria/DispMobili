package it.mobile.whistle.business.impl.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import it.mobile.whistle.domain.Commento;






public interface CommentoRepository extends JpaRepository<Commento, Long> {

	List<Commento> findCommentiBywhistleId(long idWhistle);
}
