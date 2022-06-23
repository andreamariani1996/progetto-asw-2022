package asw.edipogram.enigmiseguiti.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.*; 

@Entity 
@Data @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EnigmaSeguito implements Comparable<EnigmaSeguito> {

	@Id 
	@GeneratedValue
	@EqualsAndHashCode.Include
	private Long id; 
	private String utente; 
	private Long idEnigma; 
	private String autoreEnigma; 
	private String tipoEnigma; 
	private String tipoSpecificoEnigma;
	private String titoloEnigma;
	private String[] testoEnigma;
	
	public EnigmaSeguito(String utente, Long idEnigma, String autoreEnigma, String tipoEnigma,
			String tipoSpecificoEnigma, String titoloEnigma, String[] testoEnigma) {
		this();
		this.utente = utente;
		this.idEnigma = idEnigma;
		this.autoreEnigma = autoreEnigma;
		this.tipoEnigma = tipoEnigma;
		this.tipoSpecificoEnigma = tipoSpecificoEnigma;
		this.titoloEnigma = titoloEnigma;
		this.testoEnigma = testoEnigma;
	}

	@Override
	public int compareTo(EnigmaSeguito other) {
		return this.id.compareTo(other.id); 
	}

}
