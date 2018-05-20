<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TerapEasy</title>
<link rel="stylesheet" type="text/css" href="../../css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../../css/bootstrap-theme.css">
<link rel="stylesheet" type="text/css" href="../../css/styles.css">
</head>
<body class="container">
	<div class="jumbotron" style="background-color: #80b3ff;" align="center">
		<strong>Cadastro de Registro de Pensamento</strong>
	</div>
		<hr />

	<div class="col-md-12">
		<form name="cadastromotorista" method="post"
			action="ControleRegistro?action=cadastrar">

			<label>Situação:</label> 
			<textarea  type="text" name="situacao" class="form-control" rows="4"
			cols="100" placeholder="Digite aqui" maxlength="300" required="required"></textarea><br /> 
			<label>Pensamentos automáticos:</label> 
			<textarea  type="text" name="pensamentos_automaticos" class="form-control" rows="4"
			cols="100" placeholder="Digite aqui" maxlength="300" required="required"></textarea><br /> 
			<label>Emoções:</label> 
			<textarea  type="text" name="emocoes" class="form-control" rows="4"
			cols="100" placeholder="Digite aqui" maxlength="300" required="required"></textarea><br /> 
			<label>Conclusão:</label> 
			<textarea  type="text" name="conclusao" class="form-control" rows="4"
			cols="100" placeholder="Digite aqui" maxlength="300" required="required"></textarea><br /> 
			<label>Resultado:</label> 
			<textarea  type="text" name="resultado" class="form-control" rows="4"
			cols="100" placeholder="Digite aqui" maxlength="300" required="required"></textarea><br /> 
			<a href="listaPensamentos.jsp"><input type="button" value="Cancelar" class="btn btn-default"/></a>
			<input type="submit" value="Cadastrar" class="btn btn-orange"/>
		</form>

	</div>
</body>
</html>