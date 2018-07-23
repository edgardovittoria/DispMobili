package it.mobile.whistle.domain;

//import java.util.List;

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
	private Utente opener;
	
	@ManyToOne
	@JoinColumn(name = "PARTECIPANT", nullable = false)
	private Utente partecipant;
	
	//private List<Messaggio> messages;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Utente getOpener() {
		return opener;
	}

	public void setOpener(Utente opener) {
		this.opener = opener;
	}

	public Utente getPartecipant() {
		return partecipant;
	}

	public void setPartecipant(Utente partecipant) {
		this.partecipant = partecipant;
	}

	/*public List<Messaggio> getMessages() {
		return messages;
	}

	public void setMessages(List<Messaggio> messages) {
		this.messages = messages;
	}*/
	
}