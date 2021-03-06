<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ include file="navigation.jsp"%>

<div id="tooplate_slider" class="section_content">

	<div id="tooplate_main">
		<span class="main_border main_border_t"></span><span
			class="main_border main_border_b"></span>
	<c:url var="post_url" value="/product/addToCart/${orderLine.productId}" />
	<form:form action="${post_url}" method="post">
		<div class="card">
			<div class="row">
				<aside class="col-sm-4 border-right">
						<img src="${pageContext.request.contextPath}/resources/images/${orderLine.photoURL}.png"
							width="300px" />					</aside>
				<aside class="col-sm-6">
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
										<input name="quantity" type="number" class="form-control"
											id="quantity" value="1" min="1" />
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
	</div>
	<%@ include file="footer.jsp"%>
