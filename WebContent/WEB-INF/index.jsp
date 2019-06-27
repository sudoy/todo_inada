<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<jsp:include page="header.jsp"/>

	<title>index</title>
	<link href="css/index.css" rel="stylesheet">
</head>
<body>

<jsp:include page="ue.jsp"/>

<div class="container">

<jsp:include page="message.jsp"/>

<table class="table">
	<tr id="first"><th id="head1">#</th>
	<th id="head2">題名</th><th id="head3">重要度</th><th>期限</th></tr>
	<tr><td>1
	</td><td><a href="update.html">テストテスト</a></td><td>★★★</td>
	<td>2015/06/20</td></tr>
	<tr><td>2
	</td><td><a href="update.html">テストテスト</a></td><td>★</td>
	<td>2015/06/22</td></tr>
	<tr><td>3
	</td><td><a href="update.html">テストテスト</a></td><td>★★★</td>
	<td>2015/06/20</td></tr>
	<tr><td>4
	</td><td><a href="update.html">テストテスト</a></td><td>★★</td>
	<td></td></tr>
	<tr><td colspan="4" id="ue"><button type="submit" class="btn btn-primary" id="touroku"
	onclick="location.href='entry.html'">追加</button>
	</td></tr>
</table>

</div><!--/container-->

<jsp:include page="shita.jsp"/>

</body>
</html>