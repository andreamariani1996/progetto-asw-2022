package asw.edipogram.enigmiseguiti.domain;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface EnigmaSeguitoRepository extends CrudRepository<EnigmaSeguito, Long> {

	Collection<EnigmaSeguito> findAllByUtente(String utente);
	
}
