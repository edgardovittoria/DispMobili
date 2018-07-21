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
		int size = whistle.size();
		
		List<WhistleResponse> listwhistle = new ArrayList<WhistleResponse>();
		//Utente utente = Utility.getUtente();
		List<Long> id_reaction = new ArrayList<>();
		
		for(int i = 0;i<size;i++) {
			WhistleResponse whistleResponse = new WhistleResponse();
			
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
			
			/*for(int j = 0;j<r;j++) {
				//id_reaction.add(reactions.get(j).getId());
			}*/
			
			//whistleResponse.setId_reaction(id_reaction);
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
