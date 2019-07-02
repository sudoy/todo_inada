<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<c:if test="${count == 0}">
<jsp:include page="message.jsp"/>
</c:if>

<table class="table">
	<tr id="first"><th id="head1">#</th>
	<th id="head2">題名</th><th id="head3">重要度</th><th>期限</th></tr>

	<c:forEach items="${form}" var="i">
	<tr>
	<td>${i.number}</td>
	<td><a href="update.html?number=${i.number}">${i.daimei}</a></td>
	<td>${i.juyodoval}</td>
	<td>${i.kigen}</td>
	</tr>
	</c:forEach>

	<tr><td colspan="4" id="ue"><button type="submit" class="btn btn-primary" id="touroku"
	onclick="location.href='entry.html'">追加</button>
	</td></tr>
</table>


</div><!--/container-->

<jsp:include page="shita.jsp"/>

</body>
</html>