<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<div class="alert alert-success alert-dismissible" role="alert">
	<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">
	&times;</span></button>
	<h2><strong>完了しました！</strong></h2>
	<ul>
	 <li>No.27のTodoを更新しました。</li>
	 </ul>
</div>
<c:if test="${error != null}">
<div class="alert alert-danger alert-dismissible" role="alert">
	<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">
	&times;</span></button>
	<h2><strong>エラーが発生しました！</strong></h2>
	<ul>
	<c:forEach items="${error}" var="i">
	<li>${i}</li>
	</c:forEach>
	</ul>
</div>
</c:if>


<h3><strong>登録フォーム</strong></h3>

<form class="form-horizontal" method="POST" action="entry.html">
	<table>

	<tr><th>題名</th>
	<td><input class="form-control" type="text" name="daimei" placeholder="題名"
	value="${form.daimei}"></td></tr>
	<tr><th>詳細</th>
	<td><textarea class="form-control" id="detail" rows="3" name="syosai"
	placeholder="詳細">${form.syosai}</textarea></td>
	</tr>

	<tr><th>重要度</th>
		<td id="radio"><label class="radio-inline">
	<input type="radio" name="juyodoval" value="option1" ${form.radio1}> ★★★
	</label><br>
	<label class="radio-inline">
	<input type="radio" name="juyodoval" value="option2" ${form.radio2}> ★★
	</label><br>
	<label class="radio-inline">
	<input type="radio" name="juyodoval" value="option3" ${form.radio3}> ★
	</label></td>
	</tr>

	<tr><th>期限</th>
		<td><input type="text" class="form-control" id="kigen" name="kigen" placeholder="期限"
		 value="${form.kigen}"></td>
	</tr>
	<tr><th></th>
	<td id="canto">
	<div class="form-group">
		<button type="button" class="btn btn-default" id="cancel"
		 onclick="location.href='index.html'">キャンセル</button>
		<input type="submit" class="btn btn-primary" id="touroku" value="追加">
	</div>
	</td></tr>
	</table>
</form>

</div><!--/container-->

<jsp:include page="shita.jsp"/>

</body>
</html>