package asw.edipogram.enigmiseguiti.domain;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface EnigmaRepository extends CrudRepository<Enigma, Long> {

	Collection<Enigma> getEnigmiByTipo(String tipo);

}
