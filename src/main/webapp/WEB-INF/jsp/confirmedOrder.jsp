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
				</tr>
			</thead>
			<tbody>
				<c:forEach var="orderline" items="${order.orderLine}">
					<tr>
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
						<td data-th="Quantity"><input type="number" disabled = "true"
							class="form-control text-center" value="${orderline.quantity}"></td>
						<td data-th="Subtotal" class="text-center">${orderline.product.price * orderline.quantity}</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<!-- <tr class="visible-xs">
					<td class="text-center"><strong>totalPrice</strong></td>
				</tr> -->
				<tr>
					<%-- <td><a href="<c:url value='/homepage'/>" class="btn btn-warning"><i
							class="fa fa-angle-left"></i> Continue Shopping</a></td>
					<td colspan="2" class="hidden-xs"></td> --%>
					<td class="hidden-xs text-center"><strong>Total  $${totalPrice}</strong></td>
					<td><a href="<c:url value='/checkout/submit'/>" class="btn btn-success btn-block">Confirm Order
							<i class="fa fa-angle-right"></i>
					</a></td>
				</tr>
			</tfoot>
		</table>
	</div>
</div>

</body>
</html>