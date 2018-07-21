package it.mobile.whistle.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.mobile.whistle.business.WhistleService;
import it.mobile.whistle.domain.Reactions;

@RestController
@RequestMapping("/api")
public class RESTChatController {

	@Autowired
	private WhistleService service;
	
	@GetMapping("/chat")
	public List<Reactions> list(@PathVariable long idWhistle) {
		return service.findAllReactions(idWhistle);
	}
}
