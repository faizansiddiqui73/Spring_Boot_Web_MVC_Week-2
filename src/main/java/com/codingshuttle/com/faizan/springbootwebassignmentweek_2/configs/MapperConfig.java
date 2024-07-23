package com.codingshuttle.com.faizan.springbootwebassignmentweek_2.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    //    ModelMapper is a Java library that helps in mapping objects from one model to another,
    //    reducing the need for manual mapping code
}
