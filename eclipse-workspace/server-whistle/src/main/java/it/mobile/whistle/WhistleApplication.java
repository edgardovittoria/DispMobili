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
import it.mobile.whistle.domain.Commento;
import it.mobile.whistle.domain.Reactions;
import it.mobile.whistle.domain.Utente;
import it.mobile.whistle.domain.Whistle;

import it.mobile.whistle.business.impl.repositories.WhistleRepository;
import it.mobile.whistle.business.impl.repositories.CommentoRepository;
import it.mobile.whistle.business.impl.repositories.ReactionsRepository;
import it.mobile.whistle.business.impl.repositories.UtenteRepository;

@SpringBootApplication
public class WhistleApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public CommandLineRunner loadData(UtenteRepository utenteRepository, WhistleRepository whistleRepository, CommentoRepository commentoRepository, ReactionsRepository reactionsRepository) {
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
			whistle.setLocation("Roma");
			whistle.setAuthor(federico);
			whistle = whistleRepository.save(whistle);
			
			
			Whistle whistle2 = new Whistle();
			whistle2.setBody("Forza Inter");
			whistle2.setDate(today);
			whistle2.setLocation("Palena");
			whistle2.setAuthor(edgardo);
			whistle2 = whistleRepository.save(whistle2);
			
			Call call = new Call();
			call.setBody("Ciao...qualcuno è disposto a prendere un caffe al tropical??");
			call.setCallsType(CallsType.CAFFE);
			call.setDate(today);
			call.setLocation("L'Aquila");
			call.setAuthor(federico);
			call = whistleRepository.save(call);
			
			Call call1 = new Call();
			call1.setBody("Ciao...qualcuno può gentilmente darmi un oki...mi scoppia la testa dopo aver usato spring boot XD?");
			call1.setCallsType(CallsType.MEDICINALI);
			call1.setDate(today);
			call1.setLocation("L'Aquila");
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
			
			/*TipologiaNotizia tipologiaDidattica = new TipologiaNotizia();
			tipologiaDidattica.setNome("Didattica");
			tipologiaDidattica = tipologiaNotiziaRepository.save(tipologiaDidattica);

			TipologiaNotizia tipologiaLavoro = new TipologiaNotizia();
			tipologiaLavoro.setNome("Lavoro");
			tipologiaLavoro = tipologiaNotiziaRepository.save(tipologiaLavoro);

			CorsoDiLaurea corsoDiLaureaInformatica = new CorsoDiLaurea();
			corsoDiLaureaInformatica.setClasse("L-31");
			corsoDiLaureaInformatica.setNome("Informatica");
			corsoDiLaureaInformatica = corsoDiLaureaRepository.save(corsoDiLaureaInformatica);

			CorsoDiLaurea corsoDiLaureaMaster = new CorsoDiLaurea();
			corsoDiLaureaMaster.setClasse("L-32");
			corsoDiLaureaMaster.setNome("Master Web Technology");
			corsoDiLaureaMaster = corsoDiLaureaRepository.save(corsoDiLaureaMaster);
			
			Docente amleto = new Docente();
			amleto.setUsername("amleto");
			amleto.setPassword(passwordEncoder.encode("amleto"));
			amleto.setNome("Amleto");
			amleto.setCognome("Di Salle");
			amleto.setEmail("amleto.disalle@univaq.it");
			amleto.setMatricola("09999");
			amleto.setTelefono("+39.0862/433735");
			amleto = utenteRepository.save(amleto);
			
			Docente marco = new Docente();
			marco.setUsername("marco");
			marco.setPassword(passwordEncoder.encode("marco"));
			marco.setNome("Marco");
			marco.setCognome("Autili");
			marco.setEmail("marco.autili@univaq.it");
			marco.setMatricola("01111");
			marco.setTelefono("+39.0862/433xxx");
			marco = utenteRepository.save(marco);			

			Studente studente = new Studente();
			studente.setUsername("studente");
			studente.setPassword(passwordEncoder.encode("studente"));
			studente.setNome("Studente");
			studente.setCognome("Studente");
			studente.setEmail("studente.studente@student.univaq.it");
			studente.setMatricola("299999");
			studente.setCorsoDiLaurea(corsoDiLaureaInformatica);
			studente = utenteRepository.save(studente);

			for (int i = 0; i < 10; i++) {
				Notizia notizia = new Notizia();
				notizia.setNome("Lezioni del corso " + i);
				notizia.setDescrizione("Le lezioni di " + i + "  comprese nel periodo 11-24 Maggio 2018 si svolgeranno secondo il seguente calendario:");
				Date dataPubblicazione = new Date(System.currentTimeMillis() - (i * 86400000));
				notizia.setDataPubblicazione(dataPubblicazione);
				notizia.setPubblicatoDa(amleto);
				notizia.setTipologia(tipologiaDidattica);
				notiziaRepository.save(notizia);
			}

			Insegnamento mobile = new Insegnamento();
			mobile.setCodice("F1081");
			mobile.setDenominazione("Applicazioni per Dispositivi Mobili");
			mobile.setLingua(Lingua.ITA);
			mobile.setCfu(6);
			mobile.setTipologiaCredito(TipologiaCredito.b);
			mobile.setPeriodoInsegnamento(2);
			mobile.setCorsoDiLaurea(corsoDiLaureaInformatica);
			mobile.setDocente(amleto);
			insegnamentoRepository.save(mobile);

			Appello appelloGiugno = new Appello();
			appelloGiugno.setDescrizione("1 appello giugno");
			appelloGiugno.setDataAppello(new Date(System.currentTimeMillis() + (20 * 86400000)));
			appelloGiugno.setInsegnamento(mobile);
			appelloGiugno.setTipologiaEsame(TipologiaEsame.ORALE);
			appelloRepository.save(appelloGiugno);

			Appello appelloGiugno2 = new Appello();
			appelloGiugno2.setDescrizione("2 appello giugno");
			appelloGiugno2.setDataAppello(new Date(System.currentTimeMillis() + (35 * 86400000)));
			appelloGiugno2.setInsegnamento(mobile);
			appelloGiugno2.setTipologiaEsame(TipologiaEsame.ORALE);
			appelloRepository.save(appelloGiugno2);
			
			Insegnamento java = new Insegnamento();
			java.setCodice("F7W027");
			java.setDenominazione("Programmazione avanzata Java");
			java.setLingua(Lingua.ITA);
			java.setCfu(5);
			java.setTipologiaCredito(TipologiaCredito.b);
			java.setPeriodoInsegnamento(1);
			java.setCorsoDiLaurea(corsoDiLaureaMaster);
			java.setDocente(amleto);
			insegnamentoRepository.save(java);

			Insegnamento jee = new Insegnamento();
			jee.setCodice("F7W021");
			jee.setDenominazione("Piattaforma JEE");
			jee.setLingua(Lingua.ITA);
			jee.setCfu(6);
			jee.setTipologiaCredito(TipologiaCredito.b);
			jee.setPeriodoInsegnamento(2);
			jee.setCorsoDiLaurea(corsoDiLaureaMaster);
			jee.setDocente(amleto);
			insegnamentoRepository.save(jee);
			
			Insegnamento laboratoriosistemioperativi = new Insegnamento();
			laboratoriosistemioperativi.setCodice("F1I021");
			laboratoriosistemioperativi.setDenominazione("Laboratorio di Sistemi Operativi");
			laboratoriosistemioperativi.setLingua(Lingua.ITA);
			laboratoriosistemioperativi.setCfu(6);
			laboratoriosistemioperativi.setTipologiaCredito(TipologiaCredito.b);
			laboratoriosistemioperativi.setPeriodoInsegnamento(1);
			laboratoriosistemioperativi.setCorsoDiLaurea(corsoDiLaureaInformatica);
			laboratoriosistemioperativi.setDocente(marco);
			insegnamentoRepository.save(laboratoriosistemioperativi);*/

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(WhistleApplication.class, args);
	}

}
