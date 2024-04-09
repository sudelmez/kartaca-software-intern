package com.springbackend.app.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "TBL_EARTHQUAKE")
@XmlRootElement
public class Earthquake implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "lat")
	private double lat;

	@Column(name = "lon")
	private double lon;

	@Column(name = "magnitude")
	private double magnitude;

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public double getLat() {
		return lat;
	}
	public double getLong() {
		return lon;
	}
	public double getMagnitude() {
		return magnitude;
	}

	public void setLat(final double latnew) {
		this.lat = latnew;
	}
	public void setLon(final double lonnew) {
		this.lon = lonnew;
	}
	public void setMagnitude(final double magnew) {
		this.magnitude = magnew;
	}

	@Override
    public String toString() {
        return "EarthquakeData{" +
                "latitude=" + lat +
                ", longitude=" + lon +
                ", magnitude=" + magnitude +
                '}';
    }
}
