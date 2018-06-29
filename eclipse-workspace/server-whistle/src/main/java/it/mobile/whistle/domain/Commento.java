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
import javax.persistence.Table;

@Entity
@Table(name = "commenti")
public class Commento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_COMMENTO", nullable = false)
	private Long id;
	
	@Column(name = "DATA_COMMENTO", nullable = false)
	private Date dataCommento;
	
	@Column(name = "body", nullable = false, length = 255)
	private String body;
	
	/*@Enumerated(EnumType.STRING)
	private TipologiaEsame tipologiaEsame;*/
	

	/*@ManyToOne
    @JoinColumn(name = "ID_INSEGNAMENTO", nullable = false)
	private Insegnamento insegnamento;*/
	
	@ManyToMany
	@JoinTable(name="COMMENTI_WHISTLE",
	    joinColumns={@JoinColumn(name="ID_COMMENTO")},
	    inverseJoinColumns={@JoinColumn(name="ID_WHISTLE")})
	private Set<Whistle> whistleCommentati = new HashSet<Whistle>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataCommento() {
		return dataCommento;
	}

	public void setDataCommento(Date dataCommento) {
		this.dataCommento = dataCommento;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Set<Whistle> getWhistleCommentati() {
		return whistleCommentati;
	}

	public void setWhistleCommentati(Set<Whistle> whistleCommentati) {
		this.whistleCommentati = whistleCommentati;
	}
	
	
}