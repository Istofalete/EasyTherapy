<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Tag libraries -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TherapEasy</title>

<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap-theme.css" />


<script type="text/javascript" src="bootstrap/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>


<!-- Arquivos JavaScript -->
<script type="text/javascript" src="bootstrap/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="bootstrap/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="bootstrap/js/messages_pt_BR.min.js"></script>

<!-- Bloco java script -->
<script type="text/javascript">
	//função inicial do jquery
	$(document).ready(//quando a pagina estiver carregada
	function() {//faça
		//aplicar validação
		$("#formpsicologo").validate();
		$("#formcliente").validate();
	});
</script>
</head>
<body class="container" background="img/preview.jpg">
	<div class="jumbotron">
		<h2 align="center">  TherapEasy</h2>
		<div class=col-md-12>
			<h4 align="center">Por favor, se identifique para continuar</h4>
			<hr />
		</div>
	</div>

	<div class="col-md-12 " align="center">
		<br /> <br /> <br /> <br /> <a href="#" class="btn btn-lg btn-info"
			data-target="#jloginpsicologo" data-toggle="modal"> Login Psicologo
		</a> <a href="#" class="btn btn-lg btn-info" data-target="#jlogincliente"
			data-toggle="modal">Login Cliente
		</a> <br /> <br /> <br />
	</div>

	<br />
	<br />
	
	<div class="col-md-12">
		<br /> <br /> É <strong>Psicologo</strong> e ainda não possui uma
		conta? <a href="#" class="btn btn-block btn-lg btn-info btn-ribbon"
			data-target="#janelacadastropsicologo" data-toggle="modal"> <span
			class="glyphicon glyphicon-list-alt"></span> Cadastre-se
		</a> <br /> <br />
	</div>
	
	<div class="col-md-12">
		<br /> <br /> É <strong>Cliente / Paciente</strong> e ainda não possui uma
		conta? <a href="#" class="btn btn-block btn-lg btn-info btn-ribbon"
			data-target="#janelacadastrocliente" data-toggle="modal"> <span
			class="glyphicon glyphicon-list-alt"></span> Cadastre-se
		</a> <br /> <br />
	</div>

	<!-- Login Psicologo -->
	<div id="jloginpsicologo" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header bg-primary">
					<span class=""></span>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
					</button>
					Login Psicologo
				</div>
				<div class="modal-body">
					<form name="loginpsicologo" id="formpsicologo" method="post"
						action="ControlePsicologo.java?acao=login">
						<label>CRP</label> <input type="text" name="login"
							class="form-control" placeholder="Digite aqui"
							required="required" /> <br /> <label>Senha</label> <input
							type="password" name="senha" class="form-control"
							placeholder="Digite aqui" required="required" /> <br /> <input
							type="submit" value="Entrar" class="btn btn-success" />
					</form>
				</div>
			</div>
		</div>
	</div>


	<!-- Login Cliente -->
	<div id="jlogincliente" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header bg-primary">
					<span class=""></span>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
					</button>
					Login Cliente
				</div>
				<div class="modal-body">
					<form name="logincliente" id="formcliente" method="post"
						action="ControleCliente?action=loginm">
						<label>Email</label> <input type="text" name="login"
							class="form-control" placeholder="Digite aqui"
							required="required" /> <br /> <label>Senha</label> <input
							type="password" name="senha" class="form-control"
							placeholder="Digite aqui" required="required" /> <br /> <input
							type="submit" value="Entrar" class="btn btn-success" />
					</form>
				</div>
			</div>
		</div>
	</div>


	<!-- Cadastro psicologo -->
	<!-- Janela modal -->
	<div id="janelacadastropsicologo" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header bg-primary">
					<span class="glyphicon glyphicon-user"></span>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
					</button>
					Criar Conta de Psicologo
				</div>
				<div class="modal-body">
					Se você é psicologo e deseja se cadastrar, informe os dados a
					seguir:

					<hr />
					<form id="cadastropsicologo" name="cadastropsicologo" method="post"
						action="ControlePsicologo?acao=cadastrar">

						<label>CRP:</label> <input type="text" name="ra"
							class="form-control" placeholder="Digite aqui"
							required="required" /> <br /> <label>Informe seu nome:</label> <input
							type="text" name="nome" class="form-control"
							placeholder="Digite aqui" required="required" /> <br /> <label>Email:</label>
						<input type="text" name="email" class="form-control"
							placeholder="Digite aqui" required="required" /> <br /> <label>Login:</label>
						<input type="text" name="login" class="form-control"
							placeholder="Digite aqui" required="required" /> <br /> <label>Senha:</label>
						<input type="password" name="senha" class="form-control"
							placeholder="Digite aqui" required="required" /> <br /> <label>Confirme
							a senha:</label> <input type="password" name="senhaconfirm"
							class="form-control" placeholder="Digite aqui"
							required="required" /> <br /> <input type="submit"
							value="Confirmar" class="btn btn-success" />


					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- Cadastro cliente -->
	<!-- Janela modal -->
	<div id="janelacadastrocliente" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header bg-primary">
					<span class="glyphicon glyphicon-user"></span>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
					</button>
					Cadastro Cliente
				</div>
				<div class="modal-body">
					Se você é cliente/paciente e deseja se cadastrar, informe os dados
					a seguir:

					<hr />
					<form id="cadastrocliente" name="cadastropsicologo" method="post"
						action="ControleCliente?acao=cadastrar">

						<label>Insira aqui o código fornecido pelo seu psicólogo:</label>
						<input type="text" name="email" class="form-control"
							placeholder="Digite aqui" required="required" /> <br /> <label>Nome:</label>
						<input type="text" name="nome" class="form-control"
							placeholder="Digite aqui" required="required" /> <br /> <label>Email:</label>
						<input type="text" name="email" class="form-control"
							placeholder="Digite aqui" required="required" /> <br /> <label>Login:</label>
						<input type="text" name="login" class="form-control"
							placeholder="Digite aqui" required="required" /> <br /> <label>Senha:</label>
						<input type="password" name="senha" class="form-control"
							placeholder="Digite aqui" required="required" /> <br /> <label>Confirme
							a senha:</label> <input type="password" name="senhaconfirm"
							class="form-control" placeholder="Digite aqui"
							required="required" /> <br /> <input type="submit"
							value="Confirmar" class="btn btn-success" />


					</form>
				</div>
			</div>
		</div>

	</div>
	<div>
		<h5>
			<strong>${mensagem}</strong>
		</h5>
		<br />
	</div>




</body>
</html>