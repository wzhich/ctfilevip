var uri_text;
var ok_button;
var close_button;
var statement_bar;
var agree_checkbox;
var get_uri_button;
var uri_form;
var result_bar;
var link_bar;
var file_info;
var message;
function getid() {
    uri_text = $("#uri_text");
    ok_button = $("#ok_button");
    close_button = $("#close_button");
    statement_bar = $("#statement_bar");
    agree_checkbox = document.getElementById("agree_checkbox");
    get_uri_button = $("#get_uri_button");
    uri_form = $("#uri_form");
    result_bar = $("#result_bar");
    link_bar = $("#link_bar");
    file_info = $("#file_info");
    message = $("#message");
}

function statement_bar_show(isshow) {
    if (isshow) {
        statement_bar.show();
    } else {
        agree_checkbox.checked = false;
        statement_bar.hide();
    }
}

function result_bar_show(isshow) {
    if (isshow) {
        result_bar.show();
    } else {
        link_bar.html("");
        result_bar.hide();
    }
}

$(function () {
    getid();
    ok_button.click(function () {
        if (uri_text.val().trim().length == 0) {
            alert("必须输入一个有效的原始链接");
        } else {
            statement_bar_show(true);
        }
    });
    close_button.click(function () {
        statement_bar_show(false);
    });
    get_uri_button.click(function () {
        if (agree_checkbox.checked) {
            var action = uri_form.attr("action");
            var uri_data = uri_form.serialize();
            var type = uri_form.attr("method")
            statement_bar_show(false);
            result_bar_show(true);
            $.ajax({
                type: type,
                url: action,
                data: uri_data,
                success: function (result) {
                    message.html(result.message+"</br>要想重新获取链接，必须重新打开页面，别问为什么，因为懒");
                    file_info.html("文件名:" + result.data.file_name + "</br>文件大小:" + result.data.file_size)
                    var doubleclick_url = result.data.doubleclick_url;
                    var vip_dx_url = result.data.vip_dx_url;
                    var vip_lt_url = result.data.vip_lt_url;
                    var vip_yd_url = result.data.vip_yd_url;
                    var link_bar_html = "";
                    if (doubleclick_url != null) {
                        link_bar_html = link_bar_html + "<li><a href=" + doubleclick_url + ">龟速下载</a></li>"
                    }
                    if (vip_dx_url != null) {
                        link_bar_html = link_bar_html + "<li><a href=" + vip_dx_url + ">电信下载</a></li>"
                    }
                    if (vip_lt_url != null) {
                        link_bar_html = link_bar_html + "<li><a href=" + vip_lt_url + ">联通下载</a></li>"
                    }
                    if (vip_yd_url != null) {
                        link_bar_html = link_bar_html + "<li><a href=" + vip_yd_url + ">移动下载</a></li>"
                    }
                    link_bar.html(link_bar_html);
                },
                error: function (e) {
                    alert("错误代码:" + e.status + "\n发生了严重的错误,可能是你到打开方式不正确，也可能是服务器已驾崩")
                }
            });
        } else {
            alert("必须先同意");
        }
    });
});