package lk.ikse.gdse66.bo.custom;

import lk.ikse.gdse66.bo.SuperBo;
import lk.ikse.gdse66.dto.CustomerDto;

public interface CustomerBo extends SuperBo {
    boolean saveCustomer(CustomerDto dto) throws Exception;

    boolean updateCustomer(CustomerDto dto) throws Exception;

    boolean deleteCustomer(String id)throws Exception;

}
