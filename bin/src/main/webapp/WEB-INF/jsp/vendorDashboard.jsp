<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="<c:url value='/resources/css/login.css'/>" rel="stylesheet" />

<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>


</head>
<body>
	<div class="container">
		<h2 style="text-align: center">Vendor Dashboard</h2>
		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#home">Profile</a></li>
			<li><a data-toggle="tab" href="#menu1">List Product</a></li>
			<li><a data-toggle="tab" href="#menu2">Add Product</a></li>
		</ul>

		<div class="tab-content">
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
								<form:form action="update/" method="post"
									modelAttribute="vendorUpdate">
									<div class="row">
										<div class="col-xs-6 col-sm-6 col-md-6">
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
			<div id="menu1" class="tab-pane fade">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Product Name</th>
							<th scope="col">Category</th>
							<th scope="col">Description</th>
							<th scope="col">Quantity</th>
							<th scope="col">Image</th>
							<th scope="col">Manage</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="product" items="${products}">

							<tr>
								<th scope="row">${product.productId }</th>
								<td>${product.product_name }</td>
								<td>${product.product_category }</td>
								<td>${product.product_description }</td>
								<td>${product.product_quantity }</td>
								<td>${product.product_image }</td>
								<td><a data-toggle="modal" data-target="#exampleModal"
									href="product/edit/${product.productId }">Edit</a> <a
									href="product/delete/${product.productId }">Delete</a></td>

							</tr>
							<div class="modal fade" id="exampleModal" tabindex="-1"
								role="dialog">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title">Edit Product</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">
											<div class="panel-body">
												<form:form action="product/update/${product.productId}"
													method="post" modelAttribute="updateproduct">
													<div class="row">
														<div class="col-xs-6 col-sm-6 col-md-6">
															<div class="form-group">
																<input type="text" name="product_name" id="product_name"
																	class="form-control input-sm"
																	placeholder="Product Name"
																	value="${product.product_name}">
															</div>
														</div>
														<div class="col-xs-6 col-sm-6 col-md-6">
															<div class="form-group">
																<select name="product_category" id="product_category"
																	class="form-control input-sm"
																	placeholder="Product category">
																	<c:forEach var="category" items="${products}">
																		<option value="${category.product_category}">${category.product_category}</option>
																	</c:forEach>

																</select>

															</div>
														</div>
													</div>

													<div class="form-group">
														<input type="text" name="product_description"
															id="product_description" class="form-control input-sm"
															placeholder="Product description"
															value="${product.product_description}">
													</div>

													<div class="form-group">
														<input type="number" name="product_quantity"
															id="product_quantity" class="form-control input-sm"
															placeholder="Product quantity"
															value="${product.product_quantity}">
													</div>

													<div class="form-group">
														<input type="file" name="product_image" id="product_image"
															class="form-control input-sm" placeholder="Product Image"
															value="value="${product.product_image}">
													</div>

													<input type="submit" value="Update Product"
														class="btn btn-info btn-block">

												</form:form>
											</div>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Cancel</button>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</tbody>
				</table>

			</div>
			<div id="menu2" class="tab-pane fade">
				<div class="row centered-form">
					<div
						class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<strong>Vendor Add Product Form</strong>
								</h3>
							</div>
							<div class="panel-body">
								<form:form action="addProduct" method="post"
									modelAttribute="product">
									<div class="row">
										<div class="col-xs-6 col-sm-6 col-md-6">
											<div class="form-group">
												<input type="hidden" name="vendorId" id="vendor_id"
													class="form-control input-sm" placeholder="Vendor Id"
													value="<%=request.getParameter("vendorId")%>"> <input
													type="text" name="product_name" id="product_name"
													class="form-control input-sm" placeholder="Product Name">
											</div>
										</div>
										<div class="col-xs-6 col-sm-6 col-md-6">
											<div class="form-group">
												<select name="product_category" id="product_category"
													class="form-control input-sm"
													placeholder="Product category">
													<c:forEach var="category" items="${products}">
														<option value="${category.product_category}">${category.product_category}</option>
													</c:forEach>

												</select>
											</div>
										</div>
									</div>

									<div class="form-group">
										<input type="text" name="product_description"
											id="product_description" class="form-control input-sm"
											placeholder="Product description">
									</div>

									<div class="form-group">
										<input type="number" name="product_quantity"
											id="product_quantity" class="form-control input-sm"
											placeholder="Product quantity">
									</div>

									<div class="form-group">
										<input type="file" name="product_image" id="product_image"
											class="form-control input-sm" placeholder="Product Image">
									</div>

									<input type="submit" value="Add Product"
										class="btn btn-info btn-block">

								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>