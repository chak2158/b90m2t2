console.log("글등록",board.write.content);

var template = $("#myDetail");
	
var ctemplate = Handlebars.compile(template.html());
	
var emp = {
				write: [
					{ reviewNo : board.write.reviewNo, 
					  title:board.write.title , 
					  content: board.write.content,
					  memberId: board.write.memberId
					}					
				]
			  }
	
	
var html = ctemplate(emp);
	
$('#container').append(html);
	