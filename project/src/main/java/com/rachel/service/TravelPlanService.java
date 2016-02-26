package com.rachel.service;

import java.util.List;

import com.rachel.model.TravelPlan;


public interface TravelPlanService {
	public Boolean addTravelPlan(TravelPlan tp);
	public Boolean removeTravelPlan(Integer planId);
	public TravelPlan getTravelPlanById(Integer planId);
	public List<TravelPlan> getPlanList();
}
