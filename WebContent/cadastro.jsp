<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagina de Cadastro</title>
<%@ include file="head.jsp"%>
<link rel="stylesheet" href="style/cadastroStyle.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
  	<nav class="menu">
		<ul class="nav justify-content-end ancora">

			<li class="nav-item"><img src="img/STELLA (branco).png"
				class="iconLogo" alt=""></li>
			<li class="nav-item"><a class="nav-link active tada "
				href="index.jsp"><i class="fas fa-home"></i> Inicio</a></li>
		</ul>
	</nav>
   <h1 class="tituloCadastro">Cadastre-se aqui !</h1>
      <form  class="formCadastro" action="cadastro" method="post">
	    <div class="form-row">
	      <div class="form-group col-md-12">
	        <label for="inputNome" class="corLabel">Nome completo</label>
	        <input type="text" class="form-control input-form" name="nome" id="inputNome" placeholder="Nome">
	      </div>
	      <div class="form-group col-md-6">
	        <label for="inputEmail" class="corLabel">Email</label>
	        <input type="email" class="form-control input-form" name="email" id="inputEmail" placeholder="Email">
	      </div>
	      <div class="form-group col-md-6">
	        <label for="inputSenha" class="corLabel">Senha</label>
	        <input type="password" class="form-control input-form" name="senha" id="inputSenha" placeholder="Senha">
	      </div>
	      <div class="form-group col-md-6">
	        <label for="inputData" class="corLabel">Data Nascimento</label>
	        <input type="date" class="form-control input-form" name="data" id="inputData" placeholder="Data Nascimento">
	      </div>
	      <div class="form-group col-md-6">
	        <label for="inputTelefone" class="corLabel">Telefone</label>
	        <input type="text" class="form-control input-form" name="telefone" id="inputNumeroTelefone" placeholder="Telefone">
	      </div>
	    </div>
	    <div class="form-group">
	      <label for="inputAddress" class="corLabel">Endereço</label>
	      <input type="text" class="form-control input-form" name="endereco" id="inputAddress" placeholder="Rua da Salvação, nº 0 , São Paulo , SP">
	    </div>
	    <button class="btnPadrao">Salvar</button>
    </form>
</body>
</html>