<%@include file="navigation.jsp"%>

<div id="tooplate_slider" class="section_content">

	<div id="tooplate_main">
		<span class="main_border main_border_t"></span><span
			class="main_border main_border_b"></span>
		<div class="product">
			<h1>Products</h1>
			<c:forEach var="product" items="${products}">
				<div class="product_box">
					<div class="img_box">
						<img class="img-circle"
							src="${pageContext.request.contextPath}/resources/images/${product.photoURL}.png"
							width="100" />
					</div>
					<h2><a href="product/productdetails/${product.productId}">${product.product_name}</a></h2>
							<p>Quantity available:${product.product_quantity}</p>
							<p>Price: ${product.product_price}</p>
					

				</div>
			</c:forEach>

		</div>

		<div class="clear h20"></div>
		<hr />
		<div class="clear h10"></div>
		<div class="clear"></div>
	</div>
	<!-- END of main -->

</div>
<!-- END of wrapper -->

<%@ include file="footer.jsp"%>