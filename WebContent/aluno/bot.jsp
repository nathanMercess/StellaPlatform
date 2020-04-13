<section class="container-bot">
	<div class="top-bar">
		<img src="${pageContext.request.contextPath}/img/Stella.png"
			class="profile-pic left" />
		
		<h5 style="float:left;margin-top:12px;color:#fff;">Stella Chat Bot</h5>
		
		<span id="closeBot"  class="close"
			data-dismiss="modal" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</span>
	</div>
	<div class="chat-container"></div>
	<div class="question-container">
		<input type="text" id="question" name="question" class="field"
			placeholder="Digite para falar com Stella" />

		<button id="sendQuestion">
			<i class="fas fa-paper-plane"></i>
		</button>
	</div>

	<div class="controls">
		<button id="recordButton">
			<i class="fas fa-microphone"></i>
		</button>
		<button id="pauseButton" disabled>
			<i class="fas fa-pause"></i>
		</button>
		<button id="stopButton" disabled>
			<i class="fas fa-stop"></i>
		</button>

	</div>

	<div
		style="display: inline-block; text-align: center; margin: 0 auto; width: 100%;">
		<div id="loading" class="lds-ripple">
			<div></div>
			<div></div>
		</div>
	</div>
</section>
<script src="https://cdn.rawgit.com/mattdiamond/Recorderjs/08e7abd9/dist/recorder.js"></script>
<!-- Para a versão dois utilizar o script main.js -->
<script type="text/javascript" src="./scripts/bot/assistant.js"></script>
<script type="text/javascript" src="./scripts/bot/tts.js"></script>
<script type="text/javascript" src="./scripts/bot/stt.js"></script>
</html>
