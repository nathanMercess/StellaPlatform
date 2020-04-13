function logout() {
	var xhr = new XMLHttpRequest();
	xhr.open("GET", getContextPath()+"/api/login", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
	
	xhr.addEventListener("load", function() {
		if(xhr.status == 200) {
			console.log("Deslogado com sucesso")
			document.location.reload();
		}else {
			
		}
	});
	xhr.send();
}