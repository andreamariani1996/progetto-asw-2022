package asw.edipogram.enigmiseguiti.connessioniEventListener;

import java.util.logging.Logger;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import asw.edipogram.common.api.event.DomainEvent;
import asw.edipogram.connessioneservice.api.event.ConnessioneServiceEventChannel;

@Component
public class ConnessioniEventListener {

	private final Logger logger = Logger.getLogger(ConnessioniEventListener.class.toString());

	@Autowired
	private ConnessioniDomainEventConsumer connessioniEventConsunmer;

	@KafkaListener(topics = ConnessioneServiceEventChannel.channel)
	public void listen(ConsumerRecord<String, DomainEvent> record) throws Exception {
		logger.info("EVENT LISTENER: " + record.toString());
		DomainEvent event = record.value();
		connessioniEventConsunmer.onEvent(event);
	}
}
