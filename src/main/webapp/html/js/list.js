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
	if (data.count != 0) {
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
		
	    for (var i = data.beginPage; i <= data.endPage; i++) {
	    	if (i == data.pageNo) {
			    html += '<li class="active"><a href="#1">' + i + '</a></li>';
	    	}
	    	else {
	    		html += '<li><a href="javascript:pageList(' + i + ');">' + i + '</a></li>';
	    	}
	    }
	    
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
	$("div#content").load("list.html");
	pageList();
}

function makeDetail(result){
	console.log(result);
	var html = "";
	var board = result.detail;
	html +="<table border='1'>"
	html += "<tr>"
	html += "	<td>" + board.reviewNo +"</td>";
	html += "</tr>" 
		
	html += "<tr>"
	html += "	<td>" + board.memberId +"</td>"; 
	html += "</tr>" 
		
	html += "<tr>"
	html += "	<td>" + board.title +"</td>"; 
	html += "</tr>" 
		
	html += "<tr>"
	html += "	<td>" + board.content +"</td>"; 
	html += "</tr>";
	html += "</table>";
	
	$("#content").html(html);
	
}


function detail(no) {
	pageDetail(no);
}

function pageDetail(no){
	
	$.ajax({
		url: "/b90m2t2/board/detail.do",
		dataType: "json",
		data : {reviewNo : no}
	})
	.done(makeDetail)
}



	/*.done(function(no) {
		
		$("div#content").load("detaile.html");
		
	});
	*/
//	
//	function reviewBoard() {
//		$("div#content").load("detail.html");
//	}
//}

