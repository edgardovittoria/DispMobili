package it.mobile.whistle.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Table(name = "whistle")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPOLOGIA_WHISTLE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("whistle")
public class Whistle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_WHISTLE", nullable = false)
	private Long id;

	@Column(name = "BODY", nullable = false, length = 255)
	private String body;


	@Column(name = "DATA_PUBBLICAZIONE", nullable = false)
	private Date dataPubblicazione;

	@ManyToOne
	@JoinColumn(name = "ID_USER", nullable = false)
	private Utente pubblicatoDa;
	
	
	@Column(name = "LOCATION", nullable = false, length = 255)
	private String location;

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

	public Date getDataPubblicazione() {
		return dataPubblicazione;
	}

	public void setDataPubblicazione(Date dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
	}

	public Utente getPubblicatoDa() {
		return pubblicatoDa;
	}

	public void setPubblicatoDa(Utente pubblicatoDa) {
		this.pubblicatoDa = pubblicatoDa;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	
}