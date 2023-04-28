package com.ares.rocket_spboot.service;

import com.ares.rocket_spboot.entities.Rocket;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RocketService {

    Rocket saveRocket(Rocket rocket);
    Rocket updateRocket(Rocket rocket);
    void deleteRocket(Rocket rocket);
    void deleteRocketById(Long id);
    Rocket getRocket(Long id);
    List<Rocket> getAllRockets();
    Page<Rocket> getAllRocketsPerPage(int page, int size);
}
