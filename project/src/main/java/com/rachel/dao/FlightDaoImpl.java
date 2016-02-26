package com.rachel.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.rachel.model.Flight;

public class FlightDaoImpl implements FlightDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Override
	@Transactional
	public Boolean addFlight(Flight flight) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(flight);
		return true;
	}

	@Override
	@Transactional
	public List<Flight> getAllFlights() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM Flight").list();
	}

	@Override
	@Transactional
	public Boolean removeFlightByFlightNo(String flightNo) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete Flight where flightNo = :flightNo");
		query.setParameter("flightNo", flightNo);
		Integer result = query.executeUpdate();
		return (result != null && result==1)?true:false;
	}

	@Override
	@Transactional
	public Flight getFlightByFlightNo(String flightNo) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Flight where flightNo = :flightNo");
		query.setParameter("flightNo", flightNo);
		List<Flight> list = query.list();
		return ( list != null && list.size() == 1)? list.get(0):null;
	}

}
