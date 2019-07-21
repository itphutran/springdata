package com.phutran.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	public static SessionFactory sessionFactory = getSessionFactory();

	public static SessionFactory getSessionFactory() {
		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
				.configure("com/phutran/configs/hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(standardRegistry).buildMetadata();
		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
		return sessionFactory;
	}

	public static void shutDown() {
		sessionFactory.close();
	}

	public static void main(String[] args) {
		SessionFactory ssFactory = getSessionFactory();
		System.out.println(ssFactory);
	}
}
