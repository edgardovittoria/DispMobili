package it.mobile.whistle.presentation;

import it.mobile.whistle.domain.Chat;
import it.mobile.whistle.domain.Utente;

public class MessaggioResponse {

	private Long id;
	private String body;
	private Chat relativoa;
	private Utente author;
	private Long time;
	
	public Long getId() {
		return id;
	}
	public String getBody() {
		return body;
	}
	public Chat getRelativoa() {
		return relativoa;
	}
	public Utente getAuthor() {
		return author;
	}
	public Long getTime() {
		return time;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public void setRelativoa(Chat relativoa) {
		this.relativoa = relativoa;
	}
	public void setAuthor(Utente author) {
		this.author = author;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	
	
}
