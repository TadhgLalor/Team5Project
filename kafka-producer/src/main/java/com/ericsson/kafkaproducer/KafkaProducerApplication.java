package com.ericsson.kafkaproducer;

import com.ericsson.kafkaproducer.controller.MessageController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerApplication implements ApplicationRunner {

    @Autowired
    private MessageController messageController;

    private static final int NODE_COUNT = 5; // Number of nodes

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
        System.out.println("KafkaProducerApplication running...");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Sending random messages on startup...");

        // Create and start threads for each node
        for (int i = 1; i <= NODE_COUNT; i++) {
            Thread nodeThread = new Thread(new NodeTask(i));
            nodeThread.start();
        }
    }

    // Inner class to represent a node task
    private class NodeTask implements Runnable {
        private int nodeId;

        public NodeTask(int nodeId) {
            this.nodeId = nodeId;
        }

        @Override
        public void run() {
            boolean keepRunning = true; // Control variable for the loop

            while (keepRunning) {
                try {
                    System.out.println("NodeId " + nodeId + " sending message...");
                    messageController.sendRandomMessage(nodeId);
                    Thread.sleep(5000); // Sleep for 5 seconds before sending the next message
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    keepRunning = false;
                } catch (Exception e) {
                  //  e.printStackTrace();
                    keepRunning = false;
                }
            }
        }
    }
}
