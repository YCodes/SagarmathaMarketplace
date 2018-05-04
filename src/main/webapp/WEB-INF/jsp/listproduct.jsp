<%@ include file="admindashboard.jsp"%>

<div id="header_bottom">
	<p>
		<a href="<c:url value='/vendor/dashboard'/>">Vendor Dashboard  |</a> <a
			href="<c:url value='/vendor/listproduct'/>">List Product | </a><a
			href="<c:url value='/vendor/addproduct'/>">Add Product</a>
	</p>

</div>
<!-- END of header bottom -->
</div>
<!-- END of header -->
<div id="tooplate_main">
	<span class="main_border main_border_t"></span><span
		class="main_border main_border_b"></span>

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
								<th scope="row">${product.productId}</th>
								<td>${product.product_name }</td>
								<td>${product.product_category }</td>
								<td>${product.product_description }</td>
								<td>${product.product_quantity }</td>
								<td>${product.product_image }</td>
								<td><a data-toggle="modal" data-target="#exampleModal${product.productId }" class="editLink"
									href="#">Edit</a> <a
									href="product/delete/${product.productId }">Delete</a></td>

							</tr>
							<div class="modal" id="exampleModal${product.productId}" tabindex="-1"
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
																<input type="text" name="product_name" id="edit_product_name"
																	class="form-control input-sm"
																	placeholder="Product Name"
																	value="${product.product_name}">
															</div>
														</div>
														<div class="col-xs-6 col-sm-6 col-md-6">
															<div class="form-group">
																<select name="product_category" id="edit_product_category"
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
															id="edit_product_description" class="form-control input-sm"
															placeholder="Product description"
															value="${product.product_description}">
													</div>

													<div class="form-group">
														<input type="number" name="product_quantity"
															id="edit_product_quantity" class="form-control input-sm"
															placeholder="Product quantity"
															value="${product.product_quantity}">
													</div>

													<div class="form-group">
														<input type="file" name="product_image" id="edit_product_image"
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
				<div class="clear"></div>
</div>
<!-- END of main -->


<%@ include file="footer.jsp"%>