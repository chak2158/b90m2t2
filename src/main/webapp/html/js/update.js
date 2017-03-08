
var template = $("#myUpdate");
	
var ctemplate = Handlebars.compile(template.html());
	
var emp = {
				updateForm: [
					{ reviewNo : board.reviewNo, 
					  title : board.title , 
					  content : board.content,
					  memberId : board.memberId
					  
					}					
				]
			  }
	
	
var html = ctemplate(emp);
	
$('#container').append(html);
	