package lk.ikse.gdse66.dao.custom.impl;

import lk.ikse.gdse66.config.SessionFactoryConfig;
import lk.ikse.gdse66.dao.custom.CustomerDao;
import lk.ikse.gdse66.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public boolean save(Customer customer) throws Exception {
       Session session = SessionFactoryConfig.getInstance().getSession();
       Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Customer customer) throws Exception {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(customer);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
       Session session =  SessionFactoryConfig.getInstance().getSession();
       Transaction transaction = session.beginTransaction();
       Customer customer = session.load(Customer.class,id);
       session.delete(customer);
       transaction.commit();
        return true;
    }
}

