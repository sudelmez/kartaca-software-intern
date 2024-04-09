package com.springbackend.app.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springbackend.app.exception.RecordNotFoundException;
import com.springbackend.app.exception.ServerException;
import com.springbackend.app.model.Earthquake;
import com.springbackend.app.service.EarthquakeService;

@RestController
public class EarthquakeController {

	@Autowired
	EarthquakeService earthService;

	@GetMapping("/")
	public String getGreeting() {
		return "Hello spring boot application!!";
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
