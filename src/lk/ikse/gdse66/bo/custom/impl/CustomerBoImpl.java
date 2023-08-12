package lk.ikse.gdse66.bo.custom.impl;

import lk.ikse.gdse66.bo.custom.CustomerBo;
import lk.ikse.gdse66.dao.DaoFactory;
import lk.ikse.gdse66.dao.DaoType;
import lk.ikse.gdse66.dao.custom.CustomerDao;
import lk.ikse.gdse66.dto.CustomerDto;
import lk.ikse.gdse66.entity.Customer;

public class CustomerBoImpl implements CustomerBo {
    private CustomerDao dao = DaoFactory.getDao(DaoType.CUSTOMER);

    @Override
    public boolean saveCustomer(CustomerDto dto) throws Exception {
        return dao.save(new Customer(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getTp()
        ));
    }

    @Override
    public boolean updateCustomer(CustomerDto dto) throws Exception {
        return dao.update(new Customer(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getTp()
        ));
    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return dao.delete(id);
    }


}
