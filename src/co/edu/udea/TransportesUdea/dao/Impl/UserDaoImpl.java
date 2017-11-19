package co.edu.udea.TransportesUdea.dao.Impl;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.TransportesUdea.Exception.MyDaoException;
import co.edu.udea.TransportesUdea.dao.UserDao;
import co.edu.udea.TransportesUdea.dto.Employee;
import co.edu.udea.TransportesUdea.dto.User;

/**
 * 
 * @author Santiago
 * @see co.edu.udea.TransportesUdea.dao.UserDao 
 */
public class UserDaoImpl implements UserDao {
	
	private SessionFactory sessionFactory;

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public User getuserByEmail(String email) throws MyDaoException {
		Session session = null;
		User user= null;
		
		try {
			session = sessionFactory.openSession(); 
			Criteria crit = session.createCriteria(User.class).add(Restrictions.eq("email", email));
			user = (User) crit.uniqueResult(); 
			
		} catch (HibernateException e) {
			// TODO: handle exception
			throw new MyDaoException(e);
		}
		return user;

	}
	
	@Override
	public User getuserById(String id) throws MyDaoException {
		Session session = null;
		User user= null;
		
		try {
			session = sessionFactory.openSession(); 
			Criteria crit = session.createCriteria(User.class).add(Restrictions.eq("id", id));
			user = (User) crit.uniqueResult(); 
			
		} catch (HibernateException e) {
			// TODO: handle exception
			throw new MyDaoException(e);
		}
		return user;

	}

	@Override
	public void saveUser(User user) throws MyDaoException {
		Session session = null;
		// necesario para poder hacer commit a las transacciones
		Transaction transaction=null;
		
		try {
			session = sessionFactory.openSession();
			transaction=session.beginTransaction();
			
			session.save(user);
			// para poder guardar la transation
			transaction.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			throw new MyDaoException(e);
		}
		
	}

	@Override
	public void updateUser(User user) throws MyDaoException {
		Session session = null;
		Transaction transaction=null;
		
		try {
			session = sessionFactory.openSession();
			transaction= session.beginTransaction();
			session.update(user);
			transaction.commit();
			
		} catch (HibernateException e) {
			// TODO: handle exception
			throw new MyDaoException(e);
		}		
	}

	@Override
	public void deleteUser(String id) throws MyDaoException {
		Session session = null;
		Transaction transaction=null;
		User user = new User();
		user.setId(id);
		
		try {
			session = sessionFactory.openSession();
			transaction=session.beginTransaction();
			session.delete(user);
			transaction.commit();
			
		} catch (HibernateException e) {
			// TODO: handle exception
			throw new MyDaoException(e);
		}

	}

	@Override
	public List<User> getAllUsers() throws MyDaoException {
		Session session = null;
		List<User> users= null;
		
		try {
			session = sessionFactory.openSession(); 
			Criteria crit = session.createCriteria(User.class);
			users = crit.list(); 
			
		} catch (HibernateException e) {
			// TODO: handle exception
			throw new MyDaoException(e);
		}
		return users;
	}
	

}
