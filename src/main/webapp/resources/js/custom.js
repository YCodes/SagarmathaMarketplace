jQuery(document).ready(function(){
	
	$(".editLink").click(function(){
		var value = $(this).attr("data-target");
		$(value).show();
		return false;
	});
	
	$(".close").click(function(){
		var value = $(this).closest(".modal").attr("id");
		$(value).hide();
	});
	
	$(".modal-footer .btn.btn-secondary").click(function(){
		var value = $(this).closest(".modal").attr("id");
		alert(value);
		$(value).hide();
	});
});
