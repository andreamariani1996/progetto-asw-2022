package asw.edipogram.enigmiseguiti.domain;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface ConnessioneRepository extends CrudRepository<Connessione, Long> {

	Collection<Connessione> getConnessioniByUtente(String utente);

	Collection<Connessione> getConnessioniByTipo(String tipo);

}
