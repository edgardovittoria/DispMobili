package it.mobile.whistle.presentation;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;


import it.mobile.whistle.business.WhistleService;
import it.mobile.whistle.common.spring.security.JWTTokenUtil;
import it.mobile.whistle.common.spring.security.UserDetailsImpl;
import it.mobile.whistle.domain.Utente;

@RestController
@RequestMapping("/api")
public class RESTUtenteController {

	@Value("${jwt.header}")
	private String tokenHeader;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTTokenUtil jwtTokenUtil;

	@Autowired
	private WhistleService whistleService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/login")
	public UtenteResponse login(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) throws AuthenticationException {
		// Effettuo l'autenticazione
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Genero Token e lo inserisco nell'header di risposta
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String token = jwtTokenUtil.generateToken(userDetails);
		response.setHeader(tokenHeader, token);

		// Ritorno l'utente
		return new UtenteResponse(((UserDetailsImpl) userDetails).getUtente());
	}

	@PostMapping("/update/utente")
	public UtenteResponse updateProfilo(@RequestBody Utente utente) {
		Utente nuovoUtente = whistleService.updateProfilo(utente);		
		return new UtenteResponse(nuovoUtente);
	}
	
	@PostMapping("/signin")
	public boolean signin(@RequestBody AuthenticationRequest authenticationRequest) {
		Utente utente = new Utente();
		utente.setName(authenticationRequest.getName());
		utente.setEmail(authenticationRequest.getEmail());
		utente.setSurname(authenticationRequest.getSurname());
		utente.setUsername(authenticationRequest.getUsername());
		utente.setDescription("");
		utente.setPassword(passwordEncoder.encode(authenticationRequest.getPassword()));
		utente.setPhoto("icon1.jpg");
		Utente exist = whistleService.findUtenteByEmail(utente);
		if(exist == null) {
			whistleService.storeUtente(utente);
			return true;
		}
		else {
			return false;
		}
	}
	
}
