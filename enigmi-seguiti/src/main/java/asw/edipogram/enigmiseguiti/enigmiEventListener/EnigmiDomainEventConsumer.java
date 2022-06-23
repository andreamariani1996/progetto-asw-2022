package asw.edipogram.enigmiseguiti.enigmiEventListener;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.edipogram.common.api.event.DomainEvent;
import asw.edipogram.enigmaservice.api.event.EnigmaCreatedEvent;
import asw.edipogram.enigmiseguiti.domain.EnigmiSeguitiService;

@Service
public class EnigmiDomainEventConsumer {

	private final Logger logger = Logger.getLogger(EnigmiDomainEventConsumer.class.toString());

	@Autowired
	private EnigmiSeguitiService enigmaService;

	public void onEvent(DomainEvent event) {
		logger.info("PROCESSING EVENT: " + event);
		if (event.getClass().equals(EnigmaCreatedEvent.class)) {
			EnigmaCreatedEvent ece = (EnigmaCreatedEvent) event;
			createEnigma(ece);
		} else {
			logger.info("UNKNOWN EVENT: " + event);
		}
	}

	private void createEnigma(EnigmaCreatedEvent event) {
		enigmaService.createEnigma(event.getAutore(), event.getTipo(), event.getTipoSpecifico(), event.getTitolo(), event.getTesto(), event.getSoluzione() );
		
	}

}
