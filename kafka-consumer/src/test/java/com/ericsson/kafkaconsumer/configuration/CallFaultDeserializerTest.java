package com.ericsson.kafkaconsumer.configuration;

import com.ericsson.kafkaconsumer.CallFault;
import com.ericsson.kafkaconsumer.CallFaultDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CallFaultDeserializerTest {

    private CallFaultDeserializer deserializer;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        deserializer = new CallFaultDeserializer();
        objectMapper = new ObjectMapper();
    }

//    @Test
//    public void testDeserializeValidData() throws Exception {
//        // Arrange
//        CallFault callFault = new CallFault(); // Assuming CallFault has a no-args constructor and setters
//        callFault.setSomeProperty("someValue"); // Set necessary properties
//        byte[] data = objectMapper.writeValueAsBytes(callFault);
//
//        // Act
//        CallFault result = deserializer.deserialize("some-topic", data);
//
//        // Assert
//        assertNotNull(result);
//        assertEquals("someValue", result.getSomeProperty());
//    }

    @Test
    public void testDeserializeNullData() {
        // Act
        CallFault result = deserializer.deserialize("some-topic", null);

        // Assert
        assertNull(result);
    }

    @Test
    public void testDeserializeInvalidData() {
        // Arrange
        byte[] data = "invalid data".getBytes();

        // Act & Assert
        Exception exception = assertThrows(SerializationException.class, () -> {
            deserializer.deserialize("some-topic", data);
        });

        String expectedMessage = "Error Serializing the object";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
