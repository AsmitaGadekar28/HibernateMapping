package com.MainClass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Entities.Laptop;
import com.Entities.Student;

public class OneToOne_MainClass {

	public static void main(String[] args) {
		
		Configuration cfg= new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Student.class);
		cfg.addAnnotatedClass(Laptop.class);
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session s= sf.openSession();
		Transaction t =s.beginTransaction();
		
		Laptop l= new Laptop();
		l.setL_id(1700);
		l.setL_name("Microsoft");
		s.persist(l);
		
		Student s1= new Student();
		s1.setS_id(4512);
		s1.setS_name("Sushant");
		s1.setLaptop(l);
		s.persist(s1);
		
		
		System.out.println("Data is inserted........");
		t.commit();
		s.close();

	}

}
