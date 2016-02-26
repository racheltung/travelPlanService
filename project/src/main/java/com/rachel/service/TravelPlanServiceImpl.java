package com.rachel.service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.rachel.dao.FlightDao;
import com.rachel.dao.TravelPlanDao;
import com.rachel.model.Flight;
import com.rachel.model.TravelPlan;

public class TravelPlanServiceImpl implements TravelPlanService {
	
	@Autowired
	private TravelPlanDao travelPlanDao;
	
	@Autowired
	private FlightDao flightDao;
	
	public TravelPlanDao getTravelPlanDao() {
		return travelPlanDao;
	}
	
	public FlightDao getFlightDao() {
		return flightDao;
	}

	@Override
	public Boolean addTravelPlan(TravelPlan tp) {
		return travelPlanDao.addTravelPlan(tp);
	}

	@Override
	public List<TravelPlan> getPlanList() {
		List<TravelPlan> list = travelPlanDao.getAllTravelPlan();
		return list;	
	}

	@Override
	public Boolean removeTravelPlan(Integer planId) {
		return travelPlanDao.removeTravelPlanById(planId);
	}

	@Override
	public TravelPlan getTravelPlanById(Integer planId) {
		return travelPlanDao.getTravelPlanById(planId);
	}

}
