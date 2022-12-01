package employee.app.dao.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	// private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;
//	public SessionFactory factory = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
	

	public HibernateUtil() {

	}

	private static void setSessionFactory() throws Exception {

//		Configuration cfg = new Configuration().configure("Hibernate.cfg.xml");
//		StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder()
//				.applySettings(cfg.getProperties()).configure();
//		sessionFactory = cfg.buildSessionFactory(registryBuilder.build());

		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("Hibernate.cfg.xml")
				.build();

		// Create MetadataSources
		MetadataSources metadataSources = new MetadataSources(standardRegistry);
		// Create Metadata
		Metadata metadata = metadataSources.getMetadataBuilder().build();
		sessionFactory = metadata.getSessionFactoryBuilder().build();

	}

//	private static void setSessionFactory() throws Exception {
//		try {
//			Configuration configuration = new Configuration().configure("Hibernate.cfg.xml");
//			sessionFactory = configuration.buildSessionFactory();
////			sessionFactory = new AnnotationConfiguration().configure("hibernate/hibernate.cfg.xml")
////					.buildSessionFactory();
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new Exception(e);
//		}
//
//	}

	/**
	 * @return Session - Hibernate Session Object
	 * @throws Exception
	 */
	public static Session getHibernateSession() throws Exception {

		try {
			if (sessionFactory == null) {
				setSessionFactory();
			}

			return sessionFactory.openSession();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}

	}

}
