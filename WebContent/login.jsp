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
	 $("form").submit(function(){
	        $("#jloginpsicologo").empty();
	 }
	 );
	 
	
	
	function callServlet() {
		debugger();
		 document.forms[0].action = "ControlePsicologo?acao=login";
		     document.forms[0].submit();
		    
		     var msg = $("mensagem").value;


		        if(msg!=""){

		               alert(msg);

		        }else{
		        	alert('passei aq');
		        }
		     
		     }


	function ValidaLogin(){

        var msg = $("mensagem").value;


        if(msg!=""){

               alert(msg);

        }else{
        	alert('passei aq');
        }

       }
</script>
</head>
<body class="container" background="img/preview.jpg">



	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<a class="navbar-brand" href="#">TherapEasy</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarColor01" aria-controls="navbarColor01"
			aria-expanded="false" aria-label="Toggle navigation" style="">
			<span class="navbar-toggler-icon"></span>
		</button>

	</nav>
	<div class="jumbotron">
		<div class=col-md-12>
			<h4 align="center">Por favor, se identifique para continuar</h4>
			<hr />
		</div>
	</div>

	<div class="col-md-12 " align="center">
		<br /> <br /> <br /> <br /> <a href="#"
			class="btn btn-lg btn-primary" data-target="#jloginpsicologo"
			data-toggle="modal"> Login Psicologo </a> <a href="#"
			class="btn btn-lg btn-primary" data-target="#jlogincliente"
			data-toggle="modal">Login Cliente </a> <br /> <br /> <br />
	</div>
	
	<div class="col-md-12 " align="center">
				<strong>${mensagem}</strong>
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
		<br /> <br /> É <strong>Cliente / Paciente</strong> e ainda não
		possui uma conta? <a href="#"
			class="btn btn-block btn-lg btn-info btn-ribbon"
			data-target="#janelacadastrocliente" data-toggle="modal"> <span
			class="glyphicon glyphicon-list-alt"></span> Cadastre-se
		</a> <br /> <br />
	</div>

	<!-- Login Psicologo -->
	<div id="jloginpsicologo" class="modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header bg-primary">
					<h5 class="modal-title">Login Psicólogo</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form name="loginpsicologo" id="formpsicologo" method="post"
						action="ControlePsicologo?acao=login">
						<label>CRP</label> <input type="text" name="crp"
							class="form-control" placeholder="Digite aqui"
							required="required" /> <br /> <label>Senha</label> <input
							type="password" name="senha" class="form-control"
							placeholder="Digite aqui" required="required" /> <br /> <input
							type="submit" value="Entrar" class="btn btn-success"  />
					</form>
				</div>
			</div>
		</div>
	</div>


	<!-- Login Cliente -->
	<div id="jlogincliente" class="modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header bg-primary">
					<h5 class="modal-title">Login Cliente</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form name="logincliente" id="formcliente" method="post"
						action="ControleCliente?action=login">
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
	<div id="janelacadastropsicologo" class="modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header bg-primary">
					<h5 class="modal-title">Criar conta Psicólogo</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					Se você é psicólogo e deseja se cadastrar, informe os dados a
					seguir:

					<hr />
					<form id="cadastropsicologo" name="cadastropsicologo" method="post"
						action="ControlePsicologo?acao=cadastrar">

						<label>CRP:</label> <input type="text" name="ra"
							class="form-control" placeholder="Digite aqui"
							required="required" /> <br /> <label>Informe seu nome:</label>
						<input type="text" name="nome" class="form-control"
							placeholder="Digite aqui" required="required" /> <br /> 
							<label>Email:</label>
						<input type="text" name="email" class="form-control"
							placeholder="Digite aqui" required="required" /> <br /> 
							<label>Login:</label>
						<input type="text" name="login" class="form-control"
							placeholder="Digite aqui" required="required" /> <br /> 
							<label>Senha:</label>
						<input type="password" name="senha" class="form-control"
							placeholder="Digite aqui" required="required" /> <br /> 
							<label>Confirme a senha:</label> <input type="password" name="senhaconfirm"
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
	<div id="janelacadastrocliente" class="modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header bg-primary">
					<h5 class="modal-title">Criar conta Cliente</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
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
</body>
</html>