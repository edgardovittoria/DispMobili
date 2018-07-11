package it.mobile.whistle.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	private Date date;
	
	@Column(name = "body", nullable = false, length = 255)
	private String body;
	
	@ManyToOne
	@JoinColumn(name = "ID_UTENTE", nullable = false)
	private Utente author;
	
	@ManyToMany
	@JoinTable(name="COMMENTI_WHISTLE",
	    joinColumns={@JoinColumn(name="ID_COMMENTO")},
	    inverseJoinColumns={@JoinColumn(name="ID_WHISTLE")})
	private Set<Commento> commenti = new HashSet<Commento>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataCommento() {
		return date;
	}

	public void setDataCommento(Date date) {
		this.date = date;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	/*public Set<Whistle> getWhistleCommentati() {
		return whistleCommentati;
	}

	public void setWhistleCommentati(Set<Whistle> whistleCommentati) {
		this.whistleCommentati = whistleCommentati;
	}*/
	
	
}