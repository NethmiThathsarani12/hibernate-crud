package lk.ikse.gdse66.config;

import lk.ikse.gdse66.entity.Customer;
import lk.ikse.gdse66.entity.Item;
import lk.ikse.gdse66.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig {

    private static SessionFactoryConfig factoryConfig;

    private SessionFactory sessionFactory;

    private SessionFactoryConfig() {
        sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().configure().build())
                .addAnnotatedClass(Customer.class)
                 .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Order.class)
                .getMetadataBuilder().
                        applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                .build().buildSessionFactory();

        sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Customer.class)
                 .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Order.class)
                .buildSessionFactory();
    }

    public static SessionFactoryConfig getInstance() {
        return (null == factoryConfig)
                ? factoryConfig = new SessionFactoryConfig() : factoryConfig;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

}