package it.mobile.whistle.domain;

/*import java.util.HashSet;
import java.util.Set;*/


import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "Chat")
public class Chat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CHAT", nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ID_USER", nullable = false)
	private Utente apertaDa;
	
	@ManyToOne
	@JoinColumn(name = "PARTECIPANTE", nullable = false)
	private Utente partecipante;
	
	//private Set<Messaggio> Messaggi = new HashSet<Messaggio>();
	
}