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
    
	@Column(name = "TYPE", nullable = false, length = 255)
	private String type;

	@Column(name = "DATE", nullable = false)
	private Date date;

	@ManyToOne
	@JoinColumn(name = "ID_USER", nullable = false)
	private Utente author;
	
	@Column(name = "LATITUDE", nullable = false, length = 255)
	private double latitude;
	
	@Column(name = "LONGITUDE", nullable = false, length = 255)
	private double longitude;
	
	@Column(name = "COMMENTS", nullable = false)
	private int comments;
	
	@Column(name = "REACTIONS", nullable = false)
	private int reactions;
	
	
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
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Utente getAuthor() {
		return author;
	}

	public void setAuthor(Utente author) {
		this.author = author;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public int getComments() {
		return comments;
	}

	public void setComments(int comments) {
		this.comments = comments;
	}

	public int getReactions() {
		return reactions;
	}

	public void setReactions(int reactions) {
		this.reactions = reactions;
	}



	

	
	
	
	
}