package com.AFORO255.MS.TEST.Transaction.service;

import com.AFORO255.MS.TEST.Transaction.model.entity.Operation;
import com.AFORO255.MS.TEST.Transaction.model.repository.IOperationRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationEvents {
    @Autowired
    private IOperationRepository iOperationRepository;

    @Autowired
    ObjectMapper objectMapper;

    private Logger log = LoggerFactory.getLogger(OperationEvents.class);

    public void processOperationEvent(ConsumerRecord<Integer, String> consumerRecord) throws JsonProcessingException {
        Operation  transactionEvent = objectMapper.readValue(consumerRecord.value(), Operation.class);
        log.info("operationEvent: {}" +consumerRecord.value());
        iOperationRepository.save(transactionEvent);
    }
}
