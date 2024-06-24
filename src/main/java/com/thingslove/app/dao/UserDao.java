package com.thingslove.app.dao;

import com.thingslove.app.domain.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDao {
    @Autowired
    SqlSession session;

    String namespace = "com.thingslove.app.dao.userMapper.";
///////////////////////////////////
//////////// 로그인
///////////////////////////////////
    public Integer selectLogin(UserDto userDto){
        return session.selectOne(namespace + "selectLogin", userDto);
    }

///////////////////////////////////
//////////// 회원가입
///////////////////////////////////
    public int insertUser(UserDto userDto){
        return session.insert(namespace + "insertUser", userDto);
    }

    public int selectIdChk(String userId){
        return session.selectOne(namespace + "selectIdChk", userId);
    }

    public int selectPhoneChk(String userPhone){
        return session.selectOne(namespace + "selectPhoneChk", userPhone);
    }

    public int selectEmailChk(String userEmail){
        return session.selectOne(namespace + "selectEmailChk", userEmail);
    }

///////////////////////////////////
//////////// 아이디 / 비밀번호 찾기
///////////////////////////////////
    public String selectFindId(UserDto userDto){
        return session.selectOne(namespace + "selectFindId", userDto);
    }
    public Integer selectFindPw(UserDto userDto){
        return session.selectOne(namespace + "selectFindPw", userDto);
    }

///////////////////////////////////
//////////// 마이페이지
///////////////////////////////////
    public UserDto selectUser(Integer userNo){
        return session.selectOne(namespace + "selectUser", userNo);
    }
    public Integer selectUserBuyCnt(Map<String, String> userBuy){
        return session.selectOne(namespace + "selectUserBuyCnt", userBuy);
    }
    public Integer updatePw(UserDto userDto){
        return session.update(namespace + "updatePw", userDto);
    }
    public Integer updateUser(UserDto userDto){
        return session.update(namespace + "updateUser", userDto);
    }

    public Integer selectUserRevCnt(Integer userNo){
        return session.selectOne(namespace + "selectUserRevCnt", userNo);
    }
    public Integer selectUserQnaCnt(Integer userNo){
        return session.selectOne(namespace + "selectUserQnaCnt", userNo);
    }
}
