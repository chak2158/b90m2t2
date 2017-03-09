

function makeCommentList(result) {
	$("#count").text(result.pageResult.count);
	
	console.dir("comment",result);
	
	var html = "";
	html += '<table class="table table-hover table-bordered">';
	html += '	<colgroup>'; 
	html += '		<col width="7%">'; 
	html += '		<col width="*">'; 
	html += '		<col width="14%">'; 
	html += '		<col width="10%">'; 
	html += '	</colgroup>'; 
	  
	for (var i = 0; i < result.length; i++) {
		var comment = result[i];
		html += '<tr id="row' + comment.reviewNo + '">';
		html += '	<td>' + comment.memberId + '</td>';
		html += '	<td>' + comment.content + '</td>';
		
		var date = new Date(comment.regDate);
		var time = date.getFullYear() + "-" 
		         + (date.getMonth() + 1) + "-" 
		         + date.getDate() + " "
		         + date.getHours() + ":"
		         + date.getMinutes() + ":"
		         + date.getSeconds();
		html += '	<td>' + time + '</td>';  
		html += '	<td>';    
		html += '		<a href="javascript:commentUpdateForm(' + comment.reviewNo + ')" class="btn btn-success btn-sm" role="button">수정</a>';    
		html += '		<a href="javascript:commentDelete(' + comment.reviewNo + ')" class="btn btn-danger btn-sm" role="button">삭제</a>';    
		html += '	</td>';    
		html += '</tr>';
	}
	if (result.list.length) {
		html += '<td colspan="4">댓글이 존재하지 않습니다.</td>';
	}
		
		$("#pageTable").html(html);
		makeCommentLink(result.pageResult);
}



function makeCommentLink(comm) {
	var html = "";
	html+='<nav>';
	html+='<ul class="pagination">';
	
	if (comm.count != 0) {
		var clz = "";
		if (comm.prev == false) {
			clz = "disabled";
		}
		html += '<li class="' + clz + '">';
		
		var fn = "";
		
		if (comm.prev == true) {
			fn = "javascript:commentList(" + (comm.beginPage - 1) + ");";
		}
		html += '<a href="' + fn + '" aria-label="Previous">';
		html += '<span aria-hidden="true">&laquo;</span>';
		html += '</a>';
	    html += '</li>';
		
	    for (var i = comm.beginPage; i <= comm.endPage; i++) {
	    	if (i == comm.pageNo) {
			    html += '<li class="active"><a href="#1">' + i + '</a></li>';
	    	}
	    	else {
	    		html += '<li><a href="javascript:commentList(' + i + ');">' + i + '</a></li>';
	    	}
	    }
	    
		clz = "";
		if (comm.next == false) {
			clz = "disabled";
		}
		html += '<li class="' + clz + '">';
		
		fn = "";
		
		if (comm.next == true) {
			fn = "javascript:commentList(" + (comm.endPage + 1) + ");";
		}
		html += '<a href="' + fn + '" aria-label="Next">';
		html += '<span aria-hidden="true">&raquo;</span>';
		html += '</a>';
	    html += '</li>';
	}
	
	html+='</ul>';
	html+='</nav>';
	
	$("#content").append(html);
}

// 댓글 목록 조회
function commentList(pageNo) {
	// console.log(result);
		 
		if (pageNo === undefined) {
			pageNo = 1;
		}
		
		console.log("디테일 번호",board.reviewNo);
		
		$.ajax({
			url: "/b90m2t2/board/commentList.do",
			dataType: "json",
			data: {pageNo:pageNo,
				   reviewNo: board.reviewNo}
		})
		.done(makeCommentList);
	}

	  
function reviewComment() {
// $("div#content").load("commentList.html");
	commentList();
}