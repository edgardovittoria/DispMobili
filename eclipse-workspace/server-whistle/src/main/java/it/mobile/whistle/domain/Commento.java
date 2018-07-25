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
@Table(name = "commenti")
public class Commento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_COMMENTO", nullable = false)
	private Long id;
	
	@Column(name = "DATA_COMMENTO", nullable = false)
	private Long date;
	
	@Column(name = "body", nullable = false, length = 255)
	private String body;
	
	@ManyToOne
	@JoinColumn(name = "ID_UTENTE", nullable = false)
	private Utente author;
	
	@ManyToOne
	@JoinColumn(name = "ID_WHISTLE", nullable = false)
	private Whistle whistle;
	
	

	public Whistle getId_whistle() {
		return whistle;
	}

	public void setId_whistle(Whistle id_whistle) {
		this.whistle = id_whistle;
	}

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