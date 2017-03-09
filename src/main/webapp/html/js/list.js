function makePageList(result) {
	$("#count").text(result.pageResult.count);
	
	console.log(result);
	
	var html = "";
	
	for (var i = 0; i < result.list.length; i++) {
		var board = result.list[i];
	
		html += '<tr>';
		html += '	<td>' + board.reviewNo + '</td>';
		html += '	<td><a href="javascript:detail('+board.reviewNo+');">' + board.title + '</a></td>';
		html += '	<td>' + board.content + '</td>';
		html += '	<td>' + board.memberId + '</td>';
		
		var date = new Date(board.regDate);
		var time = date.getFullYear() + "-" 
		         + (date.getMonth() + 1) + "-" 
		         + date.getDate() + " "
		         + date.getHours() + ":"
		         + date.getMinutes() + ":"
		         + date.getSeconds();
		html += '<td>' + time + '</td>';  
		html += '</tr>';
		
	}
	
	if (!result.list.length) {
		html += '<tr><td colspan="4">게시물이 존재하지 않습니다.</td></tr>';
	}
	
	$("#pageTable").html(html);
	
	makePageLink(result.pageResult);
}

function makePageLink(data) {
	var html = "";
	/*
	<ul class="pagination">


	</ul>
	*/
	if (data.count != 0) {
		
		/*
		<li class="disabled">
			<a href="" aria-label="Previous">
		<span aria-hidden="true">«</span>
			</a>
		</li>
		*/
		var clz = "";
		if (data.prev == false) {
			clz = "disabled";
		}
		html += '<li class="' + clz + '">';
		
		var fn = "";
		
		if (data.prev == true) {
			fn = "javascript:pageList(" + (data.beginPage - 1) + ");";
		}
		html += '<a href="' + fn + '" aria-label="Previous">';
		html += '<span aria-hidden="true">&laquo;</span>';
		html += '</a>';
	    html += '</li>';
/*		<li class="active">
			<a href="#1">1</a>
		</li>
*/		
	    for (var i = data.beginPage; i <= data.endPage; i++) {
	    	if (i == data.pageNo) {
			    html += '<li class="active"><a href="#1">' + i + '</a></li>';
	    	}
	    	else {
	    		html += '<li><a href="javascript:pageList(' + i + ');">' + i + '</a></li>';
	    	}
	    }
/*		<li class="disabled">
		<a href="" aria-label="Next">
			<span aria-hidden="true">»</span>
		</a>
		</li>
*/
		clz = "";
		if (data.next == false) {
			clz = "disabled";
		}
		html += '<li class="' + clz + '">';
		
		fn = "";
		
		if (data.next == true) {
			fn = "javascript:pageList(" + (data.endPage + 1) + ");";
		}
		html += '<a href="' + fn + '" aria-label="Next">';
		html += '<span aria-hidden="true">&raquo;</span>';
		html += '</a>';
	    html += '</li>';
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	$("nav > ul.pagination").html(html);
}

function pageList(pageNo) {
	if (pageNo === undefined) {
		pageNo = 1;
	}
	$.ajax({
		url: "/b90m2t2/board/list.do",
		dataType: "json",
		data: {pageNo:pageNo}
	})
	.done(makePageList);
}
  
function reviewBoard() {
	$("div#content").load("/b90m2t2/board/list.html");
	pageList();
	
}

// function makeDetail(result){
// console.log(result);
//	
// var html = "";
// var board = result.detail;
//	
//	
//	
// // $("#content").html(html);
//	
// }

function detail(no) {
	pageDetail(no);
}

function pageDetail(no){
	
	$.ajax({
		url: "/b90m2t2/board/detail.do",
		dataType: "json",
		data : {reviewNo : no},
		async:false
	})
	.done(function(result) {
		
		board=result;
		$("#content").load("detail.html");
		alert("ㅋㅋ");
})
}
function pageWrite(){
	var fd = new FormData();
	
	
	fd.append("title",$("[name=title]").val());
	fd.append("content",$("[name=content]").val());
	fd.append("memberId",$("[name=memberId]").val());
	
	var files = $("[name=attachFile]")[0].files;
	
	for(var i=0;i<files.length;i++) {
		fd.append("attachFile"+i,files[0]);
	}
	
	
	$.ajax({
		url: "/b90m2t2/board/write.do",
		type: "POST",
		data : fd,
		processData : false,
		contentType : false
	})
	.done(function(){
		alert("등록 되었습니다")
		$("#content").load("list.html");
		pageList();
	})
}

function write(){
	
	$("#content").load("write.html");
	
}


function pageDelete(no){

	$.ajax({
		url: "/b90m2t2/board/delete.do",
		dataType: "json",
		data : {reviewNo : no}
	})
	.done(function(){
		alert("삭제 되었습니다")
		$("#content").load("delete.html");
		reviewBoard();
	})
}
function pageUpdate(no){
// console.log(result);
	$.ajax({
		url: "/b90m2t2/board/updateForm.do",
		dataType: "json",
		data : {reviewNo : no}
	})
	.done(function(result){
// console.log(result);
		board=result.board;
		console.log(board.reviewNo)
		$("#content").load("updateForm.html");
	});
}



function pageUpdateClick(){
	var reviewNo = $("[name=reviewNo]").val();
	var title = $("[name=title]").val();
	var memberId = $("[name=memberId]").val();
	var content = $("[name=content]").val();
	
	console.log(memberId);
	console.log(reviewNo);
	$.ajax({
		url : "/b90m2t2/board/update.do",
		data : {
			"reviewNo": reviewNo,
			"title" : title,
			"memberId" : memberId,
			"content" : content
		}
	})
	.done(function(){
		alert("수정 됬습니다.");
		reviewBoard();
	})
}




// ===============================================================



//function commentList(pageNo) {
//// console.log(result);
//	 
//	if (pageNo === undefined) {
//		pageNo = 1;
//	}
//	$.ajax({
//		url: "/b90m2t2/board/commentList.do",
//		dataType: "json",
//		data: {pageNo:pageNo,
//			   reviewNo: board.reviewNo}
//	})
//	.done(makeCommentList);
//}
//  
//function reviewComment() {
//// $("div#content").load("commentList.html");
//	commentList();
//}



