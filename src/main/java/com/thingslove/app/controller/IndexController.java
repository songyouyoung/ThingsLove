package com.thingslove.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thingslove.app.domain.CateDto;
import com.thingslove.app.domain.ItemDto;
import com.thingslove.app.service.CateService;
import com.thingslove.app.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    CateService cateService;
    @Autowired
    ItemService itemService;

    @GetMapping("/")
    public String showIndex(HttpSession session, Model model, HttpServletResponse response, Integer cateNo) throws JsonProcessingException {
        Integer userNo = (Integer) session.getAttribute("userNo");

        // 로그인 세션 없을 시 login 페이지로 이동
        if(userNo == null){ return "login"; }
        else {
            ObjectMapper mapper = new ObjectMapper();
            // 카테고리 리스트 전달
            List<CateDto> cateLi = cateService.selectCateList(userNo);
            // 카테고리 별 아이템 수량 추가
            List<CateDto> cateCntLi = itemService.selectCateCnt(userNo);
            for(CateDto cateCnt:cateCntLi){
                for(CateDto cate:cateLi){
                    cate.setCateCnt(0);
                    if (cate.getCateNo() == cateCnt.getCateNo()){
                        cate.setCateCnt(cateCnt.getCateCnt());
                    }
                }
            }
            String cateList = mapper.writeValueAsString(cateLi);
            model.addAttribute("cateList", cateList);
            // 상품 리스트 전달
            Map<String, Integer> selecItem = new HashMap<>();
            selecItem.put("userNo", userNo);
            selecItem.put("cateNo", cateNo);
            List<ItemDto> itemLi = itemService.selectItemList(selecItem);
            String itemList = mapper.writeValueAsString(itemLi);
            model.addAttribute("itemList", itemList);
            return "index";
        }
    }
}
