package asw.edipogram.enigmiseguiti.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.*; 

/* Enigma (in formato breve, senza soluzione). */ 
@Entity 
@Data @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Enigma implements Comparable<Enigma> {

	@Id 
	@GeneratedValue
	@EqualsAndHashCode.Include
	private Long id; 
	private String autore; 
	private String tipo; 
	private String tipoSpecifico; 
	private String titolo; 
	private String[] testo; 

	public Enigma(String autore, String tipo, String tipoSpecifico, String titolo, String[] testo) {
		this();
		this.autore = autore;
		this.tipo = tipo;
		this.tipoSpecifico = tipoSpecifico;
		this.titolo = titolo;
		this.testo = testo;
	}
	
	@Override
	public int compareTo(Enigma other) {
		return this.id.compareTo(other.id); 
	}
	
	
}
