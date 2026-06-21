package com.TalentHub.demo.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class ModelMapperConfig {
    @Bean   //Spring creates one object and shares it everywhere (Singleton scope by default).
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
