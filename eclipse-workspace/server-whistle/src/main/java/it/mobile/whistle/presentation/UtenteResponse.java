package it.mobile.whistle.presentation;


import it.mobile.whistle.domain.Utente;

public class UtenteResponse {
    
	private Long   id;
	private String username;
	private String name;
	private String surname;
	private String email;
	private String password;
	private String photo;
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
		this.password = utente.getPassword();
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
