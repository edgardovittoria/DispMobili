package it.mobile.whistle.presentation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.mobile.whistle.business.WhistleService;
import it.mobile.whistle.domain.Commento;
import it.mobile.whistle.domain.Reactions;
import it.mobile.whistle.domain.Utente;
import it.mobile.whistle.domain.Whistle;

@RestController
@RequestMapping("/api")
public class RESTWhistleController {

	@Autowired
	private WhistleService service;
	
	@GetMapping("/whistle/{latitude}/{longitude}")
	public List<Whistle> list(@PathVariable double latitude, @PathVariable double longitude) {
		
		List<Whistle> whistle = service.findWhistle(latitude, longitude);
		for(int i = 0;whistle.size()>i;i++) {
			List<Reactions> reactions = service.findAllReactions(whistle.get(i).getId());
			List<Commento> comments = service.findAllCommenti(whistle.get(i).getId());
			int r = reactions.size();
			int c = comments.size();
			whistle.get(i).setReactions(r);
			whistle.get(i).setComments(c);
		}
		
		return whistle;
	}
	
	@GetMapping("/Call")
	public List<Whistle> listCall() {
		return service.findAllCall();
	}
	
	@GetMapping("/whistle/{id}")
	public Whistle findById(@PathVariable Long id) {
		return service.findWhistleById(id);
	}
	@PostMapping("/store/whistle")
	public void storeWhistle(@RequestBody Whistle whistle) {
		service.createWhistle(whistle);
	}
	

}
