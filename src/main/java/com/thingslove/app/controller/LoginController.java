package com.thingslove.app.controller;

import com.thingslove.app.domain.UserDto;
import com.thingslove.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserService userService;

//////////////////////
// 로그인
//////////////////////
//폼 보여주기
    String prevPage = "";
    @GetMapping("/login")
    public String showLogin(HttpServletRequest request, Model model){
        String prevPageTmp = request.getHeader("REFERER");
        if(!prevPageTmp.contains("login") || prevPage.isEmpty()){ prevPage = prevPageTmp; }
        if (prevPage.isEmpty() || prevPage.contains("login")){ prevPage = "http://localhost:8080/app/"; }
        model.addAttribute("prevPage", prevPage);
        return "login";
    }
// 실제 로그인
    @PostMapping("/login")
    public String login(UserDto userDto, String login_rem, String prevPage, Model model, HttpSession session, HttpServletResponse response) {
        Integer userNo = userService.userLogin(userDto);
        if (userNo == null || userNo < 1) {
            model.addAttribute("welcome", "아이디 / 비밀번호를 다시 한 번 확인해주세요.");
            return "login";
        }
        session.setAttribute("userNo", userNo);

        //아이디 기억하기
        Cookie cookie = new Cookie("rememberId", userDto.getUserId());
        if (login_rem != null && login_rem.equals("on")) {
            cookie.setMaxAge(60 * 60 * 24 * 30);
        }else {
            cookie.setMaxAge(0);
        }
        cookie.setPath("/");
        response.addCookie(cookie);

        if (prevPage.isEmpty()){ prevPage = "http://localhost:8080/app/"; }
        return "redirect:"+prevPage;
    }

//////////////////////
// 로그아웃
//////////////////////
    @GetMapping("/logout")
    public String showLogout(HttpSession session, HttpServletResponse response){
        // 세션 전체 삭제
        session.invalidate();
        return "redirect:/";
    }

//////////////////////
// 회원가입
//////////////////////
// 회원가입 폼 보여주기
    @GetMapping("/join")
    public String join(){
        return "join";
    }
// 실제 회원가입
    @PostMapping("/join")
    public String join(UserDto userDto, Model model) throws Exception{
        String error = "";
        try {
            // 아이디, 전화번호, 이메일 중복 체크
            Map<String, String> userChk = userService.userChk(userDto);
            if (!userChk.isEmpty()){
                error += userChk.get("id") == null? "" : userChk.get("id");
                error += (!error.equals("")? "<br>" : "") + (userChk.get("phone") == null? "" : userChk.get("phone"));
                error += (!error.endsWith("<br>")? "<br>" : "") + (userChk.get("email") == null? "" : userChk.get("email"));
                throw new Exception("회원가입 오류. 아이디/전화번호 중복.");
            }
            // 회원가입 실패 체크
            int joinChk = userService.joinUser(userDto);
            if (joinChk == 0) { throw new Exception("회원가입 오류."); }
            
            model.addAttribute("welcome", "회원가입 완료!<br>로그인 후 다양한 서비스를 이용해 보세요.");
            return "login";
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("error", (error.equals("")?"회원가입 오류<br>관리자에게 문의해주세요.":error));
            return "join";
        }
    }

//////////////////////
// 아이디/비밀번호 찾기
//////////////////////
// 아이디 찾기 폼 보여주기
    @GetMapping("/find_id")
    public String findId(){
        return "find_id";
    }
// 실제 아이디 찾기
    @PostMapping("/find_id")
    @ResponseBody
    public ResponseEntity<String> getFindId(@RequestBody UserDto userDto){
        try {
            String userId = userService.userFindId(userDto);
            if (userId.isEmpty()){ throw new Exception("아이디찾기 결과 없음. "); }
            return new ResponseEntity<String>(userId, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }

// 비밀번호 찾기 폼 보여주기
    @GetMapping("/find_pw")
    public String findPw(){
        return "find_pw";
    }
// 실제 비밀번호 찾기
    UserDto findUserDto = new UserDto();
    @PostMapping("/find_pw")
    @ResponseBody
    public ResponseEntity<String> getFindPw(@RequestBody UserDto userDto){
        try {
            findUserDto = userDto;

            Integer userPwChk = userService.userFindPw(userDto);
            if (userPwChk != 1){ throw new Exception("아이디찾기 결과 없음. "); }
            return new ResponseEntity<String>(HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }
// 비밀번호 변경 폼 보여주기
    @GetMapping("/change_pw")
    public String showChangePw(){
        return "change_pw";
    }
    @PostMapping("/change_pw")
    public String changePw(Model model, String userPw){
        try {
            findUserDto.setUserPw(userPw);
            Integer changePw = userService.updatePw(findUserDto);
            if (changePw < 1){ throw new Exception("비밀번호 변경 오류. "); }
            model.addAttribute("welcome", "비밀번호 변경 완료!<br>로그인 후 다양한 서비스를 이용해 보세요.");
            return "login";
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("error", "비밀번호 변경 오류<br>관리자에게 문의해주세요.");
            return "join";
        }
    }

}