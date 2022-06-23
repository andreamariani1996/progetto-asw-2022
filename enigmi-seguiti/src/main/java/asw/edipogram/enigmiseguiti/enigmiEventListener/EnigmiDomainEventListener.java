package asw.edipogram.enigmiseguiti.enigmiEventListener;

import java.util.logging.Logger;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import asw.edipogram.common.api.event.DomainEvent;
import asw.edipogram.enigmaservice.api.event.EnigmaServiceEventChannel;

@Component
public class EnigmiDomainEventListener {
	private final Logger logger = Logger.getLogger(EnigmiDomainEventListener.class.toString());
	
	@Autowired
	private EnigmiDomainEventConsumer enigmiDomainEventConsumer;

	@KafkaListener(topics = EnigmaServiceEventChannel.channel)
	public void listen(ConsumerRecord<String, DomainEvent> record) throws Exception {
		logger.info("EVENT LISTENER: " + record.toString());
		DomainEvent event = record.value();
		enigmiDomainEventConsumer.onEvent(event);
	}
}
