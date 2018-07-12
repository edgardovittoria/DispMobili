package it.mobile.whistle;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import it.mobile.whistle.domain.Call;
import it.mobile.whistle.domain.CallsType;
import it.mobile.whistle.domain.Chat;
import it.mobile.whistle.domain.Commento;
import it.mobile.whistle.domain.Messaggio;
import it.mobile.whistle.domain.Reactions;
import it.mobile.whistle.domain.Utente;
import it.mobile.whistle.domain.Whistle;

import it.mobile.whistle.business.impl.repositories.WhistleRepository;
import it.mobile.whistle.business.impl.repositories.ChatRepository;
import it.mobile.whistle.business.impl.repositories.CommentoRepository;
import it.mobile.whistle.business.impl.repositories.MessageRepository;
import it.mobile.whistle.business.impl.repositories.ReactionsRepository;
import it.mobile.whistle.business.impl.repositories.UtenteRepository;

@SpringBootApplication
public class WhistleApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public CommandLineRunner loadData(UtenteRepository utenteRepository, WhistleRepository whistleRepository, CommentoRepository commentoRepository, ReactionsRepository reactionsRepository, ChatRepository chatRepository, MessageRepository messageRepository) {
		return (args) -> {
			
			Utente federico = new Utente();
			federico.setSurname("Raparelli");
			federico.setName("Federico");
			federico.setEmail("federap@hotmail.it");
			federico.setPassword(passwordEncoder.encode("pluto"));
			federico.setUsername("federap");
			federico.setDescription("");
			federico.setPhoto("");
			federico.setSolved_calls(2);
			federico = utenteRepository.save(federico);
			
			Utente edgardo = new Utente();
			edgardo.setSurname("Vittoria");
			edgardo.setName("Edgardo");
			edgardo.setEmail("edgardovittoria@hotmail.it");
			edgardo.setPassword(passwordEncoder.encode("pippo"));
			edgardo.setUsername("edgvit");
			edgardo.setDescription("");
			edgardo.setPhoto("");
			edgardo.setSolved_calls(1);
			edgardo = utenteRepository.save(edgardo);
			
			
			Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"),Locale.ITALY);
			Date today = calendar.getTime();
			
			Whistle whistle = new Whistle();
			whistle.setBody("Ciao");
			whistle.setDate(today);
			whistle.setLatitude(41.762816);
			whistle.setLongitude(14.094336);
			whistle.setAuthor(federico);
			whistle = whistleRepository.save(whistle);
			
			
			Whistle whistle2 = new Whistle();
			whistle2.setBody("Forza Inter");
			whistle2.setDate(today);
			whistle2.setLatitude(41.763816);
			whistle2.setLongitude(14.084336);
			whistle2.setAuthor(edgardo);
			whistle2 = whistleRepository.save(whistle2);
			
			Call call = new Call();
			call.setBody("Ciao...qualcuno è disposto a prendere un caffe al tropical??");
			call.setCallsType(CallsType.CAFFE);
			call.setDate(today);
			call.setLatitude(41.753816);
			call.setLongitude(14.084336);
			call.setAuthor(federico);
			call = whistleRepository.save(call);
			
			Call call1 = new Call();
			call1.setBody("Ciao...qualcuno può gentilmente darmi un oki...mi scoppia la testa dopo aver usato spring boot XD?");
			call1.setCallsType(CallsType.MEDICINALI);
			call1.setDate(today);
			call1.setLatitude(41.743816);
			call1.setLongitude(14.074336);
			call1.setAuthor(edgardo);
			call1 = whistleRepository.save(call1);
			
			Commento commento1 = new Commento();
			commento1.setBody("come stai?");
			commento1.setAuthor(edgardo);
			commento1.setDate(today);
			commento1.setId_whistle(whistle);
			commento1 = commentoRepository.save(commento1);
			
			Commento commento2 = new Commento();
			commento2.setBody("Bestia");
			commento2.setAuthor(edgardo);
			commento2.setDate(today);
			commento2.setId_whistle(whistle);
			commento2 = commentoRepository.save(commento2);
			
			Reactions reaction1 = new Reactions();
			reaction1.setReactionsOf(edgardo);
			reaction1.setType("LIKE");
			reaction1.setWhistle(whistle2);
			reaction1 = reactionsRepository.save(reaction1);
			
			
			Reactions reaction2 = new Reactions();
			reaction2.setReactionsOf(edgardo);
			reaction2.setType("LIKE");
			reaction2.setWhistle(whistle);
			reaction2 = reactionsRepository.save(reaction2);
			
			Chat chat = new Chat();
			chat.setOpener(edgardo);
			chat.setPartecipant(federico);
			chat = chatRepository.save(chat);
			
			Messaggio mex = new Messaggio();
			mex.setAuthor(edgardo);
			mex.setBody("isiyafyigaiusfgiuha");
			mex.setDate(today);
		    mex.setRelativoA(chat);
		    mex = messageRepository.save(mex);;
			

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(WhistleApplication.class, args);
	}

}
