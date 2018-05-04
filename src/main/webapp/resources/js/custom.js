jQuery(document).ready(function(){
	
	$(".editLink").click(function(){
		var value = $(this).attr("data-target");
		$("").show();
		return false;
	});
	
	$(".close").click(function(){
		$("#exampleModal").hide();
	});
	
	$(".modal-footer .btn.btn-secondary").click(function(){
		$("#exampleModal").hide();
	});
});
