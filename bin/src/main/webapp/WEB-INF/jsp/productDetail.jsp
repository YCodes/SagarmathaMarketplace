<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="<c:url value='/resources/css/productDetail.css'/>"
	rel="stylesheet" />
<link>
</head>
<body>
	<div class="container">
		<form:form action="productDetail" method="post"
			modelAttribute="product">
			<div class="card">
				<div class="row">
					<aside class="col-sm-5 border-right">
						<article class="gallery-wrap">
							<div class="img-big-wrap">
								<div>
									<a href="#"><img
										src="https://s9.postimg.org/tupxkvfj3/image.jpg"></a>
								</div>
							</div>
							<!-- slider-product.// -->
						</article>
						<!-- gallery-wrap .end// -->
					</aside>
					<aside class="col-sm-7">
						<article class="card-body">
							<h3 class="title mb-3">Original Version of Some product name</h3>

							<p class="price-detail-wrap">
								<span class="price h3 text-warning"> <span
									class="currency">US $</span><span class="num">1299</span>
								</span>
							</p>
							<!-- price-detail-wrap .// -->
							<dl class="item-property">
								<dt>Description</dt>
								<dd>
									<p>This is the description field</p>
								</dd>
							</dl>
							<hr>
							<div class="row">
								<div class="col-sm-12">
									<dl class="param param-inline">
										<dt>Quantity:</dt>
										<dd>
											<select class="form-control form-control-sm"
												style="width: 70px;">
												<option> 1 </option>
												<option> 2 </option>
												<option> 3 </option>
											</select>
										</dd>
									</dl>
									<!-- item-property .// -->
								</div>
								<!-- col.// -->
							</div>

							<hr>
							<a href="#" class="btn btn-lg btn-outline-primary text-uppercase">
								<i class="fas fa-shopping-cart"></i> Add to cart
							</a>
						</article>
						<!-- card-body.// -->
					</aside>
					<!-- col.// -->
				</div>
				<!-- row.// -->
			</div>
			<!-- card.// -->


		</form:form>



	</div>
	<!--container.//-->



</body>
</html>