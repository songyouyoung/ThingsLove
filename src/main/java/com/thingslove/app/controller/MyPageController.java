package com.thingslove.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thingslove.app.domain.UserDto;
import com.thingslove.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/myPage")
public class MyPageController {
    @Autowired
    UserService userService;

    @GetMapping("")
    public String showMyPage(HttpSession session, Model model) throws JsonProcessingException {
        Integer userNo = (Integer) session.getAttribute("userNo");
        if (userNo == null || userNo < 1){ return "redirect:/"; }

        Map<String, Object> mypageDesc = userService.selectMyPage(userNo);
        ObjectMapper mapper = new ObjectMapper();
        String user_js = mapper.writeValueAsString(mypageDesc);

        model.addAttribute("user", mypageDesc.get("user"));
        model.addAttribute("buyCnt", mypageDesc.get("buyCnt"));
        model.addAttribute("cancelCnt", mypageDesc.get("cancelCnt"));
        model.addAttribute("user_js", user_js);
        return "mypage";
    }

    @GetMapping("/update")
    public String showMyPageUpdate(HttpSession session, Model model) throws JsonProcessingException {
        Integer userNo = (Integer) session.getAttribute("userNo");
        ObjectMapper mapper = new ObjectMapper();
        String user = mapper.writeValueAsString(userService.selectUser(userNo));
        model.addAttribute("user", user);
        return "join";
    }
    @PostMapping("/update")
    public String updateMyPage(UserDto userDto, Model model){
        Integer updateChk = userService.updateUser(userDto);
        if (updateChk == null || updateChk < 1){
            model.addAttribute("error", "회원 정보 수정 오류.<br>관리자에게 문의해주세요.");
            return "redirect:/myPage/update";
        }else{
            model.addAttribute("welcome", "회원정보 수정 완료!");
            return "redirect:/myPage?";
        }
    }
}