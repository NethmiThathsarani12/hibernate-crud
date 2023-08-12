package lk.ikse.gdse66.bo.custom.impl;

import lk.ikse.gdse66.bo.custom.ItemBo;
import lk.ikse.gdse66.dao.DaoFactory;
import lk.ikse.gdse66.dao.DaoType;
import lk.ikse.gdse66.dao.custom.ItemDao;
import lk.ikse.gdse66.dto.ItemDto;
import lk.ikse.gdse66.entity.Item;

public class ItemBoImpl implements ItemBo {
    private final ItemDao dao = DaoFactory.getDao(DaoType.ITEM);

    @Override
    public boolean saveItem(ItemDto dto) throws Exception {
        return dao.save(new Item(
                dto.getCode(),
                dto.getDescription(),
                dto.getQty(),
                dto.getPrice()
        ));
    }

    @Override
    public boolean updateItem(ItemDto dto) throws Exception {
        return dao.update(new Item(
                dto.getCode(),
                dto.getDescription(),
                dto.getQty(),
                dto.getPrice()
        ));
    }

    @Override
    public boolean deleteItem(String code) throws Exception {
        return dao.delete(code);
    }
}
