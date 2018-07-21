package it.mobile.whistle.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.mobile.whistle.business.WhistleService;
import it.mobile.whistle.domain.Messaggio;

@RestController
@RequestMapping("/api")
public class RESTMessaggioController {

	@Autowired
	private WhistleService service;
	
	@GetMapping("/chat/{idChat}")
	public List<Messaggio> getMessage(@PathVariable Long idChat){
		return service.findMessageByChat(idChat);
	}
	
	@PostMapping("/store/message")
	public void storeMessage(Messaggio messaggio) {
		service.storeMessage(messaggio);
	}
	
	@DeleteMapping("/delete/message/{idMessage}")
	public void deleteMessage(@PathVariable Long idMessage) {
		
	}
}
