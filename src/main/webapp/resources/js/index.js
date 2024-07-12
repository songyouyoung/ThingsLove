const C_PATH = (location.pathname).split("/")[1];

$(document).ready(function(){
// /////////////////////////////////////////////
// index 초기화
// /////////////////////////////////////////////
    let cate_check = 0;
    let cateAllCnt = 0;
    cateList.forEach((cate) => {
        // 카테고리 리스트 출력 (카테고리 이동 셀렉트 박스)
        let move_li = `<li data-cate="${cate.cateNo}">${cate.cateName}</li>`;
        $(".m_move_ul").append(move_li);

        // // 카테고리 리스트 출력 (fixed menu)
        cateAllCnt += cate.cateCnt;
        let fixed_li = `<li data-cate="${cate.cateNo}" class="m_h_item" ${cate.cateNo == cateNo ? `style="font-weight: bold;"` : ""}>
                                    <span class="m_h_li_txt">${cate.cateName}</span> (<span class="m_h_li_cnt">${cate.cateCnt}</span>) <div class="m_h_li_btn m_h_li_del_btn"></div> <div class="m_h_li_btn m_h_li_edit_btn"></div>
                                    <div class="m_h_li_box"></div>
                                </li>`;
        $(".m_h_li").append(fixed_li);

        // 카테고리 명 출력
        if (cate.cateNo == cateNo){
            $("#m_t_l_txt").text(cate.cateName);
            $("#m_t_l_cnt").text(cate.cateCnt);
            cate_check++;
        }
    });
    // 카테고리 명 출력
    if (cateNo == ""){
        $("#m_t_l_txt").text("전체");
        $("#m_t_l_cnt").text(`${cateAllCnt}`);
        $('.m_h_item[data-cate="0"]').css({fontWeight: "bold"});
    }else if (cate_check == 0){
        Swal.fire({
            icon: "warning",
            title: "해당 카테고리는 존재하지 않습니다."
        }).then(()=>{
            if (window.history.length > 1 && document.referrer !== ""){
                window.history.back();
            }else{
                location.replace('/'+C_PATH);
            }
        });
    }

// /////////////////////////////////////////////
// fixed menu - 다른 곳 클릭
// /////////////////////////////////////////////
    $(document).on('click', function(event) {
        //swal 제외
        if (!$('.swal2-container').is(event.target) && $('.swal2-container').has(event.target).length === 0) {
            // cate 추가 li 생성 후 다른 곳 클릭했을 시 삭제
            if (!$('.m_h_li_add').is(event.target) && $('.m_h_li_add').has(event.target).length === 0) {
                $(".m_h_li_add").remove();
            }
            // cate 수정 input 생성 후 다른 곳 클릭했을 시 삭제
            if (!$('.m_h_li_edit_input').is(event.target) && $('.m_h_li_edit_input').has(event.target).length === 0) {
                $(".m_h_li_edit_input").remove();
                $(".m_h_li_txt").css({display : "inline"});
            }
            
            // sort_list 닫음
            if (!$('.m_t_right').is(event.target) && $('.m_t_right').has(event.target).length === 0) {
                $(".sort_list").addClass("none");
            }

            // 이동 닫음
            if (!$('.m_move_box').is(event.target) && $('.m_move_box').has(event.target).length === 0) {
                $(".m_move_ul").addClass("none");
            }
        }
    });
// /////////////////////////////////////////////
// fixed menu
// /////////////////////////////////////////////
    $(document).on('click', '.m_h_btn', function(){
        document.getElementsByClassName("m_h_fix")[0].classList.toggle("m_h_fix_move");
        $(this).html($(this).html() == "&lt;&lt;" ? "&gt;&gt;" : "&lt;&lt;");
    });
// menu - cate 선택
    $(document).on('click', '.m_h_item', function(event){
        event.stopPropagation()
        if ($(this).data("cate") == 0){
            location.replace('/'+C_PATH);
        }else {
            location.replace('/' + C_PATH + '?cateNo=' + $(this).data("cate"));
        }
    });
// menu - cate 추가
    $(document).on('click', '.m_h_li_add_btn', function(event){
        event.stopPropagation()
        // add input이 이미 있는 경우 생성 안함.
        if($(".m_h_li_add").length > 0){return;}
        let m_h_li_add_html = `<li class="m_h_li_add"><input type="text" class="m_h_li_add_input" autofocus><button class="m_h_li_add_sub">생성</button></li>`;
        $('.m_h_li li').eq(0).after(m_h_li_add_html);
    });
// menu - cate 실제 추가 (카테고리 생성 버튼 클릭)
    $(document).on('click', '.m_h_li_add_sub', function (event){
        event.stopPropagation()
        cate_add();
    });
    $(document).on('keyup', '.m_h_li_add_input', function(event){
        if(event.keyCode == 13){ cate_add(); }
    });
    function cate_add() {
        let add_name = $('.m_h_li_add_input').val();
        // todo:: 카테 이름 중복 체크 필요
        /*cate_add_error("중복된 이름입니다.");
        return;*/
        if (add_name == ""){
            cate_add_error("1자 이상 입력해주세요.");
            return;
        }
        // todo:: java 처리 필요
        let m_h_li_html = `<li data-cate="${cateNo}" class="m_h_item"><span class="m_h_li_txt">${add_name}</span> (<span class="m_h_li_cnt">0</span>)
                                <div class="m_h_li_btn m_h_li_del_btn"></div> <div class="m_h_li_btn m_h_li_edit_btn"></div>
                                    <div class="m_h_li_box"></div>
                                </li>`;
        $('.m_h_li').append(m_h_li_html);
        $(".m_h_li_add").remove();
    }
    function cate_add_error(title) {
        Swal.fire({
            icon: "warning",
            title: title
        });
        $(".m_h_li_add_input").focus();
        return;
    }
// menu - cate 삭제
    $(document).on('click', '.m_h_li_del_btn', function(event){
        event.stopPropagation()
        let cateCnt = $(this).parent().children(".m_h_li_cnt").text();
        if (cateCnt > 0){
            Swal.fire({
                icon: "warning",
                title: "카테고리 삭제 실패",
                text: "카테고리안에 상품이 있을 시 삭제 불가합니다. "
            });
        }else{
            // todo:: 카테고리 삭제 ajax
            Swal.fire({
                icon: "success",
                title: "카테고리 삭제 성공!"
            }).then(()=>{ $(this).parent().remove() });
        }
    });
// menu - cate명 수정
    $(document).on('click', '.m_h_li_edit_btn', function(event){
        event.stopPropagation();
        let this_li = $(this).parent();
        let this_li_txt = this_li.children(".m_h_li_txt");
        // 수정할 수 있게 input 생성
        if(!this_li.children('.m_h_li_edit_input').length > 0){
            // 다른 li의 text, input 초기화
            $(".m_h_li_txt").css({display : "inline"});
            $(".m_h_li_edit_input").remove();

            let cateName = this_li_txt.text();
            let cateEdit_html = `<input type="text" class="m_h_li_edit_input" value="${cateName}" autofocus>`;
            this_li_txt.css({display : "none"});
            this_li.prepend(cateEdit_html);
        }
        // 실제 수정 실행
        else{
            // todo:: db 카테고리명 수정 ajax
            cate_edit();
        }
    });
    $(document).on('click', '.m_h_li_edit_input', function(event){ event.stopPropagation(); });
    $(document).on('keyup', '.m_h_li_edit_input', function(event){
        if(event.keyCode == 13){ cate_edit(); }
    });
    function cate_edit() {
        let this_li_txt = $(".m_h_li_edit_input").parent().children(".m_h_li_txt");
        // todo:: 중복된 카테명 없는 지 체크

        let cateEditName = $(".m_h_li_edit_input").val();
        this_li_txt.text(cateEditName);
        $(".m_h_li_edit_input").remove();
        this_li_txt.css({display : "inline"});
    }

// /////////////////////////////////////////////
// 스크롤 - + 버튼 footer 영역 침범 불가
// /////////////////////////////////////////////
    let fix_btn = $('.fixed_btn');
    let foot_pos = $('footer').offset().top + 40;
    $(window).scroll(function(){
        if(($(window).height() + $(window).scrollTop()) >= foot_pos) {
            fix_btn.css({
                position: "absolute",
                bottom: "10px"
            });
        }else{
            fix_btn.css({
                position: "fixed",
                bottom: "50px"
            });
        }
    });

// /////////////////////////////////////////////
// check
// /////////////////////////////////////////////
    // todo:: 상품 개수 가져와서 checks 초기화하기
    let checks = new Array(cateAllCnt).fill(false);
    $(document).on('click', '.m_check_img', function(){
        let bol_check;
        $(this).toggleClass("check");
        let index = $(".main").find('.m_check_img').index(this)
        bol_check = checks[index] ? false : true;
        checks[index] = bol_check
        if(index == 0) { // 전체 체크
            $(".main").find('.m_check_img').each(function(index) {
                if (index > 0) {
                    bol_check ? $(this).addClass("check") : $(this).removeClass("check");
                    checks[index] = bol_check;
                }
            });
        }
    });

// /////////////////////////////////////////////
// 정렬
// /////////////////////////////////////////////
    // 정렬 클릭 시 정렬 리스트 보여주기
    $(document).on('click', '.m_t_right', function(){
        $(".sort_list").toggleClass("none");
    });
    // 실제 정렬

// /////////////////////////////////////////////
// 이동
// /////////////////////////////////////////////
    // 이동 클릭 시 카테고리 리스트 보여주기
    $(document).on('click', '.m_move_box', function(){
        $(".m_move_ul").toggleClass("none");
    });
    // 실제 이동
    $(document).on('click', '.m_move_ul > li', function(){
        let moveItem = [];
        for(let i = 0; i < cateAllCnt; i++){
            if (checks[i]){
                moveItem.push(itemList[i].itemNo);
            }
        }
        $.ajax({
            url: "/" + C_PATH + "/item/move?cateNo="+$(this).data("cate"),
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(moveItem),
            success: function (data) {
                Swal.fire({
                    icon: "success",
                    title: "상품 이동 완료!"
                }).then(() => {
                    location.reload();
                });
            }, error: function () {
                Swal.fire({
                    icon: "warning",
                    title: "상품 이동 오류.<br> 관리자에게 문의해주세요."
                });
            }
        });
    });

// /////////////////////////////////////////////
// 상품 추가
// /////////////////////////////////////////////
    $(document).on('click', '.fixed_btn', function(){
        // if (userNo == ""){
        //     Swal.fire({
        //         icon: "warning",
        //         title: "로그인이 필요한 서비스입니다. "
        //     }).then(()=>{
        //         location.href = "/" + C_PATH + "/login/login?prevPage="+location.pathname;
        //     });
        // }else {
            $.ajax({
                url: "/" + C_PATH + "/item/item",
                type: "GET",
                success: function (data) {
                    $("main").append(data);
                    $("#w_btn_edit").remove();
                }, error: function () {
                    Swal.fire({
                        icon: "warning",
                        title: "상품 추가 오류.<br> 관리자에게 문의해주세요."
                    });
                }
            });
        // }
    });

// /////////////////////////////////////////////
// 상품 리스트 출력
// /////////////////////////////////////////////
    if (itemList == null){
        $(".item_ul").html(`<li id="item_none">등록한 상품이 없습니다. <br> 아래 + 버튼을 눌러 상품을 등록해보세요! </li>`);
    }else{
        $(".item_ul").html("");
        let item_check = 0;
        let today = new Date();
        // today = createDate(today, "-");
        itemList.forEach((item)=>{
            if (cateNo == "" || item.cateNo == cateNo) {
                let date = item.itemBuyDate == null ? Math.floor((today.getTime() - item.itemRegDate) / (1000 * 3600 * 24))
                    : Math.floor((today.getTime() - item.itemBuyDate) / (1000 * 3600 * 24));
                let li = `<li class="item_li" data-itemNo = "${item.itemNo}">
                                <div class="m_check m_check_img"></div>
                                <div class="item_li_img"><img src="/${C_PATH}/img/things/${item.itemImg}"></div>
                                <div class="item_li_regDate">♥ + <span>${date}</span></div>
                                <div class="item_li_title">
                                    <span class="item_li_t_title">${item.itemNickName == null ? (item.itemName == null ? "" : item.itemName) : item.itemNickName}</span>
                                    <span class="item_li_t_price">￦${item.itemPrice.toLocaleString("ko")}</span>
                                </div>
                            </li>`;
                $(".item_ul").append(li);
                item_check++;
            }
        });
        if (item_check == 0){
            $(".item_ul").html(`<li id="item_none">등록한 상품이 없습니다. <br> 아래 + 버튼을 눌러 상품을 등록해보세요! </li>`);
        }
    }
    function createDate(dt, mark){
        let year = dt.getFullYear();
        let month = dt.getMonth()+1 < 10 ? "0" + (dt.getMonth()+1) : dt.getMonth()+1;
        let date = dt.getDate() < 10 ? "0" + dt.getDate() : dt.getDate();

        return year + mark + month + mark + date;
    }

// /////////////////////////////////////////////
// 상품 상세 보기
// /////////////////////////////////////////////
    $(document).on('click', '.item_li:not(.m_check)', function(e){
        // m_check인 경우 제외
        if ($(e.target).closest('.m_check').length) {
            e.stopPropagation();
            return;
        }
        let itemNo = $(this).data("itemNo");
        // if (userNo == ""){
        //     Swal.fire({
        //         icon: "warning",
        //         title: "로그인이 필요한 서비스입니다. "
        //     }).then(()=>{
        //         location.href = "/" + C_PATH + "/login/login?prevPage="+location.pathname;
        //     });
        // }else {
        $.ajax({
            url: "/" + C_PATH + "/item/item",
            type: "GET",
            success: function (data) {
                /////////////////////////////////
                // 추후 상품 리스트로 받아서 여기서 강제로 데이터 입력해서 출력할 것.
                /////////////////////////////////
                $("main").append(data);
            }, error: function () {
                Swal.fire({
                    icon: "warning",
                    title: "상품 조회 오류.<br> 관리자에게 문의해주세요."
                });
            }
        });
        // }
    });
});