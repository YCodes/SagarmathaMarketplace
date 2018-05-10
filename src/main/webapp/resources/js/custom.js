jQuery(document).ready(function(){
	
	$(".editLink").click(function(){
		var value = $(this).attr("data-target");
		$(value).show();
		return false;
	});
	
	$(".close").click(function(){
		$(this).closest(".modal").hide();
	});
	
	

	
	$(".modal-footer .btn.btn-secondary").click(function(){		
		$(this).closest(".modal").hide();
	});
});
