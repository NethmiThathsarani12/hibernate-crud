package lk.ikse.gdse66.dao.custom;

import lk.ikse.gdse66.dao.SuperDao;
import lk.ikse.gdse66.entity.Customer;
import lk.ikse.gdse66.entity.Item;

public interface ItemDao extends SuperDao {
    boolean save(Item item) throws Exception;

    boolean update(Item item) throws Exception;

    boolean delete(String code) throws Exception;
}
