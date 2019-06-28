<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<jsp:include page="header.jsp"/>

	<title>登録フォーム</title>
	<link href="css/entry.css" rel="stylesheet">
</head>
<body>

<jsp:include page="ue.jsp"/>

<div class="container">

<jsp:include page="message.jsp"/>

<h3><strong>登録フォーム</strong></h3>

<form class="form-horizontal" method="POST" action="entry.html">
	<table>

	<tr><th>題名</th>
	<td><input class="form-control" type="text" name="daimei" placeholder="題名"></td></tr>
	<tr><th>詳細</th>
	<td><textarea class="form-control" id="detail" rows="3" name="syosai" placeholder="詳細"></textarea></td>
	</tr>

	<tr><th>重要度</th>
		<td id="radio"><label class="radio-inline">
	<input type="radio" name="juyodoval" id="inlineRadio1" value="option1" checked> ★★★
	</label><br>
	<label class="radio-inline">
	<input type="radio" name="juyodoval" id="inlineRadio2" value="option2"> ★★
	</label><br>
	<label class="radio-inline">
	<input type="radio" name="juyodoval" id="inlineRadio3" value="option3"> ★
	</label></td>
	</tr>

	<tr><th>期限</th>
		<td><input type="text" class="form-control" id="kigen" name="kigen" placeholder="期限"></td>
	</tr>
	<tr><th></th>
	<td id="canto">
	<div class="form-group">
		<input type="reset" class="btn btn-default" id="cancel" value="キャンセル">
		<input type="submit" class="btn btn-primary" id="touroku" value="追加">
	</div>
	</td></tr>
	</table>
</form>

</div><!--/container-->

<jsp:include page="shita.jsp"/>

</body>
</html>