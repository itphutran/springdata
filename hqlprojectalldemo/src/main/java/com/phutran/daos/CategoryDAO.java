package com.phutran.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.phutran.entities.Category;
import com.phutran.utils.HibernateUtil;

public class CategoryDAO {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = null;
	Transaction tx = null;
	
	@Transactional
	public void save(Category category) {
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(category);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			sessionFactory.close();
		}
	}

	public void update(Category category) {
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.update(category);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			sessionFactory.close();
		}
	}

	public void delete(Long catId) {
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.delete(catId);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			sessionFactory.close();
		}
	}

	public Category findById(Integer catId) {
		Category category = null;
		try {
			session = sessionFactory.openSession();
			category = session.get(Category.class, catId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return category;
		} finally {
			sessionFactory.close();
		}
		return category;
	}

	@SuppressWarnings("unchecked")
	public List<Category> findAll() {
		List<Category> listCat = null;
		try {
			session = sessionFactory.openSession();
			listCat = session.createQuery("FROM Category c").getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sessionFactory.close();
		}
		return listCat;
	}
}
