package it.mobile.whistle.presentation;


import java.nio.file.Path;

import it.mobile.whistle.domain.Utente;

public class UtenteResponse {
    
	private Long   id;
	private String username;
	private String name;
	private String surname;
	private String email;
	private byte[] photo;
	private String description;
	private int    solved_calls;
	
	public UtenteResponse() {
	}
	
	public UtenteResponse(Utente utente) {
		this.id = utente.getId();
		this.name = utente.getName();
		this.surname = utente.getSurname();
		this.username = utente.getUsername();
		this.email = utente.getEmail();
		this.photo = utente.getPhoto();
		this.description = utente.getDescription();
		this.solved_calls = utente.getSolved_calls();
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSolved_calls() {
		return solved_calls;
	}

	public void setSolved_calls(int solved_calls) {
		this.solved_calls = solved_calls;
	}
	
}
