package com.AFORO255.MS.TEST.Transaction.kafka.consumer.listener;

import com.AFORO255.MS.TEST.Transaction.service.OperationEvents;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/*Va a estar escuchando*/

@Component
public class OperationEventsConsumer {
    //inyectamos el servicio

    @Autowired
    private OperationEvents operationEvents;

    private Logger log = LoggerFactory.getLogger(OperationEventsConsumer.class);

    //creamos metodo que va a estar escuchando
    @KafkaListener(topics = {"operation-events"})
    public void onMessage(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, JsonProcessingException {
        log.info("ConsumerRecord Invoice : {}", consumerRecord);
        operationEvents.processOperationEvent(consumerRecord);
    }
}
