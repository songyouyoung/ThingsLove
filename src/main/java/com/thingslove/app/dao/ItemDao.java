package com.thingslove.app.dao;

import com.thingslove.app.domain.CateDto;
import com.thingslove.app.domain.ItemDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ItemDao {
    @Autowired
    SqlSession session;

    String namespace = "com.thingslove.app.dao.itemMapper.";

    public List<ItemDto> selectItemList(Map<String, Integer> selecItem) {
        return session.selectList(namespace + "selectItemList", selecItem);
    }
}
