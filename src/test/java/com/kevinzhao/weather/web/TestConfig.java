package com.kevinzhao.weather.web;


import com.kevinzhao.weather.service.CityService;
import org.mockito.Mockito;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@ComponentScan({"com.kevinzhao.weather.web", "com.kevinzhao.base.web"})
@EnableWebMvc
class TestConfig   {

    @Bean
    public CityService cityService() {
        return Mockito.mock(CityService.class);
    }



}