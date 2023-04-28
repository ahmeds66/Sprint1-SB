package com.ares.rocket_spboot;

import com.ares.rocket_spboot.entities.Rocket;
import com.ares.rocket_spboot.service.RocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class RocketSpBootApplication implements CommandLineRunner {
    @Autowired
    private RocketService rocketService;

    public static void main(String[] args) {
        SpringApplication.run(RocketSpBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        rocketService.saveRocket(new Rocket("Falcon Heavy", 63800L, 26700L, new Date(), 2018L, 0L));
        rocketService.saveRocket(new Rocket("Falcon 1", 670L, 450L, new Date(), 2006L, 1L));
        rocketService.saveRocket(new Rocket("Falcon 1e", 1005L, 830L, new Date(), 2009L, 0L));
    }
}
