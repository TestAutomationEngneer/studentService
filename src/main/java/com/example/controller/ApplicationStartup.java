package com.example.controller;

import io.micronaut.context.ApplicationContext;
import io.micronaut.context.DefaultApplicationContext;
import io.micronaut.context.annotation.Property;
import io.micronaut.context.annotation.Value;
import io.micronaut.context.env.Environment;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.context.event.StartupEvent;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;


import java.util.Set;
import java.util.UUID;

@Singleton
@Slf4j
@Property(name = "training.zagadka",
        value = "zagadka letnia") // ustawiam nową wartośc properties
public class ApplicationStartup implements ApplicationEventListener<StartupEvent> {

    @Value("${training.name}") // pobieram wartość a application.yaml i wstrzykuje w pole
    private String name;

    @Value("${training.age}") //
    private int age;

    @Value("${training.port}") //
    private int port;

    @Value("${training.uuid}") //
    private UUID uuid;

    @Value("${training.zagadka}") //
    private String getZagadka;





    @Override
    public void onApplicationEvent(StartupEvent event) {
        log.info(">>>>>>>>>>>  APPLICATION START onApplicationEvent ");

//        ApplicationContext applicationContext = new DefaultApplicationContext();
//        Environment environment = applicationContext.getEnvironment();

        log.info(">>>>>>>>>>>  Property name " + name
                + " age " + age
                + " port " + port
                + " uuid " + uuid

        );


        log.info(">>>>>>>>>>> Property name zagadka przed ustawienie = " + getZagadka);
        log.info(">>>>>>>>>>> Property name zagadka po  ustawieniu  = " + getZagadka);
    }
}
