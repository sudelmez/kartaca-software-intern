package com.springbackend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbackend.app.entity.Earthquake;

@Repository
public interface EarthquakeRepository extends JpaRepository<Earthquake, Long> {

}
