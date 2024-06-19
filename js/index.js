$(document).ready(function(){
    // todo:: 개수 가져와서 index 초기화하기
    let checks;
    $(document).on('click', '.m_check_img', function(){
        $(this).toggleClass("check");
        let index = $(".main").find('.m_check_img').index(this)
        if(index == 0) { // 전체 체크
            console.log("전체")
            $(".main").find('.m_check_img').each(function() {
                if ($(this).index() > 0) {
                    $(this).toggleClass("check");
                }
            });
        }
    });
});