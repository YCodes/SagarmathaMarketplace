<%@ include file="navigation.jsp"%>

<div id="tooplate_main">
	<span class="main_border main_border_t"></span><span
		class="main_border main_border_b"></span>

	<h3>Thank you for Shopping ${User}. Your Order Detail :</h3>
	<div class="panel panel-info">
		<div class="panel-heading">
			<h3 style="display: inline-block">Review Order</h3>
		</div>

		<div class="container">
			<table id="cart" class="table table-hover table-condensed">
				<thead>
					<tr>
						<th style="width: 20%">Product</th>
						<th style="width: 20%">Price</th>
						<th style="width: 20%">Quantity</th>
						<th style="width: 20%" class="text-center">Subtotal</th>
						<th style="width: 20%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="orderline" items="${order.orderLine}">
						<tr>
							<td data-th="Product">
								<div class="row">
									<!-- <div class="col-sm-2 hidden-xs">
									<img src="http://placehold.it/100x100" alt="..."
										class="img-responsive" />
								</div> -->
									<div class="col-sm-10">
										<h4 class="nomargin" align="center">${orderline.product.product_name}</h4>
										<%-- <p>${orderline.product.product_description}</p> --%>
									</div>
								</div>
							</td>
							<td data-th="Price">${orderline.product.price}</td>
							<td data-th="Price" align="center">${orderline.quantity}</td>
							<%-- <td data-th="Quantity"><input type="number"
							class="form-control text-center" value="${orderline.quantity}"></td> --%>
							<td data-th="Subtotal" class="text-center" align="center">${orderline.product.price * orderline.quantity}</td>

						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<!-- <tr class="visible-xs">
					<td class="text-center"><strong>totalPrice</strong></td>
				</tr> -->
					<tr>
						</br>
						<td colspan="2" class="hidden-xs"></td>
						<td class="hidden-xs text-center" align="center"><strong>Total
								$${totalPrice}</strong></td>

					</tr>
				</tfoot>
			</table>
		</div>

	</div>

</div>


<%@ include file="footer.jsp"%>