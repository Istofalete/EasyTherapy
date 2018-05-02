<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TerapEasy</title>

<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap-theme.css">
<link rel="stylesheet" type="text/css" href="../css/styles.css">
</head>
<body>
	<div class="container">
		<h3>Pensamentos</h3>
		<form>
			<div class="row panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">Filtros</h3>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-sm-3">
							<label>Data:</label>
							<input class="form-control" type="text" maxlength="10" id="data" name="data">
						</div>
					</div>
				</div>
				<div class="panel-footer">
					<div class="row">
						<div class="col-sm-12">
							<button type="submit" class="btn btn-default" onclick="pesquisar()">Pesquisar</button>
						</div>
					</div>
				</div>
			</div>
		</form>
		<div class="row panel panel-default" style="width: 80%; margin:auto;">
			<div class="panel-body">
				<div class="row">
					<div class="col-sm-3">
						<label>Data:</label>
						14/04/2018
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4">
						<label>Situação:</label>
					</div>
					<div class="col-sm-4">
						<label>Pensamentos Automáticos:</label>
					</div>
					<div class="col-sm-4">
						<label>Emoção:</label>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6">
						<label>Conclusão:</label>
					</div>
					<div class="col-sm-6">
						<label>Resultado:</label>
					</div>
				</div>
			</div>
			<div class="panel-footer">
				<div class="row">
					<div class="col-sm-12">
						<button type="submit" class="btn btn-default" onclick="visualizar()">Visualizar</button>
						<button type="submit" class="btn btn-default" onclick="excluir()">Excluir</button>
					</div>
				</div>
			</div>
		</div><br>
		<div class="row panel panel-default" style="width: 80%; margin:auto;">
			<div class="panel-body">
				<div class="row">
					<div class="col-sm-3">
						<label>Data:</label>
						14/04/2018
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4">
						<label>Situação:</label>
					</div>
					<div class="col-sm-4">
						<label>Pensamentos Automáticos:</label>
					</div>
					<div class="col-sm-4">
						<label>Emoção:</label>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6">
						<label>Conclusão:</label>
					</div>
					<div class="col-sm-6">
						<label>Resultado:</label>
					</div>
				</div>
			</div>
			<div class="panel-footer">
				<div class="row">
					<div class="col-sm-12">
						<button type="submit" class="btn btn-default" onclick="visualizar()">Visualizar</button>
						<button type="submit" class="btn btn-default" onclick="excluir()">Excluir</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>