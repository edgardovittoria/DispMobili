package it.mobile.whistle.domain;


import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "Chat")
public class Chat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CHAT", nullable = false)
	private Long id;

	/*@Column(name = "DATA_PUBBLICAZIONE", nullable = false)
	private Date dataPubblicazione;*/

	@ManyToOne
	@JoinColumn(name = "ID_USER", nullable = false)
	private User apertaDa;
	
	
}