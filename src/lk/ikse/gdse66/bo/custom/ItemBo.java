package lk.ikse.gdse66.bo.custom;

import lk.ikse.gdse66.bo.SuperBo;
import lk.ikse.gdse66.dto.CustomerDto;
import lk.ikse.gdse66.dto.ItemDto;

public interface ItemBo extends SuperBo {
    boolean saveItem(ItemDto dto) throws Exception;

    boolean updateItem(ItemDto dto) throws Exception;

    boolean deleteItem(String code) throws Exception;
}
