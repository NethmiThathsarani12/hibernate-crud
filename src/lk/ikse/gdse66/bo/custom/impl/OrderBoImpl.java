package lk.ikse.gdse66.bo.custom.impl;

import lk.ikse.gdse66.bo.custom.OrderBo;
import lk.ikse.gdse66.dao.DaoFactory;
import lk.ikse.gdse66.dao.DaoType;
import lk.ikse.gdse66.dao.custom.OrderDao;
import lk.ikse.gdse66.dto.OrderDto;
import lk.ikse.gdse66.entity.Order;

public class OrderBoImpl implements OrderBo {

    private OrderDao dao = DaoFactory.getDao(DaoType.ORDER);


    @Override
    public boolean saveOrder(OrderDto dto) throws Exception {
        return dao.save(new Order(
                dto.getOid(),
                dto.getCustomerId(),
                dto.getItemCode(),
                dto.getQty(),
                dto.getUnitPrice(),
                dto.getTotal()
        ));
    }
}
