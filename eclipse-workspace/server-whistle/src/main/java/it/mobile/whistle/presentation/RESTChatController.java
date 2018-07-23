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
import it.mobile.whistle.domain.Chat;

@RestController
@RequestMapping("/api")
public class RESTChatController {

	@Autowired
	private WhistleService service;
	
	@GetMapping("/chatlist/{idUtente}")
	public List<Chat> list(@PathVariable Long idUtente) {
		return service.findChatByUserOrPartecipant(idUtente, idUtente);
	}
	
	@PostMapping("/store/chat")
	public void storeChat(Chat chat) {
		service.storeChat(chat);
	}
	
	@DeleteMapping("/delete/chat/{idChat}")
	public void deleteMessagge(@PathVariable Long idChat){
		service.deleteChat(idChat);
	}
}
