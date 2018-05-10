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
		<c:url var="post_url" value = "/product/addToCart/${orderLine.productId}" />
		<form:form action="${post_url}"	method="post">
			<div class="card">
				<div class="row">
					<aside class="col-sm-5 border-right">
						<article class="gallery-wrap">
							<div class="img-big-wrap">
							<img class="img-circle"  src="${pageContext.request.contextPath}/resources/images/${orderLine.photoURL}.png" width="100"/>
							</div>
							<!-- slider-product.// -->
						</article>
						<!-- gallery-wrap .end// -->
					</aside>
					<aside class="col-sm-7">
						<article class="card-body">
							<h3 class="title mb-3">${orderLine.product_name}</h3>

							<p class="price-detail-wrap">
								<span class="price h3 text-warning"> <span
									class="currency">US $</span><span class="num">${orderLine.price}</span>
								</span>
							</p>
							<!-- price-detail-wrap .// -->
							<dl class="item-property">
								<dt>Description</dt>
								<dd>
									<p>${orderLine.product_description}</p>
								</dd>
							</dl>
							<hr>
							<div class="row">
								<div class="col-sm-12">
									<dl class="param param-inline">
										<dt>Quantity:</dt>
										<dd>
											<input name = "quantity" type= "number" class = "form-control" id="quantity" value = "1" />
											<%-- <select name="product-quantityDetail" id="product-quantity"
												class="form-control form-control-sm" style="width: 70px;">
												<c:forEach var="quantity" items="${quantities}">
													<option value="${quantity}">${quantity}</option>
												</c:forEach>
											</select> --%>
										</dd>
									</dl>
									<!-- item-property .// -->
								</div>
								<!-- col.// -->
							</div>

							<hr>
							<a<%-- href="<c:url value='/product/addToCart/${orderLine.product.productId}'/>" --%>
						>
								<button class="btn btn-lg btn-outline-primary text-uppercase"
									value="Add to cart">Add To Cart</button>
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
<%@ include file="footer.jsp"%>