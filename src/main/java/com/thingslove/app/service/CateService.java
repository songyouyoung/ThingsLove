package com.thingslove.app.service;

import com.thingslove.app.dao.CateDao;
import com.thingslove.app.domain.CateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CateService {
    @Autowired
    CateDao cateDao;
    
///////////////////////////////////
//////////// 카테고리 리스트 조회
///////////////////////////////////
    public List<CateDto> selectCateList(Integer userNo) {
        return cateDao.selectCateList(userNo);
    }


}
