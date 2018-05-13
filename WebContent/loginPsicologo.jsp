<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TerapEasy</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css" />
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-2">
				<a href="index.jsp"><button class="btn btn-default" type="button">Voltar</button></a>
			</div>
		</div><br>
		<form action="">
			<div class="row panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">Seja bem vindo!</h3>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-sm-10 col-sm-offset-1">
							<label>CRP:</label> <input class="form-control" type="text"
								id="crp" name="crp">
						</div>
					</div>
					<div class="row">
						<div class="col-sm-10 col-sm-offset-1">
							<label>Senha:</label> <input class="form-control" type="password"
								id="senha" name="senha">
						</div>
					</div>
				</div>
				<div class="panel-footer">
					<div class="row">
						<div class="col-sm-2 col-sm-offset-4">
							<button class="btn btn-default" type="button">Login</button>
						</div>
						<div class="col-sm-2">
							<a href=""><button class="btn btn-default" type="button">Inscrever-se</button></a>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
