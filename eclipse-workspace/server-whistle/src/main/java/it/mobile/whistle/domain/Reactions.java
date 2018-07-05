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
	
	@ManyToMany
	@JoinTable(name="REACTIONS_WHISTLE",
	    joinColumns={@JoinColumn(name="ID_REACTIONS")},
	    inverseJoinColumns={@JoinColumn(name="ID_WHISTLE")})
	private Set<Reactions> reatctions = new HashSet<Reactions>();
	
}
