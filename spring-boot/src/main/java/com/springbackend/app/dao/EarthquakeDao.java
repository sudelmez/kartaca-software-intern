package com.springbackend.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbackend.app.model.Earthquake;

@Repository
public interface EarthquakeDao extends JpaRepository<Earthquake, Long> {

}
