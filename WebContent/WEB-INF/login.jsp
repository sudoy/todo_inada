<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />

<title>ログイン</title>
<link href="css/login.css" rel="stylesheet">
</head>
<body>

	<jsp:include page="ue.jsp" />

	<!-- Modal -->

		<div class="modal" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabel">ログイン</h4>
					</div>
					<div class="modal-body">

					<form class="form-inline text-center" method="POST" action="login.html">
					<jsp:include page="message.jsp"/>
						<div class="form-group">
							<div class="mail">メールアドレス</div>
							<div class="pass">パスワード</div>

						</div>
						<div class="form-group">
							<div class="col-sm-10">
								<input type="email" class="form-control" name="mail" placeholder="メールアドレス"
								value="${logNameMail.mail}">
							</div>
							<div class="col-sm-10">
								<input type="password" class="form-control" name="pass" placeholder="パスワード">
							</div>
						</div>

						<button type="submit" class="btn btn-primary">
						<span class="glyphicon glyphicon-off" aria-hidden="true"></span> ログイン</button>
					</form>

					</div>
				</div>
			</div>
		</div>

<script src="js/jquery-3.4.1.min.js"></script>
<script>
	$(window).on('load',function(){
	    $('#myModal').modal('show');
	});
</script>
	<jsp:include page="shita.jsp" />

</body>
</html>