package asw.edipogram.enigmiseguiti.domain;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.*; 

@Service 
public class EnigmiSeguitiService {
	
	@Autowired
	private ConnessioneRepository connessioneRepository;
	
	@Autowired
	private EnigmaRepository enigmaRepository;
	
	@Autowired
	private EnigmaSeguitoRepository enigmaSeguitoRepository;

//	@Autowired 
//	private ConnessioniService connessioniService;
//
//	@Autowired 
//	private EnigmiService enigmiService;
//
//	/* Trova gli enigmi (in formato breve) degli utenti seguiti da utente. */ 
//	public Collection<Enigma> getEnigmiSeguiti(String utente) {
//		Collection<Enigma> enigmiSeguiti = new TreeSet<>(); 
//		Collection<Connessione> connessioni = connessioniService.getConnessioniByUtente(utente); 
//		Collection<String> tipiSeguiti = 
//			connessioni
//				.stream()
//				.map(c -> c.getTipo())
//				.collect(Collectors.toSet()); 
//		if (tipiSeguiti.size()>0) {
//			Collection<Enigma> enigmi = enigmiService.getEnigmiByTipi(tipiSeguiti);
//			enigmiSeguiti.addAll(enigmi); 
//		}
//		return enigmiSeguiti; 
//	}
	
	
//	/* Variante meno complessa */
//	public void createConnessione(String utente, String tipo) {
//		Connessione connessione = new Connessione(utente, tipo);
//		connessioneRepository.save(connessione);
//	}
//
//	public void createEnigma(String autore, String tipo, String tipoSpecifico, String titolo, String[] testo,
//			String[] soluzione) {
//		Enigma enigma = new Enigma(autore, tipo, tipoSpecifico, titolo, testo);
//		enigmaRepository.save(enigma);
//	}
//
//	public Collection<Enigma> getEnigmiSeguiti(String utente) {
//		Collection<Enigma> enigmi = new ArrayList<>();
//		Collection<Connessione> connessioni = connessioneRepository.getConnessioniByUtente(utente);
//		for (Connessione connessione : connessioni) {
//			String tipo = connessione.getTipo();
//			enigmi.addAll(enigmaRepository.getEnigmiByTipo(tipo));
//		}
//		return enigmi;
//	}
	
	/* Variante più complessa */
	public void createEnigma(String autore, String tipo, String tipoSpecifico, String titolo, String[] testo,
			String[] soluzione) {
		Enigma enigma = new Enigma(autore, tipo, tipoSpecifico, titolo, testo);
		enigmaRepository.save(enigma);
		Collection<Connessione> connessioni = connessioneRepository.getConnessioniByTipo(tipo);
		for (Connessione connessione : connessioni) {
			EnigmaSeguito enigmaSeguito = new EnigmaSeguito(connessione.getUtente(), enigma.getId(), autore, tipo, tipoSpecifico, titolo, testo);
			enigmaSeguitoRepository.save(enigmaSeguito);
		}
		
	}

	public void createConnessione(String utente, String tipo) {
		Connessione connessione = new Connessione(utente, tipo);
		connessioneRepository.save(connessione);
		Collection<Enigma> enigmi = enigmaRepository.getEnigmiByTipo(tipo);
		for (Enigma enigma : enigmi) {
			EnigmaSeguito enigmaSeguito = new EnigmaSeguito(utente, enigma.getId(), enigma.getAutore(), tipo, enigma.getTipoSpecifico(), enigma.getTitolo(), enigma.getTesto());
			enigmaSeguitoRepository.save(enigmaSeguito);
		}
		
	}

	public Collection<EnigmaSeguito> getEnigmiSeguiti(String utente) {
		return enigmaSeguitoRepository.findAllByUtente(utente);
	}

}
