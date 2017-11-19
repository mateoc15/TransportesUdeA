package co.edu.udea.TransportesUdea.dao.Impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.TransportesUdea.Exception.MyDaoException;
import co.edu.udea.TransportesUdea.dao.ReportDao;
import co.edu.udea.TransportesUdea.dto.Report;
import co.edu.udea.TransportesUdea.dto.User;

/**
 * 
 * @author Santiago
 *@see co.edu.udea.TransportesUdea.dao.ReportDao 
 */

public class ReportDaoImpl implements ReportDao {
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Report getReportById(Integer id) throws MyDaoException {
		Session session = null;
		Report report= null;
		
		try {
			session = sessionFactory.openSession(); 
			Criteria crit = session.createCriteria(Report.class).add(Restrictions.eq("id", id));
			report = (Report) crit.uniqueResult(); 
			
		} catch (HibernateException e) {
			// TODO: handle exception
			throw new MyDaoException(e);
		}
		return report;
	}

	@Override
	public List<Report> getReportsPending() throws MyDaoException {
		Session session = null;
		List<Report> ReportsPending = null;
		
		try {
			session = sessionFactory.openSession();
			Criteria crit = session.createCriteria(Report.class).add( Property.forName("status").eq("pendiente"));
			ReportsPending = crit.list(); 
			
		} catch (HibernateException e) {
			// TODO: handle exception
			throw new MyDaoException(e);
			
		}
		return ReportsPending;
	}
	
	
	@Override
	public void saveReport(Report report) throws MyDaoException {
		Session session = null;
		// necesario para poder hacer commit a las transacciones
		Transaction transaction=null;
		
		try {
			session = sessionFactory.openSession();
			transaction=session.beginTransaction();
			
			session.save(report);
			// para poder guardar la transation
			transaction.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			throw new MyDaoException(e);
		}
		
	}

	@Override
	public void updateReport(Report report) throws MyDaoException {
		Session session = null;
		Transaction transaction=null;
		
		try {
			session = sessionFactory.openSession();
			transaction= session.beginTransaction();
			session.update(report);
			transaction.commit();
			
		} catch (HibernateException e) {
			// TODO: handle exception
			throw new MyDaoException(e);
		}
	}

	@Override
	public void deleteReport(Integer id) throws MyDaoException {
		Session session = null;
		Transaction transaction=null;
		Report report = new Report();
		report.setId(id);
		
		try {
			session = sessionFactory.openSession();
			transaction=session.beginTransaction();
			session.delete(report);
			transaction.commit();
			
		} catch (HibernateException e) {
			// TODO: handle exception
			throw new MyDaoException(e);
		}
		
	}
	
	@Override
	public List<Report> getReportsUser(User user) throws MyDaoException {
		Session session = null;
		List<Report> ReportsUser = null;
		
		
		try {
			session = sessionFactory.openSession();
			//Criteria crit = session.createCriteria(Report.class).add( Property.forName("idUser").eq(idUser));
			Criteria crit = session.createCriteria(Report.class).add(Restrictions.eq("idUser",user));
			ReportsUser = crit.list(); 
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new MyDaoException(e);
		}
		return ReportsUser;
	}



}
