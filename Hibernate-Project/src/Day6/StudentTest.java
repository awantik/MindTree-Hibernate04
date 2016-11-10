package Day6;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class StudentTest {
	
	SessionFactory factory;

	public void setup(){
		Configuration configuration = new Configuration();
		configuration.configure();
		
		ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
		srb.applySettings(configuration.getProperties());
		
		ServiceRegistry serviceRegistry = srb.buildServiceRegistry();
		factory = configuration.buildSessionFactory(serviceRegistry);		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentTest et = new StudentTest();
		et.setup();
		
		Session session = et.factory.openSession();
		
//		Transaction tx = session.beginTransaction();
//		
//		Student e = new Student("Jill",20);
//		session.save(e);
//		Student f = new Student("Denny",30);
//		session.save(f);
//		
//		tx.commit();
		
//		String hql = "FROM Student";
//		Query query = session.createQuery(hql);
//		
//		List<Student> results = query.list();
//		
//		for(Student s: results){
//			System.out.println(s);
//		}
		
//		String hql = "FROM Student S where S.age > 30";
//		Query query = session.createQuery(hql);
//		
//		List<Student> results = query.list();
//		
//		for(Student s: results){
//			System.out.println(s);
//		}
//		String hql = "FROM Student S where S.age > 30";
//		Query query = session.createQuery(hql);
//		
//		List<Student> results = query.list();
//		
//		for(Student s: results){
//			System.out.println(s);
//		}

//		String hql = "SELECT SUM(S.age), S.name FROM Student S GROUP BY S.age";
//		Query query = session.createQuery(hql);
//		
//		List<Res> results = query.list();
//		
//		System.out.println(results);

//		Transaction tx = session.beginTransaction();
//		
//		String hql = "UPDATE Student set age = :age WHERE name = :name";
//		
//		Query query = session.createQuery(hql);
//		query.setParameter("age", 90);
//		query.setParameter("name", "Jill");
//		
//		int res = query.executeUpdate();
//		System.out.println(res);
//		tx.commit();
		
//		Transaction tx = session.beginTransaction();
//		String hql = "DELETE FROM Student WHERE name = :name";
//		Query query = session.createQuery(hql);
//		query.setParameter("name", "Jill");
//		int res = query.executeUpdate();
//		System.out.println(res);
//		tx.commit();
		
		Transaction tx = session.beginTransaction();
		
		String hql = "INSERT INTO Student(name,age) VALUES('abc',34)";
		Query query = session.createQuery(hql);
		int res = query.executeUpdate();
		
		System.out.println(res);
		
		tx.commit();
		
		session.close();

	}

}
