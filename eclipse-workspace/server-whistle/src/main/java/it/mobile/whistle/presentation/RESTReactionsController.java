package it.mobile.whistle.presentation;

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
import it.mobile.whistle.domain.Reactions;

@RestController
@RequestMapping("/api")
public class RESTReactionsController {

	@Autowired
	private WhistleService service;
	
	@GetMapping("/reactions/{idWhistle}")
	public List<Reactions> list(@PathVariable long idWhistle) {
		return service.findAllReactions(idWhistle);
	}
	@PostMapping("/store/reaction")
	public void storeReaction(@RequestBody Reactions reactions) {
		service.createReaction(reactions);
	}
	@DeleteMapping("/delete/reaction/{idReaction}")
	public void deleteReaction(@PathVariable long reactions) {
		service.deleteReaction(reactions);
	}
}