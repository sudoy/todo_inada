<%@ page language="java" pageEncoding="UTF-8"%>

<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<h1>Todoリスト</h1>
		</div>

		<!-- Single button -->
		 <form class="navbar-form navbar-right" method="GET" action="logout.html">
		<div class="btn-group">
			<button type="button" class="btn btn-info dropdown-toggle"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				Action <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a href="logout.html">ログアウト</a></li>

			</ul>
		</div>
		</form>

	</div>
	<!-- /.container-fluid -->
</nav>