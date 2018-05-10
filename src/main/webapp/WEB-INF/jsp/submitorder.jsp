<%@ include file = "navigation.jsp" %>

<div id="tooplate_main">
	<span class="main_border main_border_t"></span><span
		class="main_border main_border_b"></span>
		
		
	<div class="container">
	
		<div class="col col_2">
			<h3>Address</h3>
			
			<form:form id="submit-payment" modelAttribute="paymentForm" method="post" action="submit">
			<div class="form-group">
				<form:input path="street"
					class="form-control input-sm" placeholder="Street"

					style="width: 300px;" required="required" />

			</div>
			<div class="form-group">
				<form:input path="city"
					class="form-control input-sm" placeholder="City"
					style="width: 300px;"  required="required"/>

			</div>
			<div class="form-group">
				<form:input path="zipCode"
					class="form-control input-sm" placeholder="Zip Code"

					style="width: 300px;" pattern="^\d{5}$" required="required"/>

			</div>
			<div class="form-group">
				<form:input path="state"
					class="form-control input-sm" placeholder="State"
					style="width: 300px;" required="required"/>
			</div>
			<div class="form-group">
				<form:input path="country"
					class="form-control input-sm" placeholder="Country"
					style="width: 300px;" required="required"/>
			</div>
			
			<br />
			<br />
			
			<h3>Secure Payment</h3>
				<div class="form-group">
					<label>Card Holder</label><form:input path="cardHolderName" class="form-control" style="width: 300px;" /> 
					<label>CCV</label><form:input path="cvv" class="form-control" style="width: 300px;" />
					<label>Card Number : 16 digits number</label><form:input path="cardNumber" class="form-control" 
						style="width: 300px;" pattern="[0-9]{16}"/> 
					<label>Expiration Date</label>
					<select style="margin-bottom: 10px; margin-right: 10px; width: 200px" name="month" id='expireMM'>
						<option value=''>Month</option>
						<option value='01'>January</option>
						<option value='02'>February</option>
						<option value='03'>March</option>
						<option value='04'>April</option>
						<option value='05'>May</option>
						<option value='06'>June</option>
						<option value='07'>July</option>
						<option value='08'>August</option>
						<option value='09'>September</option>
						<option value='10'>October</option>
						<option value='11'>November</option>
						<option value='12'>December</option>
					</select>
					<select style="margin-bottom: 10px; width: 90px"  name="year" id='expireYY'>
						<option value=''>Year</option>
						<option value='18'>2018</option>
						<option value='19'>2019</option>
						<option value='20'>2020</option>
						<option value='21'>2021</option>
						<option value='22'>2022</option>
						<option value='23'>2023</option>
					</select>
					<label>Zip Code</label>  <form:input path="cardZipcode" class="form-control"  pattern="^\d{5}$" style="width: 300px;" /> 
				</div>
				<br />
				<input type="submit" value="Submit" class="btn btn-info" />

			</form:form>
			<h5>${error}</h5>
		</div>
		
		<div class="col col_2">
		<!--REVIEW ORDER-->
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3 style="display: inline-block">Review Order</h3>
                        </div>
                        
                        <div class="container">
		<table id="cart" class="table table-hover table-condensed">
			<thead>
				<tr>
					<th style="width: 30%">Product</th>
					<th style="width: 0%">Price</th>
					<th style="width: 8%">Quantity</th>
					<th style="width: 22%" class="text-center">Subtotal</th>
					<th style="width: 10%"></th>
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
					<td class="hidden-xs text-center" align="center"><strong>Total  $${totalPrice}</strong></td>
					
				</tr>
			</tfoot>
		</table>
	</div>
                    
		</div>
		
	</div>

	<div class="clear"></div>
</div>
<!-- END of main -->

<%@ include file = "footer.jsp" %>