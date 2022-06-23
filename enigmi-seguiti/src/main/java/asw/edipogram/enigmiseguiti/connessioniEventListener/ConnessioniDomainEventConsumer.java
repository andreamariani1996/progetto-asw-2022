package asw.edipogram.enigmiseguiti.connessioniEventListener;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.edipogram.common.api.event.DomainEvent;
import asw.edipogram.connessioneservice.api.event.ConnessioneCreatedEvent;
import asw.edipogram.enigmiseguiti.domain.EnigmiSeguitiService;

@Service
public class ConnessioniDomainEventConsumer {

	private final Logger logger = Logger.getLogger(ConnessioniDomainEventConsumer.class.toString());

	@Autowired
	private EnigmiSeguitiService enigmiSeguiteService;

	public void onEvent(DomainEvent event) {
		logger.info("PROCESSING EVENT: " + event);
		if (event.getClass().equals(ConnessioneCreatedEvent.class)) {
			ConnessioneCreatedEvent cce = (ConnessioneCreatedEvent) event;
			createConnessione(cce);
		} else {
			logger.info("UNKNOWN EVENT: " + event);
		}
	}

	private void createConnessione(ConnessioneCreatedEvent event) {
		enigmiSeguiteService.createConnessione(event.getUtente(), event.getTipo());
	}

}
