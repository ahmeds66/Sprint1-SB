package com.ares.rocket_spboot.repos;

import com.ares.rocket_spboot.entities.Rocket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RocketRepository extends JpaRepository<Rocket,Long> {
}
