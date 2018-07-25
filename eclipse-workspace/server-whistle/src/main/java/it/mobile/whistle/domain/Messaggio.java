package it.mobile.whistle.domain;

import java.util.Date;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "messaggi")
public class Messaggio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MESSAGGIO", nullable = false)
	private Long id;

	@Column(name = "BODY", nullable = false, length = 255)
	private String body;

	@Column(name = "DATA_MESSAGGIO", nullable = false)
	private Long date;

	@ManyToOne
	@JoinColumn(name = "ID_CHAT", nullable = false)
	private Chat relativoa;
	
	@ManyToOne
	@JoinColumn(name = "ID_UTENTE", nullable = false)
	private Utente author;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Chat getRelativoa() {
		return relativoa;
	}

	public void setRelativoa(Chat relativoa) {
		this.relativoa = relativoa;
	}

	public Long getDate() {
		return date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	public Utente getAuthor() {
		return author;
	}

	public void setAuthor(Utente author) {
		this.author = author;
	}
	
	
	
	
}