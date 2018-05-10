<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="navigation.jsp"%>
<div id="tooplate_slider" class="section_content">

	<div id="tooplate_main">
		<span class="main_border main_border_t"></span><span
			class="main_border main_border_b"></span>
	<table id="cart" class="table table-hover table-condensed">
		<thead>
			<tr>
				<th style="width: 50%">Product</th>
				<th style="width: 10%">Price</th>
				<th style="width: 8%">Quantity</th>
				<th style="width: 22%" class="text-center">Subtotal</th>
				<th style="width: 10%"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="orderline" items="${order.orderLine}"
				varStatus="loop">
				<tr id="orderlinerow">
					<td data-th="Product">
						<div class="row">
							<div class="col-sm-2 hidden-xs">
								<img src="http://placehold.it/100x100" alt="..."
									class="img-responsive" />
							</div>
							<div class="col-sm-10">
								<h4 class="nomargin">${orderline.product.product_name}</h4>
								<p>${orderline.product.product_description}</p>
							</div>
						</div>
					</td>
					<td data-th="Price">${orderline.product.price}</td>
					<td data-th="Quantity"><input type="number" min="1"
						class="form-control text-center" value="${orderline.quantity}"
						id="cartQuantity" data-qty="${loop.count}"></td>
					<td data-th="Subtotal" class="text-center">${orderline.product.price * orderline.quantity}</td>
					
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<!-- <tr class="visible-xs">
					<td class="text-center"><strong>totalPrice</strong></td>
				</tr> -->
			<c:url var="post_url" value="/change" />
			<input type="hidden" value="${post_url}" id="checkoutUrl">
			<tr>
				<td><a href="<c:url value='/homepage'/>"
					class="btn btn-warning"><i class="fa fa-angle-left"></i>
						Continue Shopping</a></td>
				<td colspan="2" class="hidden-xs"></td>
				<td class="hidden-xs text-center"><strong>Total
						$${totalPrice}</strong></td>
				<td><a href="<c:url value='/checkout'/>"
					class="btn btn-success btn-block">Checkout <i
						class="fa fa-angle-right"></i>
				</a></td>
			</tr>
		</tfoot>
	</table>
	</div>
</div>



<script>

	
$("[data-qty]").change(function(){

		var post_url = $('#checkoutUrl').val();
		var quantity = $(this).val();
		var orderLineIndex = $(this).attr("data-qty");

		//alert(post_url+"\n"+quantity+"\n"+orderLineIndex)
		
		$.ajax({
			"url" : post_url,
			"method" : "GET",
			"data" : {
				"quantity" : quantity,
				"orderLineIndex" : orderLineIndex
			},
			"success" : function(successResp) {
					window.location.reload();
			},

			"error" : function(errorResp) {

			}
		})
	});
</script>

<%@ include file="footer.jsp"%>