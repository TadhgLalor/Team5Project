package com.ericsson.kafkaconsumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.stereotype.Component;
import java.util.logging.Logger;


@Component
public class CallFaultDeserializer implements Deserializer<CallFault> {
    private final ObjectMapper objectMapper  = new ObjectMapper();
    private static final Logger logger = Logger.getLogger(CallFaultDeserializer.class.getName());

    @Override
    public CallFault deserialize(String topic, byte[] data) {
        try{
            if(data ==null){
                logger.info("Null Consumer Data recieved");
                return null;
            }
            logger.info("DeSerializing ......");
            return objectMapper.readValue(data, CallFault.class);
        } catch (Exception e) {
            throw new SerializationException("Error Serializing the object",e);
        }

    }

}