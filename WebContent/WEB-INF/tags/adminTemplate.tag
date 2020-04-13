<%@tag description="Admin Page Template" pageEncoding="UTF-8"%>
<%@attribute name="title" required="true"%>
<%@attribute name="lastScript" fragment="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stella</title>
<%@ include file="/head.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/style/main.css">
</head>
<body>
	<nav>
		<div class="top-nav-wrapper">
			<div class="logo-container">
				<a href="${pageContext.request.contextPath}/admin/index.jsp"><img src="${pageContext.request.contextPath}/img/STELLA (branco).png" alt=""></a>
			</div>
		</div>
		<div class="clear-fix"></div>
		<ul>
			<li><a href="${pageContext.request.contextPath}/admin/cadastrarDisciplina.jsp"><i class="fa fa-book"></i>Nova Disciplina</a></li>
			<li><a href="${pageContext.request.contextPath}/admin?action=ListaDisciplina"><i class="fa fa-book"></i>Disciplinas</a></li>
			<li><a href="${pageContext.request.contextPath}/admin?action=NovoConteudo"><i class="fa fa-book"></i>Novo conteudo</a></li>
			<li><a href="${pageContext.request.contextPath}/admin?action=CarregarNovaAvaliacao"><i class="fa fa-book"></i>Nova avaliação</a></li>
			<li><a href="${pageContext.request.contextPath}/admin?action=ListaAvaliacao"><i class="fa fa-book"></i>Avaliações</a></li>
			<li class="separator"><span>Bem vindo: ${usuario.nome}</span></li>
			<li><a href="${pageContext.request.contextPath}/login"><i class="fa fa-sign-out-alt"></i>Sair</a></li>
		</ul>
	</nav>
	
	<main>
		<header>
			<div onclick="toggleNav()" class="menu-toggle-container">
				<i class="fa fa-bars fa-3x"></i>
			</div>
			<span>${title}</span>
		</header>
		<section class="content-section">
			<jsp:doBody/>
		</section>
	</main>
	
	<%@ include file="/dependencias.jsp"%>
	
    <jsp:invoke fragment="lastScript"/>
    
	<script>
		function toggleNav() {
			if($("nav").hasClass("collapsed")) {
				$("nav").removeClass("collapsed");
				$("main").removeClass("expanded");
			} else {
				$("nav").addClass("collapsed");
				$("main").addClass("expanded");
			}
		}
	</script>
</body>
</html>
