<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stella</title>
<%@ include file="head.jsp"%>
<link rel="stylesheet" href="style/style.css">
<script src="scripts/index.js"></script>
</head>
<body>
	<div class="parallax div1" id="Inicio" data-divisor="2">
		<%@include file="menu.jsp"%>

		<div class="titulo boxText">
			<div class="text">Curso de Nivelamento Português</div>
			<h3>Com a Stella você aprende mais rapido ;)</h3>
			<div class="boxBtn ancora">
				<a class="buttonN btnLogin" href="cadastro.jsp"><strong>Cadastre-se</strong></a>
				<a class="buttonN btnPadrao" href="Conteudo.html"><strong>Aprender</strong></a>
			</div>
			<!-- <img class="arrowIcon" src="img/arrow.png" alt=""> -->
		</div>
	</div>

	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalCenterTitle">Aprenda
						Português de forma interativa !</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="login" method="post">
						<span>${erro}</span>
						<div class="form-group">
							<label for="exampleInputEmail1">Email</label> <input type="email"
								class="input-form" id="exampleInputEmail1"
								aria-describedby="emailHelp" name="email"
								placeholder="Entre com seu email"> <small id="emailHelp"
								class="form-text text-muted">Nunca compartilhe seus
								dados de acesso</small>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Senha</label> <input
								type="password" class="input-form" name="senha"
								id="exampleInputPassword1" placeholder="Entre com sua senha">
						</div>

						<div class="modal-footer">
							<input type="submit" class="btn btnC btnPadrao submit"
								value="Logar" />
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>


	<div class="qualquer_coisa_package" id="Materia">
		<div class="container">
			<br>
			<h2 id="tituloSection">.Conheça Nossos Pacotes !</h2>
			<div class="row">
				<div class="col-sm-5">
					<div class="card card-package" style="width: 22rem;">
						<img class="card-img-top-package" src="img/basic.png"
							alt="Imagem de capa do card">
						<div class="card-body">
							<h5 class="card-title packageDescription">Basic Package</h5>
							<h1 class="card-text packageDescription">R$ 15/mês</h1>
							<ul>
								<li>
									<p>
										<img src="img/tick.png" class="checks-package" alt="">
										acesso ao conteudo
									</p>
								</li>
								<li>
									<p>
										<img src="img/close.png" class="checks-package" alt="">
										acesso as provas
									</p>
								</li>
								<li>
									<p>
										<img src="img/close.png" class="checks-package" alt="">
										acesso a correções das provas
									</p>
								</li>
							</ul>
							<a href="#" class="btn btnC btnPadrao"
								style="position: relative; left: 25%;">Matricule-se </a>
						</div>
					</div>
				</div>
				<div class="col-sm-5">
					<div class="card card-package" style="width: 22rem;">
						<img class="card-img-top-package" src="img/premium.png"
							alt="Imagem de capa do card">
						<div class="card-body">
							<h5 class="card-title packageDescription">Premium Package</h5>
							<h1 class="card-text packageDescription" style="color: yellow">R$
								25/mês</h1>
							<ul>
								<li>
									<p>
										<img src="img/tick.png" class="checks-package" alt="">
										acesso ao conteudo
									</p>
								</li>
								<li>
									<p>
										<img src="img/tick.png" class="checks-package" alt="">
										acesso as provas
									</p>
								</li>
								<li>
									<p>
										<img src="img/tick.png" class="checks-package" alt="">
										acesso a correções das provas
									</p>
								</li>
							</ul>
							<a href="#" class="btn btnC btnPadrao"
								style="position: relative; left: 25%;">Matricule-se </a>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
	<br>
	<div class="parallax div2" id="ChatBot" data-divisor="4">
		<section id="Stella">
			<div class="card c1" style="width: 26rem;">
				<div class="card-body">
					<h3 class="card-title">Ainda esta com duvidas ?</h3>
					<h5 class="card-subtitle mb-2 text-muted">Conheça a Stella !</h5>
					<p class="card-text">Um chat bot integrado que irá auxiliá-lo durante a visita de nossos conteúdos.</p>
					<a href="#" class="card-link">Tire suas Duvidas</a>
				</div>
			</div>
			<div class="col-md-4">
				<img src="img/cell.png" class="card-img" alt="...">
			</div>
		</section>
	</div>
	<div class="qualquer_coisa" id="Sobrenos"
		style="background-color: rgb(60, 65, 77);">
		<h2 id="tituloSection">.Sobre Nós</h2>
		<p>Somos equipe Lince IT, Stella é um projeto challenge que
			fizemos esse ano 2019 com patrocínio de IBM. Stella é uma chatbot que
			irá ajudar os estudantes ou qualquer outra pessoa que precise
			aprender Português, ela pode responder as perguntas e tirar dúvidas do
			aluno durante o tempo em que acessa o conteúdo de Português no
			nosso site.</p>
	</div>
	<!-- 
	<div class="parallax div3" data-divisor="3">
		<h2 id="tituloSectionEquipe" class="tituloContato">.Nossa Equipe</h2>
		<div class="row">
			<div class="col-sm-3">
				<div class="cardP1 card">
					<img src="img/cell.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Special title treatment</h5>
						<p class="card-text">With supporting text below as a natural
							lead-in to additional content.</p>
						<a href="#" class="btn btnPadrao btnC">Go somewhere</a>
					</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="card cardP2">
					<img src="img/cell.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Special title treatment</h5>
						<p class="card-text">With supporting text below as a natural
							lead-in to additional content.</p>
						<a href="#" class="btn btnPadrao btnC">Go somewhere</a>
					</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="card cardP3">
					<img src="img/cell.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Special title treatment</h5>
						<p class="card-text">With supporting text below as a natural
							lead-in to additional content.</p>
						<a href="#" class="btn btnPadrao btnC">Go somewhere</a>
					</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="card cardP4">
					<img src="img/cell.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Special title treatment</h5>
						<p class="card-text">With supporting text below as a natural
							lead-in to additional content.</p>
						<a href="#" class="btn btnPadrao btnC">Go somewhere</a>
					</div>
				</div>
			</div>
		</div>
	</div>
 -->
	<div class="qualquer_coisa">
		<h2 id="tituloSection" class="tituloContato">.Contato</h2>
		<div class="card cardPositionDuvida" style="width: 24rem;">
			<div class="card-body">
				<h5 class="card-title">Mande sua duvida</h5>
				<h6 class="card-subtitle mb-2 text-muted">Nossa equipe te
					ajudará o mais rapido possivel</h6>
				<p class="card-text">Some quick example text to build on the
					card title and make up the bulk of the card's content.</p>

			</div>
		</div>
		<form id="Contato2" class="formulario col-md-7">
			<div class="form-group">
				<label for="exampleFormControlInput1" class="corLabel"><strong>Nome</strong></label>
				<input type="text" class="input-form" id="exampleFormControlInput1"
					placeholder="Seu nome aqui">
			</div>
			<div class="form-group">
				<label for="exampleFormControlInput2" class="corLabel"><strong>Email</strong></label>
				<input type="email" class="input-form" id="exampleFormControlInput2"
					placeholder="name@example.com">
			</div>

			<div class="form-group">
				<label for="exampleFormControlTextarea1" class="corLabel"><strong>Descreva
						sua duvida</strong></label>
				<textarea class="input-form" id="exampleFormControlTextarea1"
					rows="3" style="resize: none"></textarea>
			</div>
			<button type="submit" class="btn btnC btnPadrao">
				<strong>Enviar</strong>
			</button>
		</form>


	</div>

	<%@ include file="rodape.jsp"%>
	<%@ include file="dependencias.jsp"%>
</body>
</html>