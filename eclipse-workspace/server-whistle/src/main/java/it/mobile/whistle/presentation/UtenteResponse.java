package it.mobile.whistle.presentation;


import it.mobile.whistle.domain.Utente;

public class UtenteResponse {

	private String username;
	private String name;
	private String surname;
	private String email;
	
	
	public UtenteResponse() {
	}
	
	public UtenteResponse(Utente utente) {
		this.name = utente.getName();
		this.surname = utente.getSurname();
		this.username = utente.getUsername();
		this.email = utente.getEmail();
		
	}
	
	public String getNome() {
		return name;
	}
	public void setNome(String name) {
		this.name = name;
	}
	public String getCognome() {
		return surname;
	}
	public void setCognome(String surname) {
		this.surname = surname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
