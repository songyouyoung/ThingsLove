package com.thingslove.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.thingslove.app.domain.CateDto;
import com.thingslove.app.service.CateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    CateService cateService;

    @GetMapping("/")
    public String showIndex(HttpSession session, Model model, HttpServletResponse response){
        Integer userNo = (Integer) session.getAttribute("userNo");

        // 로그인 세션 없을 시 login 페이지로 이동
        if(userNo == null){ return "login"; }
        else {
            // 카테고리 리스트 전달
            List<CateDto> cateList = cateService.selectCateList(userNo);
            System.out.println(cateList);
            model.addAttribute("cateList", cateList);
            // 상품 리스트 전달
            return "index";
        }
    }
}
