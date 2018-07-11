package it.mobile.whistle.domain;

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
@Table(name="Reactions")
public class Reactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_REACTIONS", nullable = false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ID_USER", nullable = false)
	private Utente reactionsOf;
	
	@Column(name = "TYPE", nullable = false)
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "ID_WHISTLE", nullable = false)
	private Whistle whistle;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Utente getReactionsOf() {
		return reactionsOf;
	}

	public void setReactionsOf(Utente reactionsOf) {
		this.reactionsOf = reactionsOf;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Whistle getWhistle() {
		return whistle;
	}

	public void setWhistle(Whistle whistle) {
		this.whistle = whistle;
	}
	
	
	
}
