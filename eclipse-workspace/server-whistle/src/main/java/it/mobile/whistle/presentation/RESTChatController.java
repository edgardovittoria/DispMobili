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
import it.mobile.whistle.common.Utility;
import it.mobile.whistle.domain.Chat;
import it.mobile.whistle.domain.Utente;

@RestController
@RequestMapping("/api")
public class RESTChatController {

	@Autowired
	private WhistleService service;
	
	@GetMapping("/chatlist/{idUtente}")
	public List<ChatResponse> list(@PathVariable Long idUtente) {
		List<Chat> chatlist = service.findChatByUserOrPartecipant(idUtente, idUtente);
		Utente utente = Utility.getUtente();
		int size = chatlist.size();
		List<ChatResponse> listchatResponse = new ArrayList<ChatResponse>();
		for(int i=0;i<size;i++) {
			ChatResponse chat = new ChatResponse();
			chat.setId_chat(chatlist.get(i).getId());
			if(utente.getId() == chatlist.get(i).getOpener().getId()) {
				chat.setPartecipant(chatlist.get(i).getPartecipant());
			}
			else{
				chat.setPartecipant(chatlist.get(i).getOpener());
			}
			listchatResponse.add(chat);
		}
		
		return listchatResponse;
	}
	
	@PostMapping("/store/chat")
	public Chat storeChat(Chat chat) {
		service.storeChat(chat);
		Utente opener = chat.getOpener();
		Utente partecipant = chat.getPartecipant();
		return service.findChat(opener, partecipant);
	}
	
	@DeleteMapping("/delete/chat/{idChat}")
	public void deleteMessagge(@PathVariable Long idChat){
		service.deleteChat(idChat);
	}
}
