<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session = "false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="sessionId" value="${ pageContext.request.getSession(false).getAttribute('userNo')!=null? pageContext.request.getSession(false).getAttribute('userNo'):null}" />

<c:set var="logIO_link" value="${ sessionId==null?'/login/login':'/login/logout'}" />
<c:set var="logIO_text" value="${ sessionId==null?'로그인':'로그아웃'}" />
<c:set var="signIO_link" value="${ sessionId==null?'/login/join':'/myPage'}" />
<c:set var="signIO_text" value="${ sessionId==null?'회원가입':'마이페이지'}" />

<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
    <header>
        <div class="logo m_logo">
            <a href="<c:url value='/'/>">내가 사랑하는 것들</a>
        </div>
        <div class="h_right">
            <div class="login">
                <a href="<c:url value='${logIO_link}'/>">
                    <svg xmlns="http://www.w3.org/2000/svg" width="28" height="28" viewBox="0 0 28 28">
                        <g data-name="*ic_header_logout">
                            <path data-name="Rectangle 2119" style="opacity:.5;fill:none" d="M0 0h28v28H0z"/>
                            <g data-name="Group 1783">
                                <path data-name="Path 1909" d="M10.045 19.068h-8.59a.456.456 0 0 1-.477-.432V1.364a.456.456 0 0 1 .477-.432h8.591V.5H1.455a.913.913 0 0 0-.955.864v17.272a.913.913 0 0 0 .955.864h8.591z" transform="translate(4.5 4)" style="stroke:#000;stroke-width:.8px;fill:none"/>
                                <path data-name="Path 1910" d="M184.909 125.769a.682.682 0 0 0 .682.682h12.321l-3.839 3.82a.682.682 0 1 0 .964.964l5-4.983a.683.683 0 0 0 0-.964l-5-4.959a.682.682 0 0 0-.964.964l3.839 3.795h-12.321a.682.682 0 0 0-.682.682z" transform="translate(-174.909 -111.778)" style="stroke:#fff;stroke-width:.2px"/>
                            </g>http://127.0.0.1:5500/
                        </g>
                    </svg>
                </a>
                <div class="h_icon_desc">${logIO_text}</div>
            </div>
            <div class="join">
                <a href="<c:url value='${signIO_link}'/>">
                <%--<a href="/join.jsp">--%>
                    <svg xmlns="http://www.w3.org/2000/svg" width="28" height="28" viewBox="0 0 28 28">
                        <g data-name="*ic_header_recent">
                            <path data-name="Rectangle 2075" style="opacity:.5;fill:none" d="M0 0h28v28H0z"/>
                            <g data-name="*mypage">
                                <path data-name="Path 1203" d="M.5 18.354v-1.143a6.2 6.2 0 0 1 6.415-5.968h6.677a6.2 6.2 0 0 1 6.415 5.968v1.142" transform="translate(3.681 4.951)" style="stroke-linecap:round;stroke-miterlimit:10;stroke:#000;stroke-width:1.2px;fill:none"/>
                                <g data-name="Ellipse 313" transform="translate(9.301 4)" style="stroke:#000;stroke-width:1.2px;fill:none">
                                    <circle cx="4.6" cy="4.6" r="4.6" style="stroke:none"/>
                                    <circle cx="4.6" cy="4.6" r="4" style="fill:none"/>
                                </g>
                            </g>
                        </g>
                    </svg>
                </a>
                <div class="h_icon_desc">${signIO_text}</div>
            </div>
        </div>
    </header>
</body>
</html>