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
import it.mobile.whistle.business.impl.repositories.MessaggioRepository;
import it.mobile.whistle.business.impl.repositories.ReactionsRepository;
import it.mobile.whistle.business.impl.repositories.UtenteRepository;

@SpringBootApplication
public class WhistleApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public CommandLineRunner loadData(UtenteRepository utenteRepository, WhistleRepository whistleRepository, CommentoRepository commentoRepository, ReactionsRepository reactionsRepository, ChatRepository chatRepository, MessaggioRepository messageRepository) {
		return (args) -> {
			
			
			Utente Jessica = new Utente();
			Jessica.setSurname("Neri");
			Jessica.setName("Jessica");
			Jessica.setEmail("JessicaMatt@hotmail.it");
			Jessica.setPassword(passwordEncoder.encode("pluto"));
			Jessica.setUsername("jessica");
			Jessica.setDescription("Carpe Diem");
			Jessica.setPhoto("Jessica.jpg");
			Jessica.setSolved_calls(2);
			Jessica = utenteRepository.save(Jessica);
			
			Utente Heisenberg = new Utente();
			Heisenberg.setSurname("Palm");
			Heisenberg.setName("Heisenberg");
			Heisenberg.setEmail("Heisenberg@hotmail.it");
			Heisenberg.setPassword(passwordEncoder.encode("pippo"));
			Heisenberg.setUsername("Heisenberg");
			Heisenberg.setDescription("Say my name");
			Heisenberg.setPhoto("Heisenberg.jpg");
			Heisenberg.setSolved_calls(1);
			Heisenberg = utenteRepository.save(Heisenberg);
			
			
			Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"),Locale.ITALY);
			Long today = calendar.getTimeInMillis();
			
			Whistle whistle = new Whistle();
			whistle.setBody("Il peggior tradimento che potete fare a voi stessi è non fare ciò per cui vi brillano gli occhi");
			whistle.setType("Fun");
			whistle.setDate(today);
			whistle.setLatitude(41.762816);
			whistle.setLongitude(14.094336);
			whistle.setAuthor(Jessica);
			whistle = whistleRepository.save(whistle);
			
			Whistle whistle3 = new Whistle();
			whistle3.setBody("I'm not in danger, i'm the danger");
			whistle3.setType("Fun");
			whistle3.setDate(today);
			whistle3.setLatitude(15.763816);
			whistle3.setLongitude(5.084336);
			whistle3.setAuthor(Heisenberg);
			whistle3 = whistleRepository.save(whistle3);
			
			Call call = new Call();
			call.setBody("Ciao...qualcuno è disposto a prendere un caffe al tropical??");
			call.setType("Call");
			call.setCallsType(CallsType.Break);
			call.setDate(today-2*(86400000));
			call.setLatitude(41.753816);
			call.setLongitude(14.084336);
			call.setAuthor(Jessica);
			call = whistleRepository.save(call);
			
			Call call1 = new Call();
			call1.setBody("Ciao...qualcuno può gentilmente darmi un oki...mi scoppia la testa dopo aver usato spring boot XD?");
			call1.setType("Call");
			call1.setCallsType(CallsType.Medical);
			call1.setDate(today);
			call1.setLatitude(41.743816);
			call1.setLongitude(14.074336);
			call1.setAuthor(Jessica);
			call1 = whistleRepository.save(call1);
			
			Whistle whistle2 = new Whistle();
			whistle2.setBody("Non ti curar di loro ma guarda e passa");
			whistle2.setType("Fun");
			whistle2.setDate(today-86400000);
			whistle2.setLatitude(41.763816);
			whistle2.setLongitude(14.084336);
			whistle2.setAuthor(Heisenberg);
			whistle2 = whistleRepository.save(whistle2);
 
			
			Commento commento1 = new Commento();
			commento1.setBody("come stai?");
			commento1.setAuthor(Heisenberg);
			commento1.setDate(today);
			commento1.setId_whistle(whistle);
			commento1 = commentoRepository.save(commento1);
			
			Commento commento2 = new Commento();
			commento2.setBody("Tutto bene Hesinberg...Tu come stai??");
			commento2.setAuthor(Jessica);
			commento2.setDate(today);
			commento2.setId_whistle(whistle);
			commento2 = commentoRepository.save(commento2);
			
			Commento commento3 = new Commento();
			commento3.setBody("Tutto bene grazie <3<3");
			commento3.setAuthor(Heisenberg);
			commento3.setDate(today);
			commento3.setId_whistle(whistle);
			commento3 = commentoRepository.save(commento3);
			
			Commento commento4 = new Commento();
			commento4.setBody("<3<3<3<3<3<3<3<3");
			commento4.setAuthor(Heisenberg);
			commento4.setDate(today);
			commento4.setId_whistle(whistle);
			commento4 = commentoRepository.save(commento4);
			
			
			Reactions reaction1 = new Reactions();
			reaction1.setReactionsOf(Jessica);
			reaction1.setWhistle(whistle2);
			reaction1 = reactionsRepository.save(reaction1);
			
			
			Reactions reaction2 = new Reactions();
			reaction2.setReactionsOf(Heisenberg);
			reaction2.setWhistle(whistle);
			reaction2 = reactionsRepository.save(reaction2);
			
			Reactions reaction3 = new Reactions();
			reaction3.setReactionsOf(Jessica);
			reaction3.setWhistle(call);
			reaction3 = reactionsRepository.save(reaction3);
			
			Chat chat = new Chat();
			chat.setOpener(Heisenberg);
			chat.setPartecipant(Jessica);
			chat = chatRepository.save(chat);
			
			Messaggio mex = new Messaggio();
			mex.setAuthor(Heisenberg);
			mex.setBody("Ciao Jessica, Volevo chiederti se per favore potresti"
					+ "chiamare Giovanni e avvisarlo che faccio tardi"
					+ "per la cena...Ho avuto in imprevisto...scusami");
			mex.setDate(today);
		    mex.setRelativoa(chat);
		    mex = messageRepository.save(mex);
		    
		    Messaggio mex1 = new Messaggio();
			mex1.setAuthor(Jessica);
			mex1.setBody("Ok Hisenberg. Avviso subito Giovanni");
			mex1.setDate(today);
		    mex1.setRelativoa(chat);
		    mex1 = messageRepository.save(mex1);
			

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(WhistleApplication.class, args);
	}

}
