package com.thingslove.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @GetMapping("/")
    public String showIndex(HttpSession session, Model model, HttpServletResponse response){
        Integer userNo = (Integer) session.getAttribute("userNo");

        // 로그인 세션 없을 시 login 페이지로 이동
        if(userNo == null){ return "login"; }
        else {
            return "index";
        }
    }
}
