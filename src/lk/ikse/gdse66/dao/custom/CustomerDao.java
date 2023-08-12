package lk.ikse.gdse66.dao.custom;

import lk.ikse.gdse66.dao.SuperDao;
import lk.ikse.gdse66.entity.Customer;

public interface CustomerDao extends SuperDao {
    boolean save(Customer customer) throws Exception;

    boolean update(Customer customer) throws Exception;

    boolean delete(String id) throws Exception;
}
