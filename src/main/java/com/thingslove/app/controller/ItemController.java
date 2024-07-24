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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService itemService;

    // 상품 화면 띄우기
    @GetMapping("/item")
    public String showItemAdd(){ return "write_item"; }

    String F_PATH = "C:/Users/user/Desktop/portfolio/github/ThingsLove/src/main/webapp/resources/img/things/";
    // 상품 추가
    @PostMapping("/add")
    public String addItem(@RequestParam(value="imgItem", required = false) MultipartFile imgItem,
                            @RequestParam(value="imgItemRec", required = false) MultipartFile imgItemRec,
                            @RequestParam(value="imgItemGuar", required = false) MultipartFile imgItemGuar,
                            HttpSession session, HttpServletRequest request, ItemDto itemDto, String priceItem){
        // 추가할 상품 내용 정리
        String itemPriceString = priceItem.replace(",", "");
        Integer itemPrice = Integer.parseInt(itemPriceString.isEmpty() ? "0" : itemPriceString);
        itemDto.setItemPrice(itemPrice);
        Integer userNo = (Integer) session.getAttribute("userNo");
        itemDto.setUserNo(userNo);
        itemDto.setItemImg(uploadFile(imgItem));
        itemDto.setItemImgRec(uploadFile(imgItemRec));
        itemDto.setItemImgGuar(uploadFile(imgItemGuar));
        System.out.println("itemDto : " + itemDto);
        // 실제 상품 DB 추가
        Integer inserResult = itemService.insertItem(itemDto);

        String prevPage = "";
        String prevPageTmp = request.getHeader("REFERER");
        if(!prevPageTmp.contains("login") || prevPage.isEmpty()){ prevPage = prevPageTmp; }
        if (prevPage.isEmpty() || prevPage.contains("login")){ prevPage = "http://localhost:8080/app/"; }
        System.out.println("prevPage : " + prevPage);
        return "redirect:/";
    }
    public String uploadFile(MultipartFile file){
        if (file == null){ return ""; }
        String fileName = file.getOriginalFilename();
        if (fileName.equals("")){ return ""; }
        String safeFileName = System.currentTimeMillis() + fileName;
        String safeFile = F_PATH + safeFileName;
        try {
            file.transferTo(new File(safeFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return safeFileName;
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
