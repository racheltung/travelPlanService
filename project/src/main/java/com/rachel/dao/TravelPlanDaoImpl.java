package com.rachel.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.rachel.model.Flight;
import com.rachel.model.TravelPlan;

public class TravelPlanDaoImpl implements TravelPlanDao {
	private static final Logger logger = LoggerFactory.getLogger(TravelPlanDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	@Transactional
	public Boolean addTravelPlan(TravelPlan tp) {
		try{
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(tp);
		}catch (Exception e){
			return false;
		}
		return true;
	}

	@Override
	@Transactional
	public List<TravelPlan> getAllTravelPlan() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(TravelPlan.class);
		List<TravelPlan> tpList = cr.list();
		
		/* lazy mode 的寫法
		String hql = "from TravelPlan tp inner join tp.bookedFlights";
		Query query = session.createQuery(hql);
		List<Object[]> listResult = query.list();
		List<TravelPlan> tpList = new ArrayList<TravelPlan> ();
		for (Object[] obj: listResult){
			TravelPlan tp = (TravelPlan) obj[0];
			Flight flight = (Flight) obj[1];
			tp.getBookedFlights().add(flight);
			tpList.add(tp);
		}
		*/
		return tpList;
	}

	@Override
	@Transactional
	public Boolean removeTravelPlanById(Integer planId) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete TravelPlan where planId = :planId");
		query.setParameter("planId", planId);
		Integer result = query.executeUpdate();
		return (result != null && result==1)?true:false;
	}

	@Override
	@Transactional
	public TravelPlan getTravelPlanById(Integer planId) {
		Session session = this.sessionFactory.getCurrentSession();
		TravelPlan tp = null;
		Criteria cr = session.createCriteria(TravelPlan.class);
		cr.add(Restrictions.idEq(planId));
		tp = (TravelPlan) cr.uniqueResult();
		
		/* lazy mode 的寫法
		Hibernate.initialize(tp.getBookedFlights()); 
		Set<Flight> flights = tp.getBookedFlights();
		tp.setBookedFlights(flights);
		 */		
		return tp;
	}

}
