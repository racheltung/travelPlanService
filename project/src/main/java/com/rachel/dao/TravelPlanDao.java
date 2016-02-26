package com.rachel.dao;

import java.util.List;

import com.rachel.model.TravelPlan;

public interface TravelPlanDao {
	public Boolean addTravelPlan(TravelPlan tp);

	public List<TravelPlan> getAllTravelPlan();
	
	public Boolean removeTravelPlanById (Integer planId);
	
	public TravelPlan getTravelPlanById (Integer planId);
}
