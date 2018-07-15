<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TerapEasy</title>
<link rel="stylesheet" type="text/css" href="../../bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="../../bootstrap/css/bootstrap-theme.css">
<link rel="stylesheet" type="text/css" href="../../bootstrap/css/styles.css">
</head>
<body class="container">
	<div class="jumbotron" style="background-color: #80b3ff;"
		align="center">
		<strong>Editar de Registro de Pensamento</strong>
	</div>
	<hr />

	<div class="col-md-12">
		<form name="formmotorista" method="post"
			action="ControleRegistro?action=atualizar">

			<div class="row">
				<div class="col-sm-4">
					<label>Código:</label>
					<input type="text" name="id" class="form-control" disabled value="${motorista.id}">
				</div>
				<div class="col-sm-4">
					<label>Cliente:</label>
					<input type="text" name="cliente" class="form-control" disabled value="${motorista.cliente.nome}">
				</div>
				<div class="col-sm-4">
					<label>Data:</label>
					<input type="text" name="data" class="form-control" disabled value="${motorista.data}">
				</div>
			</div>
			<label>Situação:</label>
			<textarea type="text" name="situacao" class="form-control" rows="4"
				cols="100" value="${motorista.situacao}" maxlength="300"
				required="required"></textarea>
			<br /> <label>Pensamentos automáticos:</label>
			<textarea type="text" name="pensamentos_automaticos"
				class="form-control" rows="4" cols="100"
				value="${motorista.pensamentos_automaticos}" maxlength="300"
				required="required"></textarea>
			<br /> <label>Emoções:</label>
			<textarea type="text" name="emocoes" class="form-control" rows="4"
				cols="100" value="${motorista.emocoes}" maxlength="300"
				required="required"></textarea>
			<br /> <label>Conclusão:</label>
			<textarea type="text" name="conclusao" class="form-control" rows="4"
				cols="100" value="${motorista.conclusao}" maxlength="300"
				required="required"></textarea>
			<br /> <label>Resultado:</label>
			<textarea type="text" name="resultado" class="form-control" rows="4"
				cols="100" value="${motorista.resultado}" maxlength="300"
				required="required"></textarea>
			<br /> <a href="listaPensamentos.jsp"><input type="button"
				value="Cancelar" class="btn btn-default" /></a> <input type="submit"
				value="Salvar" class="btn btn-orange" />
		</form>

	</div>
</body>
</html>