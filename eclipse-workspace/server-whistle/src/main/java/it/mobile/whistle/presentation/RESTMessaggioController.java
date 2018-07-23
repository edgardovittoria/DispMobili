package it.mobile.whistle.presentation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.mobile.whistle.business.WhistleService;
import it.mobile.whistle.domain.Chat;
import it.mobile.whistle.domain.Messaggio;
import it.mobile.whistle.domain.Utente;

@RestController
@RequestMapping("/api")
public class RESTMessaggioController {

	@Autowired
	private WhistleService service;
	
	/*@GetMapping("/a/{idOpener}/{idP}")
	public List<Utente> a(@PathVariable Long idOpener, @PathVariable Long idP) {
		Utente opener = service.findUtenteById(idOpener);
		Utente partecipant = service.findUtenteById(idP);
		//Utente p = service.findPartecipant(opener, partecipant);
		return service.findPartecipant(opener, partecipant);
	}*/
	
	@GetMapping("/chat/{idOpener}/{idP}")
	public List<Messaggio> getMessage(@PathVariable Long idOpener, @PathVariable Long idP){
		Utente opener = service.findUtenteById(idOpener);
		Utente partecipant = service.findUtenteById(idP);
		Utente p = service.findPartecipant(opener, partecipant);
		Utente o = service.findOpener(opener, partecipant);
		Chat Chat = service.findChat(o,p);
		return service.findMessageByChat(Chat.getId());
		
		/*List<Messaggio> messages = new ArrayList<Messaggio>();
		return messages;*/
	}
	
	@PostMapping("/store/message")
	public void storeMessage(Messaggio messaggio) {
		service.storeMessage(messaggio);
	}
	
	@DeleteMapping("/delete/message/{idMessage}")
	public void deleteMessage(@PathVariable Long idMessage) {
		
	}
}
