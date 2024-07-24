$(document).ready(function(){
// /////////////////////////////////////////////
// 사진 클릭 시 이미지 미리보기
// /////////////////////////////////////////////
    $(document).on("click", ".w_file_box", function(event) {
        event.stopPropagation()
        if ($(event.target).hasClass('w_file_close')) { return; }
        $(this).children(".w_file_input").click();
    });
    $(document).on("click", ".w_file_input", function(event) {
        event.stopPropagation();
    });
    $(".w_file_input").change(getImageFiles);

    let file = null;
    function getImageFiles(e) {
        file = e.currentTarget.files[0];
        const uploadBox = $(this).nextAll('.w_file_upload');
        const imageClose = $(this).nextAll('.w_file_close');        
        const imagePreview = $(this).parent(); // w_file_box

        let chk = true;
        // 파일 타입 검사
        if (!file.type.match("image/.*")) {
            Swal.fire({
                icon: "warning",
                title: "이미지 파일만 업로드가 가능합니다."
            });
            return;
        }

        const reader = new FileReader();
        reader.onload = (e) => {
            uploadBox.addClass("none");
            imageClose.removeClass("none");
            imagePreview.css({ backgroundImage: "url("+ e.target.result +")" });
        };
        reader.readAsDataURL(file);
    }

// /////////////////////////////////////////////
// 사진 삭제
// /////////////////////////////////////////////
    let cancelTxt = "";
    $(document).on('click', '.w_file_close', function(event){
        event.stopPropagation();
        const uploadInput = $(this).prevAll('.w_file_input');
        const uploadBox = $(this).prevAll('.w_file_upload');
        const imagePreview = $(this).parent(); // w_file_box

        uploadBox.removeClass("none");
        $(this).addClass("none");
        imagePreview.css({ backgroundImage: "url('')" });
        uploadInput.val('');
    });

// /////////////////////////////////////////////
// 구매가 숫자 서식
// /////////////////////////////////////////////
    $(document).on('input', '#itemPrice', function() {
        let cursorPosition = this.selectionStart; // 현재 커서 위치 저장
        let inputVal = $(this).val();
    
        inputVal = inputVal.replace(/,/g, ''); // 기존 쉼표 제거
    
        // 입력 값이 숫자가 아니면 빈 문자열로 설정
        if (isNaN(inputVal)) {
            $(this).val('');
            return;
        }
    
        // 정규식을 사용하여 세 자리마다 쉼표 추가
        let formattedVal = inputVal.replace(/\B(?=(\d{3})+(?!\d))/g, ',');
        $(this).val(formattedVal);
    
        // 커서 위치 조정
        this.setSelectionRange(cursorPosition+1, cursorPosition+1);
    });
});