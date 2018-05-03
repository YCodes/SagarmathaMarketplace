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
										value="${vendorId}"> <input
										type="text" name="product_name" id="product_name"
										class="form-control input-sm" placeholder="Product Name">
								</div>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<select name="product_category" id="product_category"
										class="form-control input-sm" placeholder="Product category">
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

	<div class="clear"></div>
</div>
<!-- END of main -->


<%@ include file="footer.jsp"%>