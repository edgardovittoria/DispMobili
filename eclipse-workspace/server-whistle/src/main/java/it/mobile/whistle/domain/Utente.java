package it.mobile.whistle.domain;

//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "utenti")
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USER", nullable = false)
	private Long id;
	
	@Column(name = "EMAIL", nullable = false, length = 255)
	private String email;

	@Column(name = "name", nullable = false, length = 255)
	private String name;

	@Column(name = "surname", nullable = false, length = 255)
	private String surname;

	@Column(name = "USERNAME", nullable = false, length = 16, updatable = false, unique = true)
	private String username;

	@JsonIgnore
	@Column(name = "PASSWORD", nullable = false, length = 255)
	private String password;
	
	@Column(name = "PHOTO", nullable = false, length = 255)
	private String photo;
	
	@Column(name = "DESCRIPTION", nullable = false, length = 255)
	private String description;
	
	@Column(name = "SOLVED_CALLS", nullable = false, length = 255)
	private int solved_calls;
	
	//private List<Chat> chats;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/*public List<Chat> getChats() {
		return chats;
	}

	public void setChats(List<Chat> chats) {
		this.chats = chats;
	}*/
	

	
}