<%@ page language="java" pageEncoding="UTF-8"%>

<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<h1>Todoリスト</h1>
		</div>
		<div class="barright">
			<%=request.getParameter("btngroup")%>

			<form class="navbar-form navbar-left">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="検索">
				</div>
				<button type="submit" class="btn btn-default">検索</button>
			</form>

			<!-- Single button -->
			<form class="navbar-form navbar-left" method="GET"
				action="logout.html">
				<div class="btn-group">
					<button type="button" class="btn btn-info dropdown-toggle"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						${sessionScope.name} <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li><a href="logout.html">ログアウト</a></li>

					</ul>
				</div>
			</form>
		</div>

	</div>
	<!-- /.container-fluid -->
</nav>