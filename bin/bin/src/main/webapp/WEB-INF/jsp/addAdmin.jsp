<%@ include file="header.jsp"%>

 <div id="header_bottom">
	        	<p>
	            	<a href="<c:url value='/admin/addCategory'/>">Add Product Category</a> | 
	            	<a href="<c:url value='/admin/addAdmin'/>">Add Admin</a>
	            </p>
	            
	        </div> <!-- END of header bottom -->
	    </div> <!-- END of header -->

<div id="tooplate_main">
	<span class="main_border main_border_t"></span><span
		class="main_border main_border_b"></span>

	<div class="container">


				<div class="col col_1">
					<h1>Add new admin</h1>

					<h3>USER DETAILS</h3>
				</div>
				<form:form action="addAdmin" method="post" modelAttribute="admin">
					<div class="col col_2">
						<div class="form-group">
							<input type="email" name="email" id="email"
								class="form-control input-sm" placeholder="Email Address"
								style="width: 300px;">
						</div>
						<div class="form-group">
							<input type="text" name="firstName" id="first_name"
								class="form-control input-sm" placeholder="First Name"
								style="width: 300px;">
						</div>
						<div class="form-group">
							<input type="text" name="lastName" id="last_name"
								class="form-control input-sm" placeholder="Last Name"
								style="width: 300px;">
						</div>

					</div>

					<div class="col col_2">

						<div class="form-group">
							<input type="text" name="phoneNumber" id="phone_number"
								class="form-control input-sm" placeholder="Phone Number"
								style="width: 300px;">
						</div>
						<div class="form-group">
							<input type="password" name="user.password" id="password"
								class="form-control input-sm" placeholder="Password"
								style="width: 300px;">
						</div>
						<div class="form-group">
							<input type="password" name="password_confirmation"
								id="password_confirmation" class="form-control input-sm"
								placeholder="Confirm Password" style="width: 300px;">
						</div>
						<br />

					</div>
					

					<div class="col col_1">
						<h3>ADDRESS</h3>
					</div>
					<div class="col col_2">
						<div class="form-group">
							<input type="text" name="address.street" id="street"
								class="form-control input-sm" placeholder="Street"
								style="width: 300px;">
						</div>
						<div class="form-group">
							<input type="text" name="address.city" id="city"
								class="form-control input-sm" placeholder="City"
								style="width: 300px;">
						</div>
						<div class="form-group">
							<input type="number" name="address.zipCode" id="zipcode"
								class="form-control input-sm" placeholder="Zip Code"
								style="width: 300px;">
						</div>

					</div>

					<div class="col col_2">
						<div class="form-group">
							<input type="text" name="address.state" id="state"
								class="form-control input-sm" placeholder="State"
								style="width: 300px;">
						</div>
						<div class="form-group">
							<input type="text" name="address.country" id="country"
								class="form-control input-sm" placeholder="Country"
								style="width: 300px;">
						</div>

					</div>

					<div class="col col_1">
						<input type="submit" value="Add admin"
							class="btn btn-info btn-block">
					</div>

				</form:form>
		
	</div>


	<div class="clear"></div>
</div>
<!-- END of main -->

</div>
<!-- END of wrapper -->

<%@ include file="footer.jsp"%>