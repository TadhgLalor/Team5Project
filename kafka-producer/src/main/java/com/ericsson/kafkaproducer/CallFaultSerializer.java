package com.ericsson.kafkaproducer;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.stereotype.Component;


import java.util.Map;


@Component
public class CallFaultSerializer implements Serializer<CallFault> {
    private final ObjectMapper objectMapper  = new ObjectMapper();


    @Override
    public byte[] serialize(String topic,CallFault CallFault)  {
        try{
            if(CallFault ==null){
                System.out.println("Null Data recieved");
                return null;
            }
            System.out.println("Serializing ......");
            return objectMapper.writeValueAsBytes(CallFault);
        } catch (Exception e) {
            throw new SerializationException("Error Serializing the object",e);
        }

    }

}
