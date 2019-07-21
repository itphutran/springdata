package com.phutran.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;

import com.phutran.entities.Category;
import com.phutran.services.CategoryService;
import com.phutran.services.CategoryServiceImpl;
import com.phutran.utils.HibernateUtil;

public class CategoryMain2 {
	public static void main(String[] args) {
		SessionFactory emf = HibernateUtil.getSessionFactory();
		EntityManager entityManager = emf.createEntityManager();
		/*
		 * CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		 * CriteriaQuery<Category> createQuery =
		 * criteriaBuilder.createQuery(Category.class); Root<Category> root =
		 * createQuery.from(Category.class); createQuery.select(root);
		 * createQuery.where(criteriaBuilder.equal(root.get("id"), 8)); Category
		 * singleResult = entityManager.createQuery(createQuery).getSingleResult();
		 * System.out.println(singleResult.getName());
		 */
		Session session = emf.openSession();
		//Criteria criteria = emf.openSession().createCriteria(Category.class);
		/*
		System.out.println("QUERY LIST");
		List list = criteria.list();
		System.out.println(list.size());
		System.out.println("QUERY BY ID USE EQ____");
		criteria.add(Restrictions.eq("id", 9));
		criteria.addOrder(Order.desc("id"));
		Category uniqueResult = (Category) criteria.uniqueResult();
		System.out.println(uniqueResult.getName());
		Criteria setProjection = criteria.setProjection(Projections.rowCount());
		Object uniqueResult2 = setProjection.uniqueResult();
		System.out.println("--------------------------------");
		*/
		//criteria.add(Restrictions.between("id", 8, 10));
		//criteria.add(Restrictions.in("id", 1,3,8));
		//criteria.add(Restrictions.isNotNull("id"));
		//scriteria.add(Restrictions.like);
		/*Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.ge("id", 8));
		disjunction.add(Restrictions.le("id", 12));*/
		
		/*Conjunction conjunction = Restrictions.conjunction();
		conjunction.add(Restrictions.ge("id", 8));
		conjunction.add(Restrictions.le("id", 12));
		criteria.add(conjunction);*/
		/*criteria.add(Restrictions.sqlRestriction("{alias}.name like '%c'"));*/
		//criteria.add(Restrictions.)
		///criteria.setFirstResult(0).setMaxResults(4);
		//List<Category> list2 = criteria.list();
		
		//for (Category string : list2) {
		//	System.out.println(string);
		//}
		NativeQuery createNativeQuery = session.createNativeQuery("select id , name  from categories where id >:id");
		//createNativeQuery.addJoin("news", path);
		createNativeQuery.setParameter("id", 8);
		
		List list = createNativeQuery.getResultList();
		System.out.println(list.size());
		
		//Persistence.createEntityManagerFactory(persistenceUnitName)
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
