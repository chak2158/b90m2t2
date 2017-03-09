
// 프로필 사진 출력
//$("input[type=file]").change(function(e) {
//		
//   e.preventDefault();
//
//	var file = $("input[type=file]")[0].files[0];
//	var reader = new FileReader();
//
//    reader.onload = function (event) {
//	  
//    var img = new Image();
//    img.src = event.target.result;
//    // note: no onload required since we've got the dataurl...I think! :)
//    
//    img.width = 300;
//    img.height = 300;
//    
//    holder.innerHTML = '';
//	    holder.appendChild(img);
//	 };
//	 reader.readAsDataURL(file);
//	 return false;
//});

function loadFile(event) {
    	
	var file = event.target.files[0];
	if (file.type.substring(0, 5) != 'image') {
		alert("이미지를 선택하세요");
		return false;
	}
	if (file.size > 10000 * 1024) {
		alert("100kb 미만의 파일을 선택하세요");
		return false;
	}
	
    var reader = new FileReader();
    reader.onload = function(){
        var output = "<img src="+reader.result+" alt='' width='200' height='150'/>";
	    $('.img').html(output);
    };
    
    reader.readAsDataURL(file);
        
};   

// 생년 월일 셀렉박스 만들기.
for(var i=1950; i<=2017;i++){
	var temp = "<option value="+i+">"+i+"</option>";
	var year = $("#year").html();
	$("#year").html(year+temp);
}

for(var i=1; i<=12;i++){
	var temp = "<option value="+i+">"+i+"</option>";
	var month = $("#month").html();
	$("#month").html(month+temp);
}

for(var i=1; i<=31;i++){
	var temp = "<option value="+i+">"+i+"</option>";
	var date = $("#date").html();
	$("#date").html(date+temp);
}

// 아이디 중복 검사.
$("input[id='id']").keyup(function() {
	$.ajax({
		url:"/b90m2t2/login/checkId.do",
		type:"POST",
		data:{id: $("input[id=id]").val()}
	}).done(function(result){
		
		console.log(result);
		
		if(result=='false'){
			$("#msgId").html("사용가능한 아이디 입니다.").css("color","blue");
		}else if(result=='true'){
			$("#msgId").html("이미 사용중 입니다.").css("color","red");
		}
		
		if( $("input[id=id]").val()==""){
			$("#msg").html("");
		}
	});
});

// 이메일 중복 검사
$("input[id=email]").keyup(function() {
	
	console.log($("input[id=email]").val(),"email");
	
	$.ajax({
		url:"/b90m2t2/login/checkEmail.do",
		type:"POST",
		data:{email: $("input[id=email]").val()}
	}).done(function(result){
		
		console.log(result);
		
		if(result=='false'){
			$("#msgEmail").html("사용가능한 이메일 입니다.").css("color","blue");
		}else if(result=='true'){
			$("#msgEmail").html("이미 사용중 입니다.").css("color","red");
		}
		
		if( $("input[id=email]").val()==""){
			$("#msgEmail").html("");
		}
	});
});

$("#joinBtn").click(function() {

	$.ajax({
		url:"http://localhost:10001/login/pass.do",
		data:{pass:"zzz"},
		type:"GET"
	}).done(function (result) {
		console.log(result);
	});
	
});


/*
$("#joinBtn").click(function() {
	
	//아이디
	var id = document.querySelector('input[id="id"]');
	
		if(id.value.length == 0 || id.value == null) {
			alert("아이디를 입력하세요.");
			id.select();
			return false;
		};
		
	//비밀번호	
	var password = document.querySelector('input[id="password"]');
	
	if(password.value.length == 0 || password.value == null) {
		alert("비밀번호를 입력하세요.");
		password.select();
		return false;
	};
	
	var passwordCheck = document.querySelector('input[id="passwordCheck"]');
	
	if(passwordCheck.value.length == 0 || passwordCheck.value == null) {
		alert("비밀번호 확인을 입력하세요.");
		password.select();
		return false;
	};
	
	if(password.value != passwordCheck.value){
		alert("비밀번호를 확인하세요");
		password.focus();
		return;
	}
	
	var homeAddr = document.querySelector('input[id="homeAddr"]');
	
	if(homeAddr.value==""){
		alert("거주지를 입력하세요.");
		homeAddr.focus();
		return;
	}
	
	// email 유효성 체크.
	var email = document.querySelector('input[id=email]').value;
	var regex=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
	
	if(regex.test(email) === false) {
	 alert("잘못된 이메일 형식입니다.");
	 email.focus();
	 return false;
	} 
	
	// 핸드폰 유효성 체크.
	var phone = document.querySelector('input[id=phoneNumber]').value;
	var regex = /^\d{3}-\d{3,4}-\d{4}$/;
	
	console.log(phone);
	
	if(regex.test(phone) === false) {
		alert("잘못된 휴대폰번호 형식입니다.");
		phone.focus();
		return false;
	}
	
	//생년월일
	var year = document.querySelector('select[id="year"]');
	var month = document.querySelector('select[id="month"]');
	var date = document.querySelector('select[id="date"]');
	
	if(year.selectedIndex == 0) {
		alert("년도를 선택하세요");
		return;
	}
	if(month.selectedIndex == 0) {
		alert("월을 선택하세요");
		return;
	}
	if(date.selectedIndex == 0) {
		alert("일을 선택하세요");
		return;
	}	
	
	
	var fd= new FormData();
	
	fd.append("memberId",$("#id").val());
	fd.append("password",$("#password").val());
	fd.append("homeAddr",$("#homeAddr").val());
	fd.append("email",$("#email").val());
	fd.append("phoneNumber", $("#phoneNumber").val());
	fd.append("birthYear",$("#year").val());
	fd.append("birthMonth",$("#month").val());
	fd.append("birthDate",$("#date").val());
	fd.append("profileImg",$("[name=profileImg]")[0].files[0]);
	
	$.ajax({
		url:"/b90m2t2/login/register.do",
		type:"POST",
		data: fd,
		processData:false,
		contentType:false,
		success : function (result) {
			if(result){
				$("#content").load("loginForm.html");
				alert("회원가입 성공");	
			}
		}
	});
	
	
	
});
*/

