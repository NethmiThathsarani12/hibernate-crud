package lk.ikse.gdse66.dao.custom;

import lk.ikse.gdse66.dao.SuperDao;
import lk.ikse.gdse66.entity.Order;

public interface OrderDao extends SuperDao {

    boolean save(Order order) throws Exception;
}
