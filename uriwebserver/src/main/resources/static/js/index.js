var uri_text;
var ok_button;
var close_button;
var statement_bar;
var agree_checkbox;
var get_uri_button;

function getid() {
    uri_text = $("#uri_text");
    ok_button = $("#ok_button");
    close_button = $("#close_button");
    statement_bar = $("#statement_bar");
    agree_checkbox = document.getElementById("agree_checkbox");
    get_uri_button = $("#get_uri_button");
}

$(function () {
    getid();
    ok_button.click(function () {
        if (uri_text.val().trim().length == 0) {
            alert("必须输入一个有效的原始链接");
        } else {
            statement_bar.show();
        }
    });

    close_button.click(function () {
        agree_checkbox.checked = false;
        statement_bar.hide();
    });
    get_uri_button.click(function () {
        if (agree_checkbox.checked) {
			var uri_form = $("#uri_form");
        	var action = uri_form.attr("action");
            var uri_data = uri_form.serialize();
            var type = uri_form.attr("method")
            console.log(uri_data);
            console.log(type)
            $.ajax({
                type: type,
                url: action,
                data: uri_data,
                success: function (result) {
                    console.log(result);
                },
                error: function (e) {
                    alert(e);
                }
            });
        } else {
            alert("必须先同意");
        }
    });
});