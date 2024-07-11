package com.thingslove.app.dao;

import com.thingslove.app.domain.CateDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CateDao {
    @Autowired
    SqlSession session;

    String namespace = "com.thingslove.app.dao.cateMapper.";

    public List<CateDto> selectCateList(Integer userNo) {
        return session.selectList(namespace + "selectCateList", userNo);
    }
}
