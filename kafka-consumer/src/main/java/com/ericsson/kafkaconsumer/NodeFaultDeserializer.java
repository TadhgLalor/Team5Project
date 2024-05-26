package com.ericsson.kafkaconsumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.stereotype.Component;


import java.util.Map;


@Component
public class NodeFaultDeserializer implements Deserializer<NodeFault> {
    private final ObjectMapper objectMapper  = new ObjectMapper();


    @Override
    public NodeFault deserialize(String topic, byte[] data) {
        try{
            if(data ==null){
                System.out.println("Null Consumer Data recieved");
                return null;
            }
            System.out.println("DeSerializing ......");
            return objectMapper.readValue(data, NodeFault.class);
        } catch (Exception e) {
            throw new SerializationException("Error Serializing the object",e);
        }

    }

}