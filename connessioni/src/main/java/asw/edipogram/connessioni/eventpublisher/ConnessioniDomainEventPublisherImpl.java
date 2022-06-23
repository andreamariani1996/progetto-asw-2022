package asw.edipogram.connessioni.eventpublisher;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import asw.edipogram.common.api.event.DomainEvent;
import asw.edipogram.connessioneservice.api.event.ConnessioneServiceEventChannel;
import asw.edipogram.connessioni.domain.ConnessioniDomainEventPublisher;

@Component
public class ConnessioniDomainEventPublisherImpl implements ConnessioniDomainEventPublisher {
	
	@Autowired
	private KafkaTemplate<String, DomainEvent> template;
	
	private final Logger logger = Logger.getLogger(ConnessioniDomainEventPublisherImpl.class.toString());
	
	private String channel = ConnessioneServiceEventChannel.channel;

	@Override
	public void publish(DomainEvent event) {
		logger.info("PUBLISHING MESSAGE: " + event + " ON CHANNEL: " + channel);
		template.send(channel, event);	

	}

}
