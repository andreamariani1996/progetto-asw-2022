package asw.edipogram.enigmi.eventpublisher;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import asw.edipogram.common.api.event.DomainEvent;
import asw.edipogram.enigmi.domain.EnigmiDomainEventPublisher;
import asw.edipogram.enigmaservice.api.event.EnigmaServiceEventChannel;

@Component
public class EnigmiDomainEventPublisherImpl implements EnigmiDomainEventPublisher {
	
	@Autowired
	private KafkaTemplate<String, DomainEvent> template;
	
	private final Logger logger = Logger.getLogger(EnigmiDomainEventPublisherImpl.class.toString());
	
	private String channel = EnigmaServiceEventChannel.channel;

	@Override
	public void publish(DomainEvent event) {
		logger.info("PUBLISHING MESSAGE: " + event + " ON CHANNEL: " + channel);
		template.send(channel, event);	

	}

}
