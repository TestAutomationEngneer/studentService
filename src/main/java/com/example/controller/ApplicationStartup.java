package com.example.controller;

import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.context.event.StartupEvent;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;


import java.util.Set;

@Singleton
@Slf4j
public class ApplicationStartup implements ApplicationEventListener<StartupEvent> {



    @Override
    public void onApplicationEvent(StartupEvent event) {
        log.info(">>>>>>>>>>>  APPLICATION START onApplicationEvent ");

    }
}
