package org.sid.microservicekafka.web;

import org.sid.microservicekafka.entities.Facturation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

public class FacturationRestController {

    @Autowired
    private StreamBridge streamBridge;
    @GetMapping("/publish/{topic}/{name}")
    public Facturation publish(@PathVariable String topic,@PathVariable String name){
        Facturation facturation=new Facturation(new Random().nextLong(),name,new Random().nextDouble());
        streamBridge.send(topic,facturation);
        return facturation;
    }
}
