import React, { useState, useEffect } from 'react';
import axios from 'axios';

const EarthquakeList = () => {
    const [earthquakes, setEarthquakes] = useState([]);
    useEffect(() => {
        const fetchEarthquakes = async () => {
            try {
                const response = await axios.get('http://localhost:8080');
                setEarthquakes(response.data);
                console.log("response", response);
            } catch (error) {
                console.error('Error fetching earthquakes:', error);
            }
        };

        fetchEarthquakes();
    }, []);

    return (
        <div>
            <h1>Earthquakes</h1>
            <ul>
                {earthquakes.map(earthquake => (
                    <li key={earthquake.ID}>
                        <p>ID: {earthquake.ID}</p>
                        <p>Intensity: {earthquake.Intensity}</p>
                        <p>Latitude: {earthquake.Lat}</p>
                        <p>Longitude: {earthquake.Lon}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default EarthquakeList;
