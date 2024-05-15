package com.springbackend.app.entity;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "TBL_EARTHQUAKE")
@Data
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

}
