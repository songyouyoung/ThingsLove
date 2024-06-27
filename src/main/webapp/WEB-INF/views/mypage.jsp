<%@ page import="java.util.Date" %>
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
    <link rel="stylesheet" href="<c:url value='/css/mypage.css'/>">

    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="mypage p_50">
    <div class="my_header cursor">
        <ul class="setting none">
            <li id="set_edit">정보수정</li>
            <li id="set_del">회원탈퇴</li>
        </ul>
    </div>
    <div class="my_info">
        <div class="my_level">
            <div class="my_level_img"></div>
            <span>등급명</span>
        </div>
        <div class="my_img"></div>
        <div class="my_name">이름</div>
    </div>
    <div class="my_info_date">
        <div class="my_date_with">
            <div class="heart"></div>
            <div class="my_date_txt">
                <span class="icon_heart">♥ </span>사랑하는 것들과 함께한 지 <span id="my_date_num_with" class="my_date_num"></span>일째
            </div>
        </div>
        <div class="my_date_cate">
            <div class="heart"></div>
            <div class="my_date_txt">
                <span class="icon_heart">♥ </span><span class="my_date_name"></span>과(와) 함께한 지 <span id="my_date_num_cate" class="my_date_num"></span>일째
            </div>
        </div>
    </div>
    <div class="my_new_thing">
        <div class="my_n_title">최근 함께한 것</div>
        <ul class="item_ul">
            <li>
                <div class="item_li">
                    <div class="m_check m_check_img"></div>
                    <div class="item_li_img"></div>
                    <div class="item_li_regDate">♥ + <span>n</span></div>
                    <div class="item_li_title">
                        <span class="item_li_t_title">이름</span>
                        <span class="item_li_t_price">￦</span>
                    </div>
                </div>
            </li>
            <li>
                <div class="item_li">
                    <div class="m_check m_check_img"></div>
                    <div class="item_li_img"></div>
                    <div class="item_li_regDate">♥ + <span>n</span></div>
                    <div class="item_li_title">
                        <span class="item_li_t_title">이름</span>
                        <span class="item_li_t_price">￦</span>
                    </div>
                </div>
            </li>
            <li>
                <div class="item_li">
                    <div class="m_check m_check_img"></div>
                    <div class="item_li_img"></div>
                    <div class="item_li_regDate">♥ + <span>n</span></div>
                    <div class="item_li_title">
                        <span class="item_li_t_title">이름</span>
                        <span class="item_li_t_price">￦</span>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</div>
<jsp:include page="footer.jsp"/>
<%--<script src="<c:url value='/js/mypage.js'/>"></script>--%>
</body>
</html>