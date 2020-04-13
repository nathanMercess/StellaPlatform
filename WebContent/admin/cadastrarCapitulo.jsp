<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:adminTemplate title="Novo conteudo">
	<jsp:body>
	<div class="container-fluid">
		<h4>Disciplina</h4>
       	<form action="${pageContext.request.contextPath}/admin?action=CadastraConteudo" method="post">
		  <div class="form-group">
		    <select  class="form-control" name="cdDisciplina">
		        <c:forEach items="${disciplinas}" var="d">
		            <option value="${d.cdDisciplina}">${d.nome}</option>
		        </c:forEach>
    		</select>
		  </div>
		<h4>Conteudo</h4>
		<div class="form-group">
			<label for="inputNomeCapitulo">Titulo</label>
			<input name="nomeCapitulo" type="text" class="form-control"
						id="inputNomeCapitulo" />
		</div>
		<div class="form-group">
			<textarea name="conteudoCapitulo" class="form-control" name="message"
						rows="10" cols="30"></textarea>
		</div>
		<button type="submit" class="btn btn-primary">Salvar</button>
		</form>
	</div>
    </jsp:body>
</t:adminTemplate>