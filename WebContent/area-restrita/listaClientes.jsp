<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TerapEasy</title>


<link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="../css/bootstrap-theme.css" />
<link rel="stylesheet" type="text/css" href="../css/styles.css">
</head>
<body>
	<div class="container">
		<h3>Consulta de Clientes</h3>
		<form>
			<div class="row panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">Filtros</h3>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-sm-3">
							<label>Nome:</label>
							<input class="form-control" type="text" maxlength="120" id="nome" name="nome">
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
		<div class="row panel panel-info">
			<div class="panel-heading">
				<h3 class="panel-title">Clientes</h3>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th class="mid-vert-align">Nome</th>
							<th class="mid-vert-align">CPF</th>
							<th class="mid-vert-align">Ação</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Willian</td>
							<td>38167584364</td>
							<td>
								<button class="btn btn-default" type="button" id="visualizar" name="visualizar" onclick="visualizar()">Visualizar</button>
							</td>
						</tr>
						<tr>
							<td>Ingrid</td>
							<td>19284107741</td>
							<td>
								<button class="btn btn-default" type="button" id="visualizar" name="visualizar" onclick="visualizar()">Visualizar</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="panel-footer"></div>
		</div>
	</div>
</body>
</html>