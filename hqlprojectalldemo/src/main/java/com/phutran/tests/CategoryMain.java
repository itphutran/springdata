package com.phutran.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.phutran.entities.Category;
import com.phutran.services.CategoryService;
import com.phutran.services.CategoryServiceImpl;
import com.phutran.utils.HibernateUtil;
public class CategoryMain {
	public static void main(String[] args) {

		CategoryService categoryService = new CategoryServiceImpl();
		//Category category = categoryService.findByCatId(8);
		//System.out.println(category.getName() + "-- "+category.getId());
		System.out.println("--------------------------------------");
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Category category2 = session.find(Category.class, 6);
		System.out.println(category2);
		EntityManager entityManager = sessionFactory.createEntityManager();
		Query createQuery = entityManager.createQuery("select s from Category s");
		List resultList = createQuery.getResultList();
		System.out.println(resultList.size());
		System.out.println("tyle query");
		TypedQuery<Category> typeQuery = entityManager.createQuery("From Category", Category.class);
		List<Category> resultList2 = typeQuery.getResultList();
		System.out.println(resultList2.size());
		System.out.println("=======");
		
		Query createNamedQuery = entityManager.createQuery("FROM Category");
		createNamedQuery.setHint("javax.persistence.query.timeout", 10000).
		setFlushMode( FlushModeType.COMMIT );
		System.out.println(createNamedQuery.getResultList().size());
	}

	private static void createData() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Creating dataa....");
		try {
			for (int i = 1; i <= 20; i++) {
				Category category = new Category();
				category.setName("Cat - " + i);
				session.save(category);
			}
			tx.commit();
			System.out.println("Done!");
		} catch (Exception e) {
			System.out.println("Exception....");
			System.out.println(e.getMessage());
		} finally {
			sessionFactory.close();
		}
	}
}
