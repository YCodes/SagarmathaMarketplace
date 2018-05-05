<%@ include file="header.jsp"%>


<div id="header_bottom">
		<p><a href="<c:url value='/vendor/dashboard'/>">Vendor Dashboard  |</a>
		<a href="<c:url value='/vendor/listproduct'/>">List Product  |</a>
		<a href="<c:url value='/vendor/addproduct'/>">Add Product</a></p>
</div>
<!-- END of header bottom -->
</div>
<!-- END of header -->
<div id="tooplate_main">
	<span class="main_border main_border_t"></span><span
		class="main_border main_border_b"></span>
		
	<div class="container">
					<div id="home" class="tab-pane fade in active">
				<div class="row centered-form">
					<div
						class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<strong>Vendor Profile Information</strong>
								</h3>
							</div>
							<div class="panel-body">
								<form:form action="/sagarmathamarketplace/vendor/update" method="post"
									modelAttribute="vendorUpdate">
									<div class="row">
										<div class="col-xs-6 col-sm-6 col-md-6">

											<input type="hidden" name="Id" value="1" >

											<div class="form-group">
												<input type="text" name="first_name" id="first_name"
													class="form-control input-sm" placeholder="First Name"
													value="${vendor.first_name}">
											</div>
										</div>
										<div class="col-xs-6 col-sm-6 col-md-6">
											<div class="form-group">
												<input type="text" name="last_name" id="last_name"
													class="form-control input-sm" placeholder="Last Name"
													value="${vendor.last_name}">
											</div>
										</div>
									</div>

									<div class="form-group">
										<input type="number" name="phone_number" id="phone_number"
											class="form-control input-sm" placeholder="Phone Number"
											value="${vendor.phone_number}">
									</div>

									<div class="form-group">
										<input type="email" name="email" id="email"
											class="form-control input-sm" placeholder="Email Address"
											value="${vendor.email}">
									</div>

									<div class="row">
										<div class="col-xs-6 col-sm-6 col-md-6">
											<div class="form-group">
												<input type="password" name="user.password" id="password"
													class="form-control input-sm" placeholder="Password">
											</div>
										</div>
										<div class="col-xs-6 col-sm-6 col-md-6">
											<div class="form-group">
												<input type="password" name="password_confirmation"
													id="password_confirmation" class="form-control input-sm"
													placeholder="Confirm Password">
											</div>
										</div>
									</div>

									<div class="panel panel-default">
										<div class="panel-heading">
											<h3 class="panel-title">
												<strong>Vendor Address: </strong>
											</h3>
										</div>
									</div>
									<div class="panel-body">
										<div class="row">
											<div class="col-xs-6 col-sm-6 col-md-6">
												<div class="form-group">
													<input type="text" name="address.street" id="street"
														class="form-control input-sm" placeholder="Street"
														value="${vendor.address.street}">
												</div>
											</div>
											<div class="col-xs-6 col-sm-6 col-md-6">
												<div class="form-group">
													<input type="text" name="address.city" id="city"
														class="form-control input-sm" placeholder="City"
														value="${vendor.address.city}">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-xs-6 col-sm-6 col-md-6">
												<div class="form-group">
													<input type="number" name="address.zipCode" id="zipcode"
														class="form-control input-sm" placeholder="Zip Code"
														value="${vendor.address.zipCode}">
												</div>
											</div>
											<div class="col-xs-6 col-sm-6 col-md-6">
												<div class="form-group">
													<input type="text" name="address.state" id="state"
														class="form-control input-sm" placeholder="State"
														value="${vendor.address.state}">
												</div>
											</div>
										</div>
										<div class="form-group">
											<input type="text" name="address.country" id="country"
												class="form-control input-sm" placeholder="Country"
												value="${vendor.address.country}">
										</div>

									</div>

									<input type="submit" value="Update"
										class="btn btn-info btn-block">

								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	<div class="clear"></div>
</div>
<!-- END of main -->


<%@ include file="footer.jsp"%>