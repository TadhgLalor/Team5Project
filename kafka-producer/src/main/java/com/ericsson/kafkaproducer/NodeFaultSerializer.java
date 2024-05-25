package com.ericsson.kafkaproducer;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.stereotype.Component;


import java.util.Map;


@Component
public class NodeFaultSerializer implements Serializer<NodeFault> {
    private final ObjectMapper objectMapper  = new ObjectMapper();


    @Override
    public byte[] serialize(String topic,NodeFault nodeFault)  {
        try{
            if(nodeFault ==null){
                System.out.println("Null Data recieved");
                return null;
            }
            System.out.println("Serializing ......");
            return objectMapper.writeValueAsBytes(nodeFault);
        } catch (Exception e) {
            throw new SerializationException("Error Serializing the object",e);
        }

    }

}
