package it.mobile.whistle.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "partecipazionechat")
public class PartecipazioneChat {

	/*@Id
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
	@JoinTable(name="PARTECIPAZIONE_CHAT",
	    joinColumns={@JoinColumn(name="ID_CHAT")},
	    inverseJoinColumns={@JoinColumn(name="ID_USER")})
	private Set<User> userPartecipanti = new HashSet<User>();

	public Set<User> getUserPartecipanti() {
		return userPartecipanti;
	}

	public void setUserPartecipanti(Set<User> userPartecipanti) {
		this.userPartecipanti = userPartecipanti;
	}
	
	
}