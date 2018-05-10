<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ include file="navigation.jsp"%>

<div class="container">
	<c:url var="post_url" value="/product/addToCart/${orderLine.productId}" />
	<form:form action="${post_url}" method="post">
		<div class="card">
			<div class="row">
				<aside class="col-sm-5 border-right">
						<img class="img-circle"
							src="${pageContext.request.contextPath}/resources/images/${orderLine.photoURL}.png"
							width="456" />					</aside>
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
										<input name="quantity" type="text" class="form-control"
											id="quantity" value="1" pattern="^[1-9][0-9]*$" />
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
