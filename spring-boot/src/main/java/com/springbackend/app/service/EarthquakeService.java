package com.springbackend.app.service;

import com.springbackend.app.repository.EarthquakeRepository;
import com.springbackend.app.entity.Earthquake;
import com.springbackend.app.exception.ServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EarthquakeService {

	@Autowired
	private EarthquakeRepository earthquakeRepository;

	public List<Earthquake> getAll() {
		return earthquakeRepository.findAll();
	}

	public Earthquake save(Earthquake newEarthquake) {
        try {
            return earthquakeRepository.save(newEarthquake);
        } catch (Exception e) {
            log.error("Error while saving earthquake data", e);
            throw new ServerException();
        }
    }
    public void cleanEarthquakeData() {
        try {
            List<Earthquake> earthquakes = earthquakeRepository.findAll();
            if (!earthquakes.isEmpty()) {
                Earthquake latestEarthquake = earthquakes.get(0);
                earthquakeRepository.delete(latestEarthquake);
            }
        } catch (Exception e) {
            log.error("Error while cleaning earthquake data", e);
            throw new ServerException();
        }
    }
}
