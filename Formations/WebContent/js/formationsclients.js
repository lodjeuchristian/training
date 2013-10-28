$(document).ready(function() {
	$("#clientBySession").attr('disabled', 'disabled');
});

function enableClick(){
	$("#clientBySession").removeAttr('disabled');
}
