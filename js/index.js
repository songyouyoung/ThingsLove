$(document).ready(function(){
    // todo:: 상품 개수 가져와서 checks 초기화하기
    let checks = new Array(8).fill(false);
    $(document).on('click', '.m_check_img', function(){
        $(this).toggleClass("check");
        let index = $(".main").find('.m_check_img').index(this)
        checks[index] = checks[index] ? false : true;
        if(index == 0) { // 전체 체크
            $(".main").find('.m_check_img').each(function(index) {
                if (index > 0) { 
                    $(this).toggleClass("check"); 
                    checks[index] = checks[index] ? false : true;
                }
            });
        }
    });
});