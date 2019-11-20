package com.hash;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("unused")
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		System.out.println(System.getProperty("user.dir"));
		Configuration cfg = new Configuration().configure("resources/hibernate.cfg.xml");
		//		.addFile("resources/student.hbm.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction t = ss.beginTransaction();
		
		Student st = new Student();
		st.setName("lado");
		st.setEmail("lado@gmail.com");
		ss.persist(st);
		
		SchoolStudent st1 = new SchoolStudent();
		st1.setName("abc");
		st1.setEmail("abc@gmail.com");
		st1.setBoard("Nashik");
		//st1.setType("SemiEnglish");
		ss.persist(st1);
		
		CollegeStudent st2 = new CollegeStudent();
		st2.setName("xyz");
		st2.setEmail("xyz@gmail.com");
		st2.setUniversity("Pune");
		st2.setTrade("E&tc");
		ss.persist(st2);
		
		t.commit();
		System.out.println("Record inserted successfully");
		sf.close();
		ss.close();
	}

}
