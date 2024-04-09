package com.springbackend.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbackend.app.dao.EarthquakeDao;
import com.springbackend.app.model.Earthquake;
import com.springbackend.app.exception.ServerException;

@Service
public class EarthquakeService {

	@Autowired
	EarthquakeDao earthDao;

	public List<Earthquake> getAll() {
		return earthDao.findAll();
	}

	public Earthquake save(Earthquake newEarthquake) {
        try {
            return earthDao.save(newEarthquake);
        } catch (Exception e) {
            System.err.println("Error while saving earthquake data: " + e.getMessage());
            throw new ServerException();
        }
    }
    public void cleanEarthquakeData() {
        try {
            List<Earthquake> earthquakes = earthDao.findAll();
            if (!earthquakes.isEmpty()) {
                Earthquake latestEarthquake = earthquakes.get(0);
                earthDao.delete(latestEarthquake);
            }
        } catch (Exception e) {
            System.err.println("Error while cleaning earthquake data: " + e.getMessage());
            throw new ServerException();
        }
    }
}
