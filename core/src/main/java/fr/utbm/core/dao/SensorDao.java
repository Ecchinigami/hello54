package fr.utbm.core.dao;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import fr.utbm.core.entity.Sensor;
import fr.utbm.core.tools.HibernateUtil;

public class SensorDao {
	public Sensor getSensorById(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			Query q=session.createQuery("From Sensor where Sen_Id=?");
			q.setParameter(0, id);
			Sensor s=(Sensor) q.uniqueResult();
			session.getTransaction().commit();
			return s;
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
		return null;
		
	}
}

