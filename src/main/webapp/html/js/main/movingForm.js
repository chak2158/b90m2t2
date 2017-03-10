function goMainForm(){
	$("div#content").load(path+"main/search.html");
}
function goLoginForm(){
	$("div#content").load(path+"login/loginForm.html");
}
function gologOut() {
	localStorage.removeItem("member");
	$("#logOutNav").addClass("hidden");
	$("#LoginFormNav").removeClass("hidden");
	$("#MyPageNav").addClass("hidden");
	$("#RegisterNav").removeClass("hidden");
	$("#content").load(path+"main/search.html");
	alert("로그아웃 하셨습니다.");
}
function goRegiAgreeForm(){
	$("div#content").load(path+"login/registerAgreeForm.html")
}

function goReview(){
	$("div#content").load(path+"board/list.html");
}
function goMyPage(){
	location.href = "http://192.168.0.230:9090/b90m2t2/html/myPage/fullCalendar.html";
}
function goLoginForm(){
	$("div#content").load(path+"login/loginForm.html")
}
	

 
