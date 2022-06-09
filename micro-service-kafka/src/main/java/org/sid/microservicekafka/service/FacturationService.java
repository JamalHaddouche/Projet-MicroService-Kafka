package org.sid.microservicekafka.service;


import org.sid.microservicekafka.entities.Facturation;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Service
public class FacturationService{
    @Bean
    public Consumer<Facturation> facturationConsumer(){
        return (input)->{
            System.out.println("-----------------");
            System.out.println(input.toString());
            System.out.println("-------------------");
        };

    }


    @Bean
    public Supplier<Facturation> pageEventSupplier(){
        return ()->new Facturation(1L,"haddouche",new Random().nextDouble());

    }

}