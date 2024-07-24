$(document).ready(function() {
// /////////////////////////////////////////////
// 상품 상세보기 닫기
// /////////////////////////////////////////////
    $(document).on('click', '.w_btn_close', function () {
        writeHTML.remove();
    });

// /////////////////////////////////////////////
// 수정 클릭 시 수정으로 변경
// /////////////////////////////////////////////
    $(document).on("click", "#w_btn_edit", function (event) {
        $("#write").prop("action", "/" + C_PATH + "/item/edit");
        $("#w_btn_del").remove();
        $("#w_btn_edit").remove();
        let saveBtn = `<button type="submit" id="w_btn_save" class="w_btn cursor">저장</button>`;
        $(".w_btn_box").prepend(saveBtn);
    });
});