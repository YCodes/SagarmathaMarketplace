jQuery(document).ready(function(){
	
	$("#editLink").click(function(){
		$("#exampleModal").show();
		return false;
	});
	
	$(".close").click(function(){
		$("#exampleModal").hide();
	});
	
	$(".modal-footer .btn.btn-secondary").click(function(){
		$("#exampleModal").hide();
	});
});
