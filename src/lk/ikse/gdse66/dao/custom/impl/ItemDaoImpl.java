package lk.ikse.gdse66.dao.custom.impl;

import lk.ikse.gdse66.config.SessionFactoryConfig;
import lk.ikse.gdse66.dao.custom.ItemDao;
import lk.ikse.gdse66.entity.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ItemDaoImpl implements ItemDao {
    @Override
    public boolean save(Item item) throws Exception {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(item);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Item item) throws Exception {
       Session session = SessionFactoryConfig.getInstance().getSession();
       Transaction transaction= session.beginTransaction();
       session.update(item);
       transaction.commit();
       session.close();
        return true;
    }

    @Override
    public boolean delete(String code) throws Exception {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Item item = session.load(Item.class,code);
        session.delete(item);
        transaction.commit();
        return true;
    }
}
