package com.mchaves.api_news.config;

import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

import java.util.TimeZone;

@Configuration
public class SpringTimezoneConfig {

    @PostConstruct
    public void timezoneConfig(){
        TimeZone.setDefault(TimeZone.getTimeZone("America/Recife"));
    }

}
