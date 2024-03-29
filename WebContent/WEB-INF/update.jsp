<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<jsp:include page="header.jsp"/>

	<title>更新フォーム</title>
	<link href="css/update.css" rel="stylesheet">
</head>
<body>

	<jsp:include page="ue.jsp" >
			<jsp:param name="btngroup" value=' '/>
	</jsp:include>

<div class="container">

<jsp:include page="message.jsp"/>

<h3><strong>更新フォーム</strong></h3>

<form class="form-horizontal" method="POST" action="update.html">
	<input type="hidden" name="number" value="${form.number}">
	<table>

	<tr><th>題名</th>
	<td><input class="form-control" name="daimei" type="text" value="${form.daimei}"></td></tr>
	<tr><th>詳細</th>
	<td><textarea class="form-control" name="syosai" rows="3">${form.syosai}</textarea></td>
	</tr>

	<tr><th>重要度</th>
		<td id="radio"><label class="radio-inline">
	<input type="radio" name="juyodoval" id="inlineRadio1" value="option1" ${form.radio1}> ★★★
	</label><br>
	<label class="radio-inline">
	<input type="radio" name="juyodoval" id="inlineRadio2" value="option2" ${form.radio2}> ★★
	</label><br>
	<label class="radio-inline">
	<input type="radio" name="juyodoval" id="inlineRadio3" value="option3" ${form.radio3}> ★
	</label></td>
	</tr>

	<tr><th>期限</th>
		<td><input type="text" class="form-control" name="kigen" value="${form.kigen}"></td>
	</tr>
	<tr><th>ステータス</th>
	<td><label class="radio-inline"><input type="radio" name="status" value="0" ${form.status0}>未完了</label><br>
	<label class="radio-inline"><input type="radio" name="status" value="1" ${form.status1}>完了</label></td>
	</tr>
	<tr><th></th>
	<td id="canto">
	<div class="form-group">
		<a type="button" class="btn btn-default" id="cancel" href="index.html?cancel=cancel">キャンセル</a>
		<input type="submit" class="btn btn-primary" id="kousin" value="更新">
		<a class="btn btn-danger" id="sakujo" href="delete.html?number=${form.number}">削除</a>
	</div>

	</td></tr>

	</table>
</form>

</div><!--/container-->

<jsp:include page="shita.jsp"/>

</body>
</html>