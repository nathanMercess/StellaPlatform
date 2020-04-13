<%@tag description="Aluno Page Template" pageEncoding="UTF-8"%>
<%@attribute name="lastScript" fragment="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stella</title>
<%@ include file="/head.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/aluno/style/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/aluno/style/bot.css" />
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet"> 
<script src="${pageContext.request.contextPath}/aluno/scripts/aluno.js"></script>
</head>
<body>
	<nav class="menu">
		<ul class="nav justify-content-end ancora">
			<li class="nav-item"><a href="${pageContext.request.contextPath}/aluno?action=Dashboard"><img
					src="${pageContext.request.contextPath}/img/STELLA (branco).png" class="iconLogo" alt=""></a></li>
			
			<!-- <li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle active tada" href="#"
				id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false"> Português </a>

				<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					<a class="dropdown-item" href="conteudo.jsp">Capitulo 1 -
						Artigo</a> <a class="dropdown-item" href="#">Capitulo 2 -
						Substantivo</a> <a class="dropdown-item" href="">Capitulo 3 -
						Adjetivo</a>
				</div></li>
			-->
			<!--<li class="nav-item"><a class="nav-link active tada "
				href="${pageContext.request.contextPath}/aluno/avaliacoes.jsp"><i class="fas fa-book"></i> Avaliações</a></li>
			  <li class="nav-item"><a class="nav-link active tada "
				href="${pageContext.request.contextPath}/aluno/resumoAtividades.jsp" ><i class="fas fa-pen"></i> Resumo de Atividades</a></li>-->
			<li class="nav-item"><a class="nav-link active tada " href="${pageContext.request.contextPath}/login"><i class="fas fa-sign-in-alt"></i> Sair</a></li>
		</ul>
	</nav>
	<div class="clear-fix"></div>
	<main>
		<jsp:doBody/>
	</main>
	<%@ include file="/dependencias.jsp"%>
	
	<jsp:invoke fragment="lastScript"/>
</body>
</html>
