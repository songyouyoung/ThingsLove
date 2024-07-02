<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session = "false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="userNo" value="${ pageContext.request.getSession(false).getAttribute('userNo')}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>내가 사랑하는 것들</title>

    <link rel="shortcut icon" href="<c:url value='/img/logo.png'/>" type="image/x-icon">
    <link rel="stylesheet" href="<c:url value='/css/common.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/h_f.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/index.css'/>">

    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<main>
    <div class="m_header">
        <div class="my_level">
            <div class="my_level_img"></div>
            <span>등급명</span>
        </div>
        <div class="m_h_fix m_h_fix_move">
            <div class="m_h_btn cursor">&lt;&lt;</div>
            <ul class="m_h_li">
                <li>카테고리 <div class="m_h_li_add_btn">+</div></li>
                <li data-cate="all" class="m_h_item">전체
                    <div class="m_h_li_box"></div>
                </li>
                <li data-cate="" class="m_h_item"><span class="m_h_li_txt">카테명_1</span> (<span class="m_h_li_cnt">개수</span>) <div class="m_h_li_btn m_h_li_del_btn"></div> <div class="m_h_li_btn m_h_li_edit_btn"></div>
                    <div class="m_h_li_box"></div>
                </li>
                <li data-cate="" class="m_h_item"><span class="m_h_li_txt">카테명_2</span> (<span class="m_h_li_cnt">개수</span>) <div class="m_h_li_btn m_h_li_del_btn"></div> <div class="m_h_li_btn m_h_li_edit_btn"></div>
                    <div class="m_h_li_box"></div>
                </li>
            </ul>
        </div>
    </div>
    <div class="main p_50">
        <div class="m_title">
            <div class="m_t_left">
                <div class="m_t_l_txt">카테고리명 (<span>개수</span>) </div>
                <div class="won_btn cursor">￦</div>
            </div>
            <div class="m_t_right cursor">
                <span>최신순</span>
                <span>▼</span>
                <ul class="sort_list none">
                    <li data-order="itemRegDate" data-sort="ASC">최신순</li>
                    <li data-order="itemRegDate" data-sort="DESC">오래된순</li>
                    <li data-order="itemPrices" data-sort="DESC">높은가격순</li>
                    <li data-order="iteFmPrices" data-sort="ASC">낮은가격순</li>
                </ul>
            </div>
        </div>
        <div class="m_move">
            <div class="m_check_img cursor" id="m_check_all"></div>
            <div class="m_move_box cursor">
                <span>이동&ensp;▼</span>
                <ul class="m_move_ul none">
                    <li>카테고리</li>
                    <li>카테고리</li>
                    <li>카테고리</li>
                </ul>
            </div>
        </div>
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
    <div class="fixed_btn cursor">+</div>
</main>
<jsp:include page="footer.jsp"/>
<script>
    let userNo = "${userNo}";
    let cateNo = "${cateNo}";
</script>
<script src="<c:url value='/js/index.js'/>"></script>
</body>
</html>