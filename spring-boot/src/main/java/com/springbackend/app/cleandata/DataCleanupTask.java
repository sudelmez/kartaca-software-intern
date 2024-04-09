package com.springbackend.app.cleandata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.springbackend.app.dao.EarthquakeDao;
import com.springbackend.app.model.Earthquake;
import java.util.List;
import com.springbackend.app.service.EarthquakeService;


@Component
public class DataCleanupTask {

    @Autowired
	EarthquakeService earthService;

    @Scheduled(fixedRate = 10000)
    public void cleanupData() {
    earthService.cleanEarthquakeData();
    }
}
