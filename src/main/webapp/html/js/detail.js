console.log("디테일",board.detail.content);

var template = $("#myDetail");
	
var ctemplate = Handlebars.compile(template.html());
	
var emp = {
				detail: [
					{ reviewNo : board.detail.reviewNo, 
					  title:board.detail.title , 
					  content: board.detail.content,
					  memberId: board.detail.memberId
					  
					}					
				]
			  }
	
	
var html = ctemplate(emp);
	
$('#container').append(html);
	