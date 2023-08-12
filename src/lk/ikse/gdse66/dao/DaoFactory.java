package lk.ikse.gdse66.dao;

import lk.ikse.gdse66.dao.custom.impl.CustomerDaoImpl;
import lk.ikse.gdse66.dao.custom.impl.ItemDaoImpl;
import lk.ikse.gdse66.dao.custom.impl.OrderDaoImpl;

public class DaoFactory {
    public static <T extends SuperDao> T getDao(DaoType type) {
        switch (type) {
            case CUSTOMER:
                return (T) new CustomerDaoImpl();
            case ITEM:
                return (T) new ItemDaoImpl();
            case ORDER:
                return (T) new OrderDaoImpl();
            default:
                return null;
        }
    }
}