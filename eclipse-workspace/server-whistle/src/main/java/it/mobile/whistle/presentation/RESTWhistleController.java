package it.mobile.whistle.presentation;

import java.util.ArrayList;
import java.util.Collections;
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
import it.mobile.whistle.common.Utility;
import it.mobile.whistle.domain.Commento;
import it.mobile.whistle.domain.Reactions;
import it.mobile.whistle.domain.Utente;
import it.mobile.whistle.domain.Whistle;

@RestController
@RequestMapping("/api")
public class RESTWhistleController {

	@Autowired
	private WhistleService service;
	
	@GetMapping("/whistle/{latitude}/{longitude}/{number}")
	public List<WhistleResponse> list(@PathVariable double latitude, @PathVariable double longitude, @PathVariable int number) {
		
		List<Whistle> whistle = service.findWhistle(latitude, longitude);
		Collections.reverse(whistle);
		int size = whistle.size();
		List<WhistleResponse> listwhistle = new ArrayList<WhistleResponse>();
		Utente utente = Utility.getUtente();
		Long idUtente = utente.getId();
		
		
		for(int i = 0;size>i;i++) {
			WhistleResponse whistleResponse = new WhistleResponse();
			//Reactions react = new Reactions();
			
			whistleResponse.setId(whistle.get(i).getId());
			whistleResponse.setAuthor(whistle.get(i).getAuthor());
			whistleResponse.setBody(whistle.get(i).getBody());
			
			whistleResponse.setDate(whistle.get(i).getDate());
			whistleResponse.setLatitude(whistle.get(i).getLatitude());
			whistleResponse.setLongitude(whistle.get(i).getLongitude());
			
			whistleResponse.setType(whistle.get(i).getType());
			
			
			List<Reactions> reactions = service.findAllReactions(whistle.get(i).getId());
			List<Commento> comments = service.findAllCommenti(whistle.get(i).getId());
			int r = reactions.size();
			int c = comments.size();
			whistle.get(i).setReactions(r);
			whistle.get(i).setComments(c);
			whistleResponse.setComments(whistle.get(i).getComments());
			whistleResponse.setReactions(whistle.get(i).getReactions());
			
			Reactions react = service.getIdReaction(idUtente, whistle.get(i).getId());
			if(react != null) {
				whistleResponse.setId_reaction(react.getId());
			}
			else {
				whistleResponse.setId_reaction(null);
			}
			
			
			listwhistle.add(whistleResponse);	
			
		}
		
		for(int j = size - 1;j >= 4*(number + 1);j--) {
			WhistleResponse whistle1 = listwhistle.remove(j);
			listwhistle.remove(whistle1);
		}
		for(int i = 0; i < 4*number && i<size;i++) {
				WhistleResponse whistle2 = listwhistle.remove(0);
				listwhistle.remove(whistle2);
		}
	
		return listwhistle;
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
	@DeleteMapping("/delete/whistle/{idWhistle}")
	public void deleteWhistle(@PathVariable long idWhistle) {
		service.deleteWhistle(idWhistle);
	}
	
	

}
