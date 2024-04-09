import React, { useState, useEffect } from 'react';
import axios from 'axios';
import CesiumMap from "./component/CesiumMap";

const App = () => {
  const [earthquakes, setEarthquakes] = useState([]);
  useEffect(() => {
    const fetchEarthquakes = async () => {
      try {
        const response = await axios.get('http://127.0.0.1:8080/earthquakes');
        if(response.data.length>1){
          const mylist=response.data;
          const mylist_len= mylist.length;
          const newEarthquakes = mylist.slice(mylist_len-10,mylist_len);
          setEarthquakes(newEarthquakes);
        }
        else {
          setEarthquakes(response.data);
        } 
        console.log("response", response);
        console.log("responsedata", response.data);
        console.log("responsedatalat", response.data[0].lat);
      } catch (error) {
        console.error('Error fetching earthquakes:', error);
      }
    };
    const interval = setInterval(fetchEarthquakes, 3000); 
    return () => clearInterval(interval);
  }, []);

  return (
    <div>
      <CesiumMap earthquakes={earthquakes} />
    </div>
  );
};

export default App;
