package com.thingslove.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/item")
public class ItemController {
    // 상품 화면 띄우기
    @GetMapping("/item")
    public String showItemAdd(){ return "write_item"; }
}
