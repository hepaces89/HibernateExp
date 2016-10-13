package com.gmail.hubert.hibernateExp.service;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.gmail.hubert.hibernateExp.data.Circle;

import junit.framework.Assert;

public class DemoHibernateLifeCycleTest {
	SessionFactory sessionFactory;

	public DemoHibernateLifeCycleTest(){
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try{
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch(Exception e){
			//failed to create session factory;
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		//save stuff and close the session.
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Circle circle = new Circle(2);
		
		session.save(circle);
		session.getTransaction().commit();
		session.close();
		
		//pull the session
		session = sessionFactory.openSession();
		session.beginTransaction();
		List<Circle> results = session.createQuery("from Circle", Circle.class).getResultList();
		
		for(Circle result : results){
			System.out.println(result);
		}
		
		session.getTransaction().commit();
		session.close();
		Assert.assertTrue(true);
	}

}
