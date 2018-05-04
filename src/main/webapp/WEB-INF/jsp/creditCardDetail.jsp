<%@ include file="navigation.jsp"%>


<div id="tooplate_main">
	<span class="main_border main_border_t"></span><span
		class="main_border main_border_b"></span>

	<div class="container">

		<div class="col col_1">
			<h1>Confirm Payment</h1>
		</div>
		<div class="col col_1">
			<form:form role="form" action="confirmPayment" method="POST"
				modelAttribute="payment">
				<div class="form-group">
					<label>Card Holder</label><input type="text" class="form-control"
						name="cardHolder" id="cardHolder" style="width: 300px;"> 
					<label>CVV</label><input type="text" class="form-control" name="cvv" id="cvv"
						style="width: 300px;">
					<label>Card Number</label><input type="text" class="form-control" name="cardNumber" id="cardNumber"
						style="width: 300px;"> 
					<label>Expiration Date</label>
					<select style="margin-bottom: 10px; margin-right: 10px; width: 200px" name='expireMM' id='expireMM'>
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
					<select style="margin-bottom: 10px; width: 90px" name='expireYY' id='expireYY'>
						<option value=''>Year</option>
						<option value='18'>2018</option>
						<option value='19'>2019</option>
						<option value='20'>2020</option>
						<option value='21'>2021</option>
						<option value='22'>2022</option>
						<option value='22'>2023</option>
					</select>
					<label>Zip Code</label><input type="text" class="form-control"
						name="zipcode" id="zipcode" pattern="^\d{5}$" style="width: 300px;"> 
				</div>
				<br />
				<input type="submit" value="Submit" class="btn btn-info" />

			</form:form>
		</div>

	</div>

	<div class="clear"></div>
</div>
<!-- END of main -->


<%@ include file="footer.jsp"%>