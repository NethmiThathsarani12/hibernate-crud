package lk.ikse.gdse66.dao.custom.impl;

import lk.ikse.gdse66.config.SessionFactoryConfig;
import lk.ikse.gdse66.dao.custom.OrderDao;
import lk.ikse.gdse66.entity.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderDaoImpl implements OrderDao {
    @Override
    public boolean save(Order order) throws Exception {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(order);
        transaction.commit();
        session.close();
        return true;
    }
}
