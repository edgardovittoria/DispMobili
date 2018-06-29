package it.univaq.disim.mobile.myunivaq.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("studente")
public class Studente extends Utente {

}
