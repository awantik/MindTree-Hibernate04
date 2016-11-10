package Day7;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class CriteriaTest {
	
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
		CriteriaTest et = new CriteriaTest();
        et.setup();
		
		Session session = et.factory.openSession();
		Criteria cr = session.createCriteria(Employee.class);
		cr.add(Restrictions.lt("salary", 1000));
		cr.add(Restrictions.eq("name","Awantik"));
		cr.add(Restrictions.like("name", "Awan%"));
		cr.add(Restrictions.ilike("name", "awa%"));
		cr.add(Restrictions.between("salary", 1000, 5000));
		
		//Ctiteria cr = session.createCriteria(arg0)
		//Deattached Criteria as they are not associated with session
		Criterion salary = Restrictions.gt("salary",1000 );
		Criterion name = Restrictions.eq("name", "Awantik");
		
		LogicalExpression orExp = Restrictions.or(salary,name);
		cr.add(orExp);
		cr.addOrder(Order.desc("salary"));
		cr.addOrder(Order.asc("salary"));
		List results = cr.list(); 
		
		cr.setProjection(Projections.rowCount());
		cr.setProjection(Projections.avg("salary"));
		
		cr.setProjection(Projections.max("salary"));
	    cr.setProjection(Projections.groupProperty("salary"));
		
		
	}

}
