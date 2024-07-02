const C_PATH = (location.pathname).split("/")[1];

$(document).ready(function(){
// /////////////////////////////////////////////
// check
// /////////////////////////////////////////////
    // todo:: 상품 개수 가져와서 checks 초기화하기
    let checks = new Array(8).fill(false);
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
// fixed menu
// /////////////////////////////////////////////
    $(document).on('click', '.m_h_btn', function(){
        document.getElementsByClassName("m_h_fix")[0].classList.toggle("m_h_fix_move"); 
        $(this).html($(this).html() == "&lt;&lt;" ? "&gt;&gt;" : "&lt;&lt;");
    });
// menu - cate 선택
    $(document).on('click', '.m_h_item', function(event){
        event.stopPropagation()
        location.replace('/'+C_PATH+'/cate?cateNo=' + $(this).data("cate"));
    });
// menu - cate 추가
    $(document).on('click', '.m_h_li_add_btn', function(event){
        event.stopPropagation()
        let m_h_li_add_html = `<li class="m_h_li_add"><input type="text" class="m_h_li_add_input" autofocus><button class="m_h_li_add_sub">생성</button></li>`;
        $('.m_h_li li').eq(0).after(m_h_li_add_html);
    });
// menu - cate 실제 추가
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
            console.log("빈값");
            cate_add_error("1자 이상 입력해주세요.");
            return;
        }
        // todo:: java 처리 필요. cateNo 가져오기
        let cateNo;
        let m_h_li_html = `<li data-cate="${cateNo}" class="m_h_item">${add_name} (<span class="m_h_li_cnt">0</span>) <div class="m_h_li_btn m_h_li_del_btn">-</div>
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
// menu - cate 추가 li 생성 후 다른 곳 클릭했을 시 삭제
    $(document).on('click', function(event) {
        let m_h_li_add = $('.m_h_li_add');
        if (!m_h_li_add.is(event.target) && m_h_li_add.has(event.target).length === 0) {
            $(".m_h_li_add").remove();
        }
    });
// menu - cate 삭제
    $(document).on('click', '.m_h_li_del_btn', function(event){
        event.stopPropagation()
    });

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
// 상품 상세 보기
// /////////////////////////////////////////////
    $(document).on('click', '.item_ul > li', function(){
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