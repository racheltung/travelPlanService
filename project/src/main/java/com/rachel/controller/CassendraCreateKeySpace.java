package com.rachel.controller;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class CassendraCreateKeySpace {

	public static void main(String[] args) {
		//String query = "CREATE KEYSPACE fuhuPlan WITH replication " + "= {'class':'SimpleStrategy', 'replication_factor':1};";
		//String query = "DROP KEYSPACE fuhuPlan ";
		String query = "select * from travel_plan ";
		// creating Cluster object
		Cluster cluster = Cluster.builder().addContactPoint("192.168.30.189").build();

		// Creating Session object
		Session session = cluster.connect("fuhuPlan");

		// using the KeySpace
		session.execute("USE fuhuPlan");

		// Executing the query
		ResultSet result = session.execute(query);
		
		for (Row row: result){
			System.out.println(row.toString());
		}
//		System.out.println(result.all());
		System.out.println("Query finished!");
	}

}
