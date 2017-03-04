/**
 * 
 */
function isEmpty(obj, msg) {
	if (obj.value == "") {
		alert(msg);
		obj.focus();
		return true;
	}	
	return false;
}