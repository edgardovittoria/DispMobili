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
import it.mobile.whistle.domain.Commento;



@RestController
@RequestMapping("/api")
public class RESTCommentoController {

	@Autowired
	private WhistleService service;
	
	@GetMapping("/comments/{idWhistle}/{number}")
	public List<Commento> list(@PathVariable long idWhistle, @PathVariable int number) {
		List<Commento> listcomments = service.findAllCommenti(idWhistle);
		int size = listcomments.size();
		
		for(int j = size - 1;j >= 2*(number + 1);j--) {
			Commento comment = listcomments.remove(j);
			listcomments.remove(comment);
		}
		for(int i = 0; i < 2*number && i<size;i++) {
				Commento comment2 = listcomments.remove(0);
				listcomments.remove(comment2);
		}
		return listcomments;
	}
	
	@PostMapping("/store/comment")
	public void storeCommento(@RequestBody Commento commento) {
		service.createCommento(commento);
	}
	
	@DeleteMapping("/delete/comment/{idComment}")
	public void deleteCommento(@PathVariable long idComment) {
		service.deleteCommento(idComment);
	}
}
