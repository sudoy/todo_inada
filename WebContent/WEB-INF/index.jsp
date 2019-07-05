<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<jsp:include page="header.jsp" />

<title>index</title>
<link href="css/index.css" rel="stylesheet">
</head>
<body>

	<jsp:include page="ue.jsp" >
			<jsp:param name="btngroup" value='
			<form class="navbar-form navbar-left" method="POST" action="index.html">
			<div class="btn-group" role="group" aria-label="...">
			<button type="submit" class="btn btn-warning" name="hyoji" value="mikan">
			<span class="glyphicon glyphicon-repeat" aria-hidden="true"></span>
			未完了のみ</button>
			<button type="submit" class="btn btn-warning" name="hyoji" value="all">
			<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>
			全て</button>
			</div></form>'/>
	</jsp:include>

	<div class="container">
	<form method="POST" action="index.html">

		<div class="kanryotsuika">

			<button type="submit" class="btn btn-success" id="kanryo">
				<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>完了
			</button>
			<a type="button" class="btn btn-primary" id="tsuika" href='entry.html'>
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>追加
			</a>
		</div>

		<jsp:include page="message.jsp" />

		<table class="table">
			<tr id="first">
				<th id="head1">#</th>
				<th id="head2">題名</th>
				<th id="head3">重要度</th>
				<th>期限</th>
			</tr>

			<c:forEach items="${form}" var="i">
				<tr>
					<td><input type="checkbox" name="status" value="${i.number}"
					<c:if test="${i.status == '1'}">checked</c:if>></td>

					<td><a href="update.html?number=${i.number}">${i.daimei}</a></td>
					<td>${i.juyodoval}</td>
					<td>${i.kigen}</td>
				</tr>
			</c:forEach>

		</table>
		</form>

		<nav aria-label="..." class="page">
			<ul class="pagination">
				<li class="disabled"><a href="#" aria-label="Previous"><span
						aria-hidden="true">&laquo;</span></a></li>
				<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>

				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>

			</ul>
		</nav>

	</div>

	<!--/container-->

	<jsp:include page="shita.jsp" />

</body>
</html>