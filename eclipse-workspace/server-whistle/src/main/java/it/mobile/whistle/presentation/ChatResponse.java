package it.mobile.whistle.presentation;

import it.mobile.whistle.domain.Utente;

public class ChatResponse {

	private Long id_chat;
	private Utente partecipant;
	public Long getId_chat() {
		return id_chat;
	}
	public Utente getPartecipant() {
		return partecipant;
	}
	public void setId_chat(Long id_chat) {
		this.id_chat = id_chat;
	}
	public void setPartecipant(Utente partecipant) {
		this.partecipant = partecipant;
	}
	
	
}
