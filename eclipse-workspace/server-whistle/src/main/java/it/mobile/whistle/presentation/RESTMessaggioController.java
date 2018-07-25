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
		Utente p = service.findPartecipant(opener, partecipant);
		Utente o = service.findOpener(opener, partecipant);
		Chat Chat = service.findChat(o,p);
		
		List<Messaggio> listmessage = service.findMessageByChat(Chat.getId());
		/*int size = listmessage.size();
		
		
		for(int z = 0;z<size;z++) {
			MessaggioResponse messaggioResponse = new MessaggioResponse();
			
			messaggioResponse.setAuthor(listmessage.get(z).getAuthor());
			messaggioResponse.setBody(listmessage.get(z).getBody());
			messaggioResponse.setId(listmessage.get(z).getId());
			messaggioResponse.setRelativoa(listmessage.get(z).getRelativoa());
			messaggioResponse.setTime(listmessage.get(z).getDate().getTime());
			
			listmessageresp.add(messaggioResponse);
		}
		/*for(int j = size - 1;j >= 40*(number + 1);j--) {
			Messaggio mex1 = listmessage.remove(j);
			listmessage.remove(mex1);
		}
		for(int i = 0; i < 40*number && i<size;i++) {
				Messaggio mex2 = listmessage.remove(0);
				listmessage.remove(mex2);
		}*/
		return listmessage;
		
		
	}
	
	@PostMapping("/store/message")
	public void storeMessage(@RequestBody Messaggio messaggio) {
		//service.storeChat(messaggio.getRelativoa());
		service.storeMessage(messaggio);
	}
	
	@DeleteMapping("/delete/message/{idMessage}")
	public void deleteMessage(@PathVariable Long idMessage) {
		
	}
}
