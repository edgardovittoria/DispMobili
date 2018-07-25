package it.mobile.whistle.presentation;

import java.util.Date;

import it.mobile.whistle.domain.Utente;

public class WhistleResponse {

	private Long id;
	private String body;
	private String type;
	private Long date;
	private Utente author;
	private double latitude;
	private double longitude;
	private int comments;
	private int reactions;
	private Long id_reaction;
	
	public WhistleResponse() {}
	
	public Long getId() {
		return id;
	}
	public String getBody() {
		return body;
	}
	public String getType() {
		return type;
	}
	public Long getDate() {
		return date;
	}
	public Utente getAuthor() {
		return author;
	}
	public double getLatitude() {
		return latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public int getComments() {
		return comments;
	}
	public int getReactions() {
		return reactions;
	}
	public Long getId_reaction() {
		return id_reaction;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setDate(Long date) {
		this.date = date;
	}
	public void setAuthor(Utente author) {
		this.author = author;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public void setComments(int comments) {
		this.comments = comments;
	}
	public void setReactions(int reactions) {
		this.reactions = reactions;
	}
	public void setId_reaction(Long id_reaction) {
		this.id_reaction = id_reaction;
	}
	
	
	
	
}
