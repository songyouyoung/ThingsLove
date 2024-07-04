<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session = "false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>내가 사랑하는 것들</title>
    <link rel="shortcut icon" href="<c:url value='/img/logo.png'/>" type="image/x-icon">
    <link rel="stylesheet" href="<c:url value='/css/common.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/h_f.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/login_join.css'/>">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
</head>
<body>
<div id="wrap" class="logjoin">
    <div class="find logo"><a href="<c:url value='/'/>">내가 사랑하는 것들</a></div>
    <div class="find_box">
        <div class="find_title">아이디 찾기</div>
        <input type="text" name="userName" id="name" class="idpw" placeholder="이름" autofocus required>
        <div class="phone_area">
            <span>010</span>
            <input type="number" name="userPhone" id="phone" class="idpw" placeholder="전화번호" required onkeyup="checkPw()">
        </div>
        <input type="date" name="userBirth" id="birth" class="idpw" placeholder="생년월일" required max="9999-12-31">
        <button class="btn_sub" onclick="findit('id')">아이디 찾기</button>
    </div>
    <div class="login_btn_etc">
        <div class="login_find">
            <a class="login_id" href="<c:url value="/login/login"/>">로그인</a>
            <a class="login_pw" href="<c:url value="/login/find_pw"/>">비밀번호 찾기</a>
        </div>
        <a href="<c:url value="/login/join"/>" class="login_join">회원가입</a>
    </div>
</div>
<script src="<c:url value='/js/login_join.js'/>"></script>
</body>
</html>