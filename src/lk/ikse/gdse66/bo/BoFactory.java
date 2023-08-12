package lk.ikse.gdse66.bo;

import lk.ikse.gdse66.bo.custom.impl.CustomerBoImpl;
import lk.ikse.gdse66.bo.custom.impl.ItemBoImpl;
import lk.ikse.gdse66.bo.custom.impl.OrderBoImpl;
import lk.ikse.gdse66.dao.custom.impl.ItemDaoImpl;

public class BoFactory {
    public static <T extends SuperBo>T getBo(BoType type) {
        switch (type) {
            case CUSTOMER:
                return (T) new CustomerBoImpl();
            case ITEM:
                return (T) new ItemBoImpl();
            case ORDER:
                return (T) new OrderBoImpl();
            default:
                return null;
        }
    }
}
