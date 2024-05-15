package com.springbackend.app.cleandata;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.springbackend.app.service.EarthquakeService;


@Component
@RequiredArgsConstructor
public class DataCleanupTask {

	private final EarthquakeService earthService;

    @Scheduled(fixedRate = 10000)
    public void cleanupData() {
        earthService.cleanEarthquakeData();
    }
}
