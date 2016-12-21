<%@page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>スポーツ名漢字検索くん</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Bootstrap -->
	<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="css/bootstrap-responsive.css" rel="stylesheet">
	<link href="css/bootstrap.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
	<script src="js/jquery.js"></script>
	<script src="js/util.js"></script>
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<div class="nav-collapse collapse"></div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="hero-unit">
			<div>
				<h2 class="text-center">スポーツ名漢字検索くん</h2>
			</div>
			<br />
			<% //検索文字入力欄 %>
			<div>
				<p>
					使い方：検索したいスポーツ名をカタカナで入力し、検索ボタンを押して下さい。<br />
					検索するスポーツ: <input type="text" id="keyword" size="30" value="">
					<button id="button" type="button"
						style="vertical-align: 5px; margin-left: 5px;">検索</button>
				</p>
			</div>

			<% //検索結果表示用 %>
			<div style="margin-top: 30px; display: none;" id="result">
				<h3 class="text-center">検索結果</h3>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>カタカナ名</th>
							<th>日本語名</th>
							<th>人数</th>
						</tr>
					</thead>
					<tbody>
						<tr class="success">
							<td id="sportsKana"></td>
							<td id="sportsKanji"></td>
							<td id="sportsPlayers"></td>
						</tr>
					</tbody>
				</table>
			</div>

			<% //エラーメッセージ表示用 %>
			<h3 class="text-center label-warning err_msg_place" style="display: none"></h3>

		</div>
		<!-- end of the hero-unit-->
	</div>
	<!-- end of the container-->
</body>
</html>
