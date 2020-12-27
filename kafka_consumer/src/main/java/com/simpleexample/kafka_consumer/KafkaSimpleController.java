package com.simpleexample.kafka_consumer;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class KafkaSimpleController {

    private Gson jsonConverter;

    @Autowired
    public KafkaSimpleController(Gson jsonConverter){
        this.jsonConverter = jsonConverter;
    }

    @KafkaListener(topics = {"Topic1"})
    public void getFromKafka(String simpleModel){

        SimpleModel simpleModel1 = jsonConverter.fromJson(simpleModel, SimpleModel.class);

        System.out.println("Listener for Topic1: " + simpleModel1.toString());
    }

    @KafkaListener(topics = {"Topic2", "Topic1"}) // doesn't listen Topic1
    public void getFromKafka2(String moreSimpleModel){

        MoreSimpleModel simpleModel1 = jsonConverter.fromJson(moreSimpleModel, MoreSimpleModel.class);

        System.out.println("Listener for Topic2: " + simpleModel1.toString());
    }


}
