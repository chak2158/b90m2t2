function goLoginForm(){
	$("div#content").load("loginForm.html")
}
	
function goRegiAgreeForm(){
	$("div#content").load("registerAgreeForm.html")
	
}

function logOut() {
	member=null;
	$("ul#login > span#loginOut").removeClass("hidden");
	$("ul#login > span#loginOut").addClass("show");
	$("ul#login > span#loginIn").removeClass("show");
	$("ul#login > span#loginIn").addClass("hidden");
	$("#content").load("main.html");
}

window.onunload = function () {
	member=null;
}