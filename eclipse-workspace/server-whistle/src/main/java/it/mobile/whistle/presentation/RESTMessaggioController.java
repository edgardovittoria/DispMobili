package it.mobile.whistle.presentation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/chat/{idOpener}/{idP}/{number}")
	public List<Messaggio> getMessage(@PathVariable Long idOpener, @PathVariable Long idP, @PathVariable int number){
		Utente opener = service.findUtenteById(idOpener);
		Utente partecipant = service.findUtenteById(idP);
		Chat Chat = service.findChat(opener,partecipant);
		List<Messaggio> listmessage = new ArrayList<>();
		if(Chat == null) {
			/*Chat newchat = new Chat();
			newchat.setOpener(opener);
			newchat.setPartecipant(partecipant);
			service.storeChat(newchat);*/
			return listmessage;
		}else {
			return listmessage = service.findMessageByChat(Chat.getId());
		}
		
		 
		
		
	}
	
	@PostMapping("/store/message")
	public void storeMessage(@RequestBody Messaggio messaggio) {
		//service.storeChat(messaggio.getRelativoa());
		if(messaggio.getRelativoa().getId() != null) {
			service.storeMessage(messaggio);
		}
		else {
			
			Chat chat = service.findChat(messaggio.getRelativoa().getOpener(), messaggio.getRelativoa().getPartecipant());
			if(chat == null) {
				Chat newchat = new Chat();
				newchat.setOpener(messaggio.getRelativoa().getOpener());
				newchat.setPartecipant(messaggio.getRelativoa().getPartecipant());
				service.storeChat(newchat);
				Chat chat1 = service.findChat(messaggio.getRelativoa().getOpener(), messaggio.getRelativoa().getPartecipant());
				messaggio.setRelativoa(chat1);
				service.storeMessage(messaggio);
				
			}else {
				messaggio.setRelativoa(chat);
				service.storeMessage(messaggio);
			}
			
		}
		
	}
	
	@DeleteMapping("/delete/message/{idMessage}")
	public void deleteMessage(@PathVariable Long idMessage) {
		
	}
}
