package it.mobile.whistle.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.mobile.whistle.business.WhistleService;
import it.mobile.whistle.domain.Whistle;

@RestController
@RequestMapping("/api/whistle")
public class RESTWhistleController {
	
	@Autowired
	private WhistleService service;
	
	@GetMapping
	public List<Whistle> list() {
		return service.findAllWhistle();
	}
	
	@GetMapping("/{id}")
	public Whistle findById(@PathVariable Long id) {
		return service.findWhistleById(id);
	}

}
