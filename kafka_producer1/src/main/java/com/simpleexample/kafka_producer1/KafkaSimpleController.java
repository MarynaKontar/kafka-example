package com.simpleexample.kafka_producer1;

import com.google.gson.Gson;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/api/kafka")
public class KafkaSimpleController {

    private KafkaTemplate<String, String> kafkaTemplate;
    private Gson jsonConverter;
    private static final String loremIpsum = "Lorem ipsum .";

    @Autowired
    public KafkaSimpleController(KafkaTemplate<String, String> kafkaTemplate, Gson jsonConverter){
        this.kafkaTemplate = kafkaTemplate;
        this.jsonConverter = jsonConverter;
    }


    private static final String[] hashTags = {"latin", "italy", "roman", "caesar", "cicero"};

    private Random randomNumber = new Random();
    private static final String TOPIC1 = "Topic1";
    private static final String TOPIC2 = "Topic2";

    private String randomMessage;

    @GetMapping("/sendMessages")
    public void sendMessages() {

        while (true) {
            // Every second send a message
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("ERROR: ");
                e.printStackTrace();
            }

            randomMessage = loremIpsum + " #" + hashTags[randomNumber.nextInt(hashTags.length)];
            kafkaTemplate.send(new ProducerRecord<String, String>(TOPIC1, "", randomMessage));

        }
    }

    @PostMapping
    public void post(@RequestBody SimpleModel simpleModel){
        kafkaTemplate.send(TOPIC1, jsonConverter.toJson(simpleModel));
    }

    @PostMapping("/v2")
    public void post(@RequestBody MoreSimpleModel moreSimpleModel){
        kafkaTemplate.send(TOPIC2, jsonConverter.toJson(moreSimpleModel));
    }

}
