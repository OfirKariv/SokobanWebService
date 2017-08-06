package db;


import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbSolutionHandler implements DbHandler {
	
	private SessionFactory factory;
	
	public DbSolutionHandler() {
		Configuration configuration = new Configuration();
		configuration.configure();
		factory = configuration.buildSessionFactory();
	}
	

	@Override
	public void addSolution(SokobanSolution sol) {
		
		System.out.print("add solution ");
		sol.printValues();
		Session session = null;
		Transaction tx = null;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			session.save(sol);
			tx.commit();			
		}
		catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
			System.out.println(ex.getMessage());
		}
		finally {
			if (session != null)
				session.close();
		}	

	}

	@Override
	public String getSolution(String levelID) {
Session session = null;		
		
		try {
			session = factory.openSession();			
			
			SokobanSolution sol = session.get(SokobanSolution.class, levelID);
			if (sol != null) {
				return sol.getSolution();
			}			
		}
		catch (HibernateException ex) {			
			System.out.println(ex.getMessage());
		}
		finally {
			if (session != null)
				session.close();
		}
		return null;

	}

}
