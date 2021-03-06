<%@ include file="headerForSignup.jsp"%>
<div id="tooplate_main">
	<span class="main_border main_border_t"></span><span
		class="main_border main_border_b"></span>
	<div class="row centered-form">
		<div
			class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<strong>Vendor Registration Form</strong>
					</h3>
				</div>
				<div class="panel-body">
					<form:form action="vendorsignup" method="post"
						modelAttribute="vendor">
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<input type="text" name="first_name" id="first_name"
										class="form-control input-sm" placeholder="First Name">
								</div>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<input type="text" name="last_name" id="last_name"
										class="form-control input-sm" placeholder="Last Name">
								</div>
							</div>
						</div>

						<div class="form-group">
							<input type="number" name="phone_number" id="phone_number"
								class="form-control input-sm" placeholder="Phone Number">
						</div>

						<div class="form-group">
							<input type="email" name="email" id="email"
								class="form-control input-sm" placeholder="Email Address">
								<form:errors path="email" class="error"/>
						</div>

						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<input type="password" name="user.password" id="password"
										class="form-control input-sm" placeholder="Password">
								</div>
							</div>
						</div>

						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<strong>Enter your Address..</strong>
								</h3>
							</div>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="text" name="address.street" id="street"
											class="form-control input-sm" placeholder="Street">
									</div>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="text" name="address.city" id="city"
											class="form-control input-sm" placeholder="City">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="number" name="address.zipCode" id="zipcode"
											class="form-control input-sm" placeholder="Zip Code">
									</div>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="text" name="address.state" id="state"
											class="form-control input-sm" placeholder="State">
									</div>
								</div>
							</div>
							<div class="form-group">
								<input type="text" name="address.country" id="country"
									class="form-control input-sm" placeholder="Country">
							</div>

							<div class="form-group">
								<input name="vendorFee" id="vendorfee" type="checkbox">Vendor
								Fee: $2500
							</div>

						</div>

						<input type="submit" value="Register"
							class="btn btn-info btn-block">

					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="clear"></div>

<%@ include file="footer.jsp"%>