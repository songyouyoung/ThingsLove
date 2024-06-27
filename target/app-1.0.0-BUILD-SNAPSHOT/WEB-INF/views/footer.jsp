<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session = "false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%--<link rel="stylesheet" href="css/common.css"> <!--index페이지랑 연결시켜 놓은 후 지울 것-->--%>
    <%--<link rel="stylesheet" href="css/h_f.css"> <!--index페이지랑 연결 후 지워도 되는 지 확인 필요-->--%>
</head>
<body>
    <footer>
        <div class="footer_content">
            <div class="f_box">
                <div class="logo f_logo">
                    <a href="<c:url value='/'/>">내가 사랑하는 것들</a>
                </div>
                <div class="f_txt1">© 2024 by TL, Inc. All rights reserved.</div>
            </div>
            <div class="f_box">
                <div class="f_pro_name">Project Name: thingslove</div>
                <div class="name">made by 송유영</div>
            </div>
        </div>
    </footer>
</body>
</html>