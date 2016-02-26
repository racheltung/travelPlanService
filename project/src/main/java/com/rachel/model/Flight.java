package com.rachel.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="Flight")
public class Flight implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6924392432289495834L;
	
	
	@Id
	@Column (name="flight_no", nullable = false, length = 20)
	private String flightNo;
	
	@Column (name="dep_airport", nullable = false, length = 20)
	private String depAirport;
	
	@Column (name="dest_airport", nullable = false, length = 20)
	private String destAirport;
	
	@Column (name="dep_time", nullable = false)
	private Date depTime;
	
	@Column (name="arrv_time", nullable = false)
	private Date arrvTime;
	
	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getDepAirport() {
		return depAirport;
	}

	public void setDepAirport(String depAirport) {
		this.depAirport = depAirport;
	}

	public String getDestAirport() {
		return destAirport;
	}

	public void setDestAirport(String destAirport) {
		this.destAirport = destAirport;
	}

	public Date getDepTime() {
		return depTime;
	}

	public void setDepTime(Date depTime) {
		this.depTime = depTime;
	}

	public Date getArrvTime() {
		return arrvTime;
	}

	public void setArrvTime(Date date) {
		this.arrvTime = date;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrvTime == null) ? 0 : arrvTime.hashCode());
		result = prime * result + ((depAirport == null) ? 0 : depAirport.hashCode());
		result = prime * result + ((depTime == null) ? 0 : depTime.hashCode());
		result = prime * result + ((destAirport == null) ? 0 : destAirport.hashCode());
		result = prime * result + ((flightNo == null) ? 0 : flightNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (arrvTime == null) {
			if (other.arrvTime != null)
				return false;
		} else if (!arrvTime.equals(other.arrvTime))
			return false;
		if (depAirport == null) {
			if (other.depAirport != null)
				return false;
		} else if (!depAirport.equals(other.depAirport))
			return false;
		if (depTime == null) {
			if (other.depTime != null)
				return false;
		} else if (!depTime.equals(other.depTime))
			return false;
		if (destAirport == null) {
			if (other.destAirport != null)
				return false;
		} else if (!destAirport.equals(other.destAirport))
			return false;
		if (flightNo == null) {
			if (other.flightNo != null)
				return false;
		} else if (!flightNo.equals(other.flightNo))
			return false;
		return true;
	}
	
}
