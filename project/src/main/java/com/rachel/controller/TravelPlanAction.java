package com.rachel.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rachel.model.Flight;
import com.rachel.model.TravelPlan;
import com.rachel.service.TravelPlanService;

@Controller
@RequestMapping("/travelPlan")
public class TravelPlanAction {

	private TravelPlanService tpService;

	@Autowired
	public void setTpService(TravelPlanService tpService) {
		this.tpService = tpService;
	}

	@RequestMapping("/addTravelPlan")
	@ResponseBody
	public Map<String, Object> addTravelPlan(@RequestParam(value = "city", defaultValue = "Melbourne") String city,
			@RequestParam(value = "country", defaultValue = "Australia") String country,
			@RequestParam(value = "continent", defaultValue = "asia") String continent,
			@RequestParam(value = "arriveDate", defaultValue = "2099-12-31") String arriveDate,
			@RequestParam(value = "departureDate", defaultValue = "2099-12-31") String departureDate) {

		Map<String, Object> retMap = new HashMap<String, Object>();
		Set<Flight> flightSet = new HashSet<Flight> ();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		
		TravelPlan tp = new TravelPlan();
		tp.setCity(city);
		tp.setCountry(country);
		tp.setContinent(continent);
		tp.setCreateDate(new Date());
		try {
			tp.setArriveDate(dateFormat.parse(arriveDate));
			tp.setDepartureDate(dateFormat.parse(departureDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Flight bf = new Flight();
		Flight bf2 = new Flight();
		bf.setFlightNo("CF778");
		bf.setDepAirport("TPE");
		bf.setDestAirport("MEL");
		bf2.setFlightNo("CF779");
		bf2.setDepAirport("MEL");
		bf2.setDestAirport("TPE");
		try {
			bf.setArrvTime(timeFormat.parse("14:21:00"));
			bf.setDepTime(timeFormat.parse("20:19:00"));
			bf2.setArrvTime(timeFormat.parse("20:19:00"));
			bf2.setDepTime(timeFormat.parse("14:21:00"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		flightSet.add(bf);
		flightSet.add(bf2);
		tp.getBookedFlights().addAll(flightSet);
		
		Boolean result = tpService.addTravelPlan(tp);

		if (result){
			retMap.put("status", "successful!");}
		else{
			retMap.put("status", "ooops... error!");
		}
		return retMap;
	}

	@RequestMapping(value = "/getTravelPlanList", produces="application/json")
	@ResponseBody
	public List<TravelPlan> getTravelPlanList() {
		List<TravelPlan> travelPlanList = tpService.getPlanList();
		return travelPlanList;
	}
	
	@RequestMapping(value = "/getTravelPlan", produces="application/json")
	@ResponseBody
	public TravelPlan getTravelPlan(Integer planId){
		if (planId == null) return null;
		TravelPlan tp = this.tpService.getTravelPlanById(planId);
		return tp;
	}
	
	@RequestMapping("/deleteTravelPlan")
	@ResponseBody
	public Map<String,Object> deleteTravelPlan(Integer planId){
		Map<String, Object> retMap = new HashMap<String, Object>();
		if (planId == null) return null;
		Boolean result = this.tpService.removeTravelPlan(planId);
		
		if (result){
			retMap.put("status", "successful!");}
		else{
			retMap.put("status", "ooops... error!");
		}
		return retMap;
	}
	
	@RequestMapping("/getTravelDest")
	@ResponseBody
	public TravelPlan getTravelDest(Integer planId){
		if (planId == null) return null;
		TravelPlan plan = this.tpService.getTravelPlanById(planId);
		return plan;
	}
}
