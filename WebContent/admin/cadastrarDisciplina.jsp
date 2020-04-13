<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:adminTemplate title="Cadastrar disciplina">
	<jsp:body>
	<div class="container-fluid">
		<h4>Dados da disciplina</h4>
       	<form action="${pageContext.request.contextPath}/admin?action=CadastraDisciplina" method="post">
		  <div class="form-group">
		    <label for="inputNomeDisciplina">Nome disciplina</label>
		    <input name="nomeDisciplina" type="text" class="form-control" id="inputNomeDisciplina"
						placeholder="Entre com o nome da disciplina">
		  </div>
		 
		<h4>Primeiro capitulo</h4>
		<div class="form-group">
			<label for="inputPrimeiroCapitulo">Titulo</label>
			<input name="nomePrimeiroCapitulo" type="text" class="form-control" id="inputPrimeiroCapitulo"/>
		</div>
		<div class="form-group">
			<textarea name="conteudoCapitulo" class="form-control" name="message" rows="10" cols="30"></textarea>
		</div>
		<button type="submit" class="btn btn-primary">Salvar</button>
		</form>
	</div>
    </jsp:body>
</t:adminTemplate>