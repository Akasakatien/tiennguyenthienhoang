package model;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import entities.*;

public class OrdersModel {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public List<Orders> findAll() {
		List<Orders> orders = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			orders = session.createQuery("from Orders").list();

			transaction.commit();
		} catch (Exception e) {
			orders = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}

		return orders;
	}
	
	public Orders find(int id) {
		Orders orders = null;
		Session session = sessionFactory.openSession(); // nam giu ket noi
		Transaction transaction = null; // thuc hien cac cau truy van
		try {
			transaction = session.beginTransaction();
			// thao tac co so du lieu o day
			Query query = session.createQuery("from Orders where id = :id");
			query.setInteger("id", id);
			orders = (Orders) query.uniqueResult();
			// ========
			transaction.commit();
		} catch (Exception e) {
			orders = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return orders;
	}
	
	public boolean update(Orders orders) {
		boolean result = false;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			//thao tac co so du lieu o day
			session.update(orders);
			result = true;
			//========
			transaction.commit();
		} catch (Exception e) {
			result = false;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}
	
	public boolean delete(Orders orders) {
		boolean result = false;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			//thao tac co so du lieu o day
			session.delete(orders);
			result = true;
			//========
			transaction.commit();
		} catch (Exception e) {
			result = false;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}
	
	public boolean create(Orders orders) {
		boolean result = false;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			//thao tac co so du lieu o day
			session.save(orders);
			result = true;
			//========
			transaction.commit();
		} catch (Exception e) {
			result = false;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Orders> search(int year, int month, int day) {
		List<Orders> orders = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery(
					"from Orders where year(dateCreation) = :year and month(dateCreation) = :month and day(dateCreation) = :day");
			query.setParameter("year", year).setParameter("month", month).setParameter("day", day);
			orders = query.list();
			transaction.commit();
		} catch (Exception e) {
			orders = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return orders;
	}
}
