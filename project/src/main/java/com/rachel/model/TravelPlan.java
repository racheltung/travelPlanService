package com.rachel.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Travel_plan")
public class TravelPlan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1689136526668703061L;

	@Id
	@Column(name = "plan_id")
	@GeneratedValue
	private Integer planId;

	@Column(name = "city", nullable = false, length = 50)
	private String city;

	@Column(name = "country", nullable = false, length = 50)
	private String country;

	@Column(name = "continent", nullable = false, length = 50)
	private String continent;

	@Column(name = "arrive_date", nullable = false)
	private Date arriveDate;

	@Column(name = "departure_date", nullable = false)
	private Date departureDate;

	@Column(name = "create_date", nullable = false)
	private Date createDate;

	@ManyToMany(fetch = FetchType.EAGER,
			 	cascade = {CascadeType.ALL})
	@JoinTable(	name = "booked_flight", 
				joinColumns = { @JoinColumn(name = "PLAN_ID") }, 
				inverseJoinColumns = {@JoinColumn(name = "FLIGHT_NO") })
	private Set<Flight> bookedFlights = new HashSet<Flight>(0);

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public Date getArriveDate() {
		return arriveDate;
	}

	public void setArriveDate(Date arriveDate) {
		this.arriveDate = arriveDate;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Set<Flight> getBookedFlights() {
		return bookedFlights;
	}

	public void setBookedFlights(Set<Flight> bookedFlights) {
		this.bookedFlights = bookedFlights;
	}

	@Override
	public String toString() {
		return "TravelPlan [planId=" + planId + ", city=" + city + ", country=" + country + ", continent=" + continent
				+ ", arriveDate=" + arriveDate + ", depatureDate=" + departureDate + ", createDate=" + createDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arriveDate == null) ? 0 : arriveDate.hashCode());
		result = prime * result + ((bookedFlights == null) ? 0 : bookedFlights.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((continent == null) ? 0 : continent.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((departureDate == null) ? 0 : departureDate.hashCode());
		result = prime * result + ((planId == null) ? 0 : planId.hashCode());
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
		TravelPlan other = (TravelPlan) obj;
		if (arriveDate == null) {
			if (other.arriveDate != null)
				return false;
		} else if (!arriveDate.equals(other.arriveDate))
			return false;
		if (bookedFlights == null) {
			if (other.bookedFlights != null)
				return false;
		} else if (!bookedFlights.equals(other.bookedFlights))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (continent == null) {
			if (other.continent != null)
				return false;
		} else if (!continent.equals(other.continent))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (departureDate == null) {
			if (other.departureDate != null)
				return false;
		} else if (!departureDate.equals(other.departureDate))
			return false;
		if (planId == null) {
			if (other.planId != null)
				return false;
		} else if (!planId.equals(other.planId))
			return false;
		return true;
	}
	
	

}
