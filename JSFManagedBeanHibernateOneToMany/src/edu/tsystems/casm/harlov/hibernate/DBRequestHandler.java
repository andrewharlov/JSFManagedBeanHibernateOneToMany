package edu.tsystems.casm.harlov.hibernate;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

@ManagedBean(name = "dBRequestHandler", eager = true)
@SessionScoped
public class DBRequestHandler {
private ArrayList<User> users;
	
	public DBRequestHandler() {
		this.users = new ArrayList<User>();
	}
	
	public String searchUsers() {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(User.class)
								.addAnnotatedClass(UserConfig.class)
								.addAnnotatedClass(UserGroupConfig.class)
								.addAnnotatedClass(GroupConfig.class)
								.addAnnotatedClass(Filter.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			String hql = "from User u WHERE u.id = :user_id";
			Query query = session.createQuery(hql);
			query.setParameter("user_id", 1000115);
			this.users = (ArrayList<User>) query.getResultList();
			for(User user : users) {
				//System.out.println(user);
			}
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
		
		return "success";
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}
}
