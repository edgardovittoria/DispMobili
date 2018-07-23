package it.mobile.whistle.presentation;

import it.mobile.whistle.domain.Utente;

public class ChatResponse {

	private Long id;
	private Utente partecipant;
	public Long getId() {
		return id;
	}
	public Utente getPartecipant() {
		return partecipant;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setPartecipant(Utente partecipant) {
		this.partecipant = partecipant;
	}
	
	
	
}
