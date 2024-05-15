package com.springbackend.app.controller;

import com.springbackend.app.exception.ServerException;
import com.springbackend.app.entity.Earthquake;
import com.springbackend.app.service.EarthquakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class EarthquakeController {

	private final EarthquakeService earthService;

	@Autowired
	public EarthquakeController(EarthquakeService earthService) {
		this.earthService = earthService;
	}

	@GetMapping("earthquakes")
	public ResponseEntity<List<Earthquake>> getAll() {
		return new ResponseEntity<>(earthService.getAll(), HttpStatus.OK);
	}

	@PostMapping(path = "earthquakes",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Earthquake> create(@RequestBody Earthquake newEarthquake) {
		Earthquake earthquake = earthService.save(newEarthquake);
		if (earthquake == null) {
			throw new ServerException();
		}
		else {
			return new ResponseEntity<>(earthquake, HttpStatus.CREATED);
		}
	}
}
