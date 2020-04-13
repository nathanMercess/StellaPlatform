<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:alunoTemplate>
	<jsp:body>
	<style>
		.bot-container {
			width: 320px;
			position: fixed;
			right: 15px;
			bottom: 0;
		}
		
		#toggleButton {
			float: right;
			margin-right: 5px;
			margin-bottom: 5px;
			margin-top: 5px;
			background: #ED145B;
			font-size: 16px;
			color: #fff;
			padding: 10px 20px;
			border: 0;
			border-bottom: 2px #AD0F43 solid;
			border-radius: 50px !important;
			text-shadow: 0.05em 0.05em black;
			width: 70px;
			height: 70px;
		}
		
		.bot-wrapper {
			height: auto;
		}
		
		.bot-wrapper:hidden {
			height: 0px;
		}
	</style>
	<div class="jumbotron jumbotron-fluid">
			  <div class="container">
			    <h1 class="display-4">
							<span>${tituloConteudo}</span>
						</h1>
			    <p class="lead"></p>
			  </div>
		</div>
	<div class="container">
		<section style="margin-top:25px;">
			<div>${conteudo}</div>
		</section>
	</div>
	<div class="bot-container">
		<div hidden="true" class="bot-wrapper">
					<%@ include file="bot.jsp"%>
				</div>
				
				<!-- <button style="width: 100%;" onclick="toggleBot();">STELLA</button>  -->
				<button id="toggleButton" type="button"
				class="btn btn-warning btn-circle btn-xl" onclick="toggleBot();">
						<i class="fas fa-comments"></i>
				</button>
	</div>
	<script>
		function toggleBot() {
			var botElement = document.querySelector(".bot-wrapper");
			if (botElement.hidden) {
				botElement.hidden = false;
			} else {
				botElement.hidden = true;
			}
		}
		
		let closeBotBtn = document.getElementById("closeBot");
		closeBotBtn.addEventListener("click", function() {
			toggleBot();
		})
	</script>
    </jsp:body>
</t:alunoTemplate>
</html>