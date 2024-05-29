package com.ericsson.kafkaproducer.configuration;


import com.ericsson.kafkaproducer.KafkaProducerApplication;
import com.ericsson.kafkaproducer.dto.CallFault;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;


@Component
public class CallFaultSerializer implements Serializer<CallFault> {

    private static final Logger logger = Logger.getLogger(CallFaultSerializer.class.getName());
    private final ObjectMapper objectMapper  = new ObjectMapper();


    @Override
    public byte[] serialize(String topic,CallFault CallFault)  {
        try{
            if(CallFault ==null){
                logger.info("Null Data recieved");
                return null;
            }
            logger.info("Serializing ......");
            return objectMapper.writeValueAsBytes(CallFault);
        } catch (Exception e) {
            throw new SerializationException("Error Serializing the object",e);
        }

    }

}
