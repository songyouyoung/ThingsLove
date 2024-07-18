<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session = "false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="<c:url value='/css/common.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/write_item.css'/>">

    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
</head>
<body>
<div class="write_item">
    <form action="<c:url value='/item/add'/>" method="POST" enctype="multipart/form-data" id="write">
        <div class="w_btn_box">
            <button type="submit" id="w_btn_edit" class="w_btn cursor">수정</button>
            <button type="submit" id="w_btn_save" class="w_btn cursor">저장</button>
            <div class="w_btn_close cursor">X</div>
        </div>
        <div class="w_main">
            <div class="w_file_box cursor w_m_file_box">
                <input type="file" name="imgItem" class="w_file_input" accept="image/*" style="display: none;">
                <div class="w_file_upload w_m_file_upload">+</div>
                <div class="w_file_close w_m_file_close none">X</div>
            </div>
            <ul class="w_input_box">
                <li class="w_i_li w_i_flex"><span class="w_i_txt">카테고리: </span><select name="cateNo" id="itemCate"></select></li>
                <li class="w_i_li"><input type="text" name="itemName" id="itemName" class="w_input" placeholder="이름" autofocus required></li>
                <li class="w_i_li"><input type="text" name="itemWhere" id="itemWhere" class="w_input" placeholder="구매처"></li>
                <li class="w_i_li">
                    <div class="itemPrice_txt">￦</div>
                    <input type="text" name="itemPrice" id="itemPrice" class="w_input" placeholder="구매가" min="0">
                </li>
                <%
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String today = sdf.format(new Date());
                %>
                <li class="w_i_li w_i_flex"><span class="w_i_txt">구매일자: </span><input type="date" name="itemBuyDate" id="itemDate" class="w_input" max="<%= today %>">
                <li class="w_i_li"><span class="w_i_txt">사랑에 빠진 이유: </span>
                    <textarea name="itemDesc" id="itemTxt"></textarea>
                </li>
                <li class="w_i_li w_i_flex">
                    <div class="item_receipt">
                        <span class="w_i_txt">영수증</span>
                        <div class="w_file_box cursor w_i_r_file_box">
                            <input type="file" name="imgItemRec" class="w_file_input" accept="image/*" style="display: none;">
                            <div class="w_file_upload w_i_r_file_upload">+</div>
                            <div class="w_file_close w_i_r_file_close none">X</div>
                        </div>
                    </div>
                    <div class="item_guarantee">
                        <span class="w_i_txt">품질보증서</span>
                        <div class="w_file_box cursor w_i_file_box">
                            <input type="file" name="imgItemGuar" class="w_file_input" accept="image/*" style="display: none;">
                            <div class="w_file_upload w_i_g_file_upload">+</div>
                            <div class="w_file_close w_i_g_file_close none">X</div>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </form>
</div>
<script src="<c:url value='/js/write_item.js'/>"></script>
</body>
</html>