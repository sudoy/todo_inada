<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<jsp:include page="header.jsp"/>

	<title>更新フォーム</title>
	<link href="css/update.css" rel="stylesheet">
</head>
<body>

<jsp:include page="ue.jsp"/>

<div class="container">

<jsp:include page="message.jsp"/>

<h3><strong>更新フォーム</strong></h3>

<form class="form-horizontal" method="GET" action="index.html">
	<table>

	<tr><th>題名</th>
	<td><input class="form-control" type="text" value="${form.daimei}"></td></tr>
	<tr><th>詳細</th>
	<td><textarea class="form-control" id="biko" rows="3">${form.syosai}</textarea></td>
	</tr>

	<tr><th>重要度</th>
		<td id="radio"><label class="radio-inline">
	<input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1" checked> ★★★
	</label><br>
	<label class="radio-inline">
	<input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2"> ★★
	</label><br>
	<label class="radio-inline">
	<input type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option3"> ★
	</label></td>
	</tr>

	<tr><th>期限</th>
		<td><input type="text" class="form-control" id="kigen" value="${form.kigen}"></td>
	</tr>
	<tr><th></th>
	<td id="canto">
	<div class="form-group">
		<button type="submit" class="btn btn-default" id="cancel"
		 onclick="location.href='index.html'">キャンセル</button>
		<input type="submit" class="btn btn-primary" id="kousin" value="更新"
		onclick="location.href='index.html'">
			<input type="submit" class="btn btn-danger" id="sakujo" value="削除"
		onclick="location.href='index.html'">
	</div>

	</td></tr>
	</table>
</form>

</div><!--/container-->

<jsp:include page="shita.jsp"/>

</body>
</html>