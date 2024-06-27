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

// /////////////////////////////////////////////
// 스크롤 - + 버튼 footer 영역 침범 불가
// /////////////////////////////////////////////
    let fix_btn = $('.fixed_btn');
    /*let fixBtn_pos = fix_btn.offset().top + fix_btn.innerHeight();*/
    let foot_pos = $('footer').offset().top + 40;
    $(window).scroll(function(){
        console.log("window", $(window).height() + $(window).scrollTop());
        console.log("foot_pos", foot_pos);
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
        
    });
});