package com.ericsson.kafkaconsumer.configuration;

import com.ericsson.kafkaconsumer.dto.CallFault;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.stereotype.Component;


@Component
public class CallFaultDeserializer implements Deserializer<CallFault> {
    private final ObjectMapper objectMapper  = new ObjectMapper();


    @Override
    public CallFault deserialize(String topic, byte[] data) {
        try{
            if(data ==null){
                System.out.println("Null Consumer Data recieved");
                return null;
            }
            System.out.println("DeSerializing ......");
            return objectMapper.readValue(data, CallFault.class);
        } catch (Exception e) {
            throw new SerializationException("Error Serializing the object",e);
        }

    }

}