package com.smile.mp3webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;

@SpringBootApplication
@ComponentScan("com.smile")
@EnableJpaRepositories(basePackages= "com.smile.mp3dao.repository")
@EnableJpaAuditing()
@EntityScan("com.smile.mp3dao.entity")
public class Mp3WebserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Mp3WebserviceApplication.class, args);
    }
    @Bean
    public HttpFirewall defaultHttpFirewall() {
        return new DefaultHttpFirewall();
    }
}
