<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:adminTemplate title="Disciplinas cadastradas">
	<jsp:body>
	<div class="container-fluid">
		<jsp:useBean id="disciplina"
				class="br.com.linceit.stella.bean.Disciplina" />
		<table>
           
        </table>
       	<table class="table">
       		
			  <thead>
			    <tr>
			      <th scope="col">CD</th>
			      <th scope="col">Nome</th>
			      <th scope="col">Ações</th>
			    </tr>
			  </thead>
			  <tbody>
				  <c:forEach var="disciplina" items="${disciplinas}">
				    <tr id="${disciplina.cdDisciplina}">
				      <th scope="row">${disciplina.cdDisciplina}</th>
				      <td>${disciplina.nome}</td>
				      
				      <td>
					      <a href="${pageContext.request.contextPath}/admin?action=ListaConteudo&disciplina=${disciplina.nome}&cdDisciplina=${disciplina.cdDisciplina}">
					      		<i class="fas fa-eye"></i>
					      </a>
					      <a href="${pageContext.request.contextPath}/admin?action=DesativarDisciplina&id=${disciplina.cdDisciplina}">
					      		<i class="fas fa-trash"></i>
					      </a>
				      </td>
				    </tr>
	           	  </c:forEach>
			  </tbody>
		</table>
	</div>
    </jsp:body>
</t:adminTemplate>