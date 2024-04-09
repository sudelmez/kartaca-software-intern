import React, { useState, useEffect } from "react";
import { Cartesian3, Color } from "cesium";
import { Viewer, Entity } from "resium";

const CesiumMap = ({ earthquakes }) => {
    const [entityList, setEntityList] = useState([]);

    useEffect(() => {
        const interval = setInterval(() => {
            if (entityList.length > 0) {
                setEntityList(prevEntityList => prevEntityList.slice(1));
            }
        }, 10000); 
        return () => clearInterval(interval);
    }, [entityList]);

    useEffect(() => {
        const entities = earthquakes.map((earthquake, index) => {
            let color = Color.RED;
            if (earthquake.magnitude < 5) {
                color = Color.BLUE;
            }
            if (
                typeof earthquake.lat === "number" &&
                typeof earthquake.long === "number" &&
                typeof earthquake.magnitude === "number"
            ) {
                return (
                    <Entity
                        key={index}
                        name={`Earthquake ${index + 1}`}
                        position={Cartesian3.fromDegrees(
                            earthquake.long,
                            earthquake.lat,
                            100
                        )}
                        point={{ pixelSize: 30, color: color }}
                        description={`Magnitude: ${earthquake.magnitude}`}
                    />
                );
            } else {
                console.error(
                    `Invalid earthquake data at index ${index}:`,
                    earthquake
                );
                return null;
            }
        });

        setEntityList(entities);
    }, [earthquakes]);

    return (
        <Viewer full>
            {entityList}
        </Viewer>
    );
};

export default CesiumMap;
