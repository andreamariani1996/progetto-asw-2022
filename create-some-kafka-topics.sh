#!/bin/bash

echo Creating some Kafka topics...

KAFKA_DOCKER=$(docker ps | grep kafka | grep -v zookeeper | awk '{print $1}')

docker exec -it $KAFKA_DOCKER kafka-topics.sh --bootstrap-server localhost:9092 --create --topic enigma-service-event-channel --replication-factor 1 --partitions 2

docker exec -it $KAFKA_DOCKER kafka-topics.sh --bootstrap-server localhost:9092 --create --topic connessione-service-event-channel --replication-factor 1 --partitions 2
