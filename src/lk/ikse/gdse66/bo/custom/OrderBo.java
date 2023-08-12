package lk.ikse.gdse66.bo.custom;

import lk.ikse.gdse66.bo.SuperBo;
import lk.ikse.gdse66.dto.OrderDto;

public interface OrderBo extends SuperBo {

    boolean saveOrder(OrderDto dto) throws Exception;
}
