package com.thingslove.app.service;

import com.thingslove.app.dao.ItemDao;
import com.thingslove.app.domain.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ItemService {
    @Autowired
    ItemDao itemDao;

///////////////////////////////////
//////////// 아이템 리스트 조회
///////////////////////////////////
    public List<ItemDto> selectItemList(Map<String, Integer> selecItem) {
        return itemDao.selectItemList(selecItem);
    }

///////////////////////////////////
//////////// 카테고리 이동
///////////////////////////////////
    public Integer moveItem(Map<String, Object> moveItem){
        return itemDao.moveItem(moveItem);
    }
}
