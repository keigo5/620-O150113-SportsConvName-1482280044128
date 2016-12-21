//エラーメッセージ
var SERCHED_ERR_MSG = "データベース内に「{0}」の情報がありませんでした。"
var REQUIRED_ERR_MSG = "検索する文字を入力してください。"

$(function() {
	$("#button").click(function() {
		//入力キーワードに対して左右のトリムを行う
		var keyword = jQuery.trim($("#keyword").val());
		$("#keyword").val(keyword);

		if(keyword == ""){
			$("#result").hide();
			$(".err_msg_place").html(REQUIRED_ERR_MSG);
			$(".err_msg_place").show();
			return false;
		}

		var JSONdata = {
			keyword : keyword
		};

		$.ajax({
			type : 'post',
			data : JSONdata,
			dataType : 'JSON',
			success : function(data) {
				if(data.sportsKana != null){
					$(".err_msg_place").hide();
					$("#result").show();
					$("#sportsKana").html(data.sportsKana);
					$("#sportsKanji").html(data.sportsKanji);
					$("#sportsPlayers").html(data.sportsPlayers + "人");
				} else {
					$("#result").hide();
					$(".err_msg_place").html(SERCHED_ERR_MSG.replace(/\{0\}/g, keyword));
					$(".err_msg_place").show();
				}
			},
			error : function(data) {
				alert("error");
			}
		});

	});
});
