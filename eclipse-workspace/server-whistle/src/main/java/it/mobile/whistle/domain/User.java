package it.mobile.whistle.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "utenti")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USER", nullable = false)
	private Long id;
	
	@Column(name = "EMAIL", nullable = false, length = 255)
	private String email;

	@Column(name = "NOME", nullable = false, length = 255)
	private String nome;

	@Column(name = "COGNOME", nullable = false, length = 255)
	private String cognome;

	/*@Column(name = "USERNAME", nullable = false, length = 16, updatable = false, unique = true)
	private String username;*/

	@JsonIgnore
	@Column(name = "PASSWORD", nullable = false, length = 255)
	private String password;
	
	@Column(name = "PHOTO", nullable = false, length = 255)
	private String photo;
	
	@Column(name = "DESCRIPTION", nullable = false, length = 255)
	private String description;
	
	@Column(name = "SOLVED_CALLS", nullable = false, length = 255)
	private int solved_calls;

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
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
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

/*	@Column(name = "MATRICOLA", nullable = true, length = 6)
	private String matricola;

	@Column(name = "TELEFONO", nullable = true, length = 20)
	private String telefono;*/
	
	
}