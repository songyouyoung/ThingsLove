package com.thingslove.app.controller;

import com.thingslove.app.domain.ItemDto;
import com.thingslove.app.service.CateService;
import com.thingslove.app.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService itemService;

    // 상품 화면 띄우기
    @GetMapping("/item")
    public String showItemAdd(){ return "write_item"; }

    // 상품 추가
    @PostMapping("/add")
    public String addItem(HttpSession session, HttpServletRequest request, ItemDto itemDto){
        Integer userNo = (Integer) session.getAttribute("userNo");
        String prevPage = "";
        String prevPageTmp = request.getHeader("REFERER");
        if(!prevPageTmp.contains("login") || prevPage.isEmpty()){ prevPage = prevPageTmp; }
        if (prevPage.isEmpty() || prevPage.contains("login")){ prevPage = "http://localhost:8080/app/"; }
        System.out.println("prevPage : " + prevPage);
        System.out.println("itemDto : " + itemDto);
        return "index";
    }

    // 상품 카테고리 변경
    @PostMapping("/move")
    @ResponseBody
    public ResponseEntity<String> moveItem(HttpSession session, HttpServletRequest request, Model model, Integer cateNo, @RequestBody Integer[] itemList){
        try {
            Integer userNo = (Integer) session.getAttribute("userNo");
            Map<String, Object> items = new HashMap<>();
            items.put("userNo", userNo);
            items.put("cateNo", cateNo);
            items.put("itemList", itemList);
            itemService.moveItem(items);
            return new ResponseEntity<String>(userNo+"", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }
}
