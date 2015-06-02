package fr.utbm.core.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import fr.utbm.core.entity.Temperature;
import fr.utbm.core.tools.HibernateUtil;

public class TemperatureDao {
	public void insererTemperature(Temperature temperature){
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.merge(temperature);
			session.getTransaction().commit();
		}
		catch (HibernateException he) {
			he.printStackTrace();
			if(session.getTransaction() != null) { 
				try {
					session.getTransaction().rollback();	
				}
				catch(HibernateException he2) {he2.printStackTrace(); }
			}
		}
		finally {
			if(session != null) {
				try { session.close();
				}
				catch(HibernateException exception){
					
				}
			}

		}
	}
}

