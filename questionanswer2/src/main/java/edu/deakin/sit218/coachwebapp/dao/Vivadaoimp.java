package edu.deakin.sit218.coachwebapp.dao;

import org.apache.coyote.http11.filters.VoidInputFilter;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

import edu.deakin.sit218.coachwebapp.entity.Client;

public class Vivadaoimp implements Vivadao{

private SessionFactory sessionFactory ;
	
	public Vivadaoimp ()
	{
		sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Client.class)
				.buildSessionFactory();
	}
	
	@Override
	public void insertData(Client client) {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			session.beginTransaction();
			
			//save the client object
			session.save(client);
			
			//commit transaction 
			session.getTransaction().commit();
			}
			finally {
				session.close();
			}
	}
	@Override
	public Client retreiveData(Client client)
	{
		Session session = sessionFactory.getCurrentSession();
		try {
			
			session.beginTransaction();
			
			String hqlString = "from Client where question='"+client.getQuestion()+"' and answer ='"+client.getAnswer()+"'and area fo Question ='"+client.getAreaofKnowledge();
			
			Query<Client> query = session.createQuery(hqlString);
			
			//Obtain the query results
			List<Client> clients = query.getResultList();
			
			if (clients.isEmpty()) {
				throw new RuntimeException("There is no client: "+client.toString());
			}
			
			else {
				return clients.get(0);
			}
			//commit transaction 	
			}
			finally {
				session.close();
			}
	}
	/*
	 * @Override public void returnDistinct (Client client) { Session session =
	 * sessionFactory.getCurrentSession(); try {
	 * 
	 * session.beginTransaction();
	 * 
	 * //save the client object session.save(client);
	 * 
	 * //commit transaction session.getTransaction().commit(); } finally {
	 * session.close(); }
	 * 
	 * }
	 * 
	 * @Override public boolean existsClient(Client client) { throw new
	 * RuntimeException("No metho implemented yet ");
	 * 
	 * }
	 */


	@Override
	protected void finalize() throws Throwable {
		sessionFactory.close();
		
	}
	
	
}
