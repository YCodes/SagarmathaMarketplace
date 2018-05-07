<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sagarmatha Marketplace</title>

<meta name="keywords" content="" />
<meta name="description" content="" />

<link href="<c:url value='/resources/css/tooplate_style.css'/>"
	rel="stylesheet" />
<link href="<c:url value='/resources/css/ddsmoothmenu.css'/>"
	rel="stylesheet" />


<script type="text/javascript"
	src="<c:url value='/resources/js/jquery.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/ddsmoothmenu.js'/>"></script>


<script type="text/javascript">
	ddsmoothmenu.init({
		mainmenuid : "tooplate_menu", //menu DIV id
		orientation : 'h', //Horizontal or vertical menu: Set to "h" or "v"
		classname : 'ddsmoothmenu', //class added to menu's outer DIV
		//customtheme: ["#1c5a80", "#18374a"],
		contentsource : "markup" //"markup" or ["container_id", "path_to_menu_file"]
	})
</script>

<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/resources/css/jquery.dualSlider.0.2.css'/>" />

<script type="text/javascript"
	src="<c:url value='/resources/js/jquery-1.3.2.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery.easing.1.3.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery.timers-1.2.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery.dualSlider.0.3.min.js'/>"></script>


<script type="text/javascript">
	$(document).ready(function() {

		$("#carousel").dualSlider({
			auto : false,
			autoDelay : 6000,
			easingCarousel : "swing",
			easingDetails : "easeOutBack",
			durationCarousel : 1000,
			durationDetails : 600
		});

	});
</script>

<link href="<c:url value='/resources/css/slimbox2.css'/>"
	rel="stylesheet" media="screen" />
	
<link href="<c:url value='/resources/css/homenavigation.css'/>"
	rel="stylesheet" media="screen" />
<script type="text/javascript"
	src="<c:url value='/resources/js/slimbox2.js'/>"></script>

<link href="<c:url value='/resources/css/paymentDetail.css'/>" rel="stylesheet" />
</head>
<body class="homepage navigationbar">
	<div id="tooplate_wrapper">
		<div id="tooplate_header">
			<div id="header_top">
				<div id="site_title">
					<a href="<c:url value='/'/>">Sagarmatha Marketplace</a>
				</div>
				<div id="tooplate_menu" class="ddsmoothmenu">
					<ul>
						<li><a href="<c:url value='/products'/>">Category</a>

							<ul>
								<c:forEach var="category" items="${categories}">
									<li><a href="<c:url value='/? ${category.categoryId}' />">${category.categoryName}</a></li>
								</c:forEach>
							</ul>
					</ul>
					<br style="clear: left" />
				</div>
				<!-- end of tooplate_menu -->
			</div>
			<!-- END of header top -->

			<div id="header_bottom">
				<p>
					<a href="<c:url value='/shoppingcart'/>">My Cart</a> 
				</p>
				
				<div id="tooplate_search">
					<form action="#" method="get">
						<input type="text" value=" " name="keyword" id="keyword"
							title="keyword" onfocus="clearText(this)"
							onblur="clearText(this)" class="txt_field" /> <input
							type="submit" name="Search" value=" " alt="Search"
							id="searchbutton" title="Search" class="sub_btn" />
					</form>
					<tags:header></tags:header>
				</div>
			</div>
			<!-- END of header bottom -->
		</div>
		<!-- END of header -->

<div id="tooplate_main">
	<span class="main_border main_border_t"></span><span
		class="main_border main_border_b"></span>
		
		
	<div class="container">
	
		<div class="col col_2">
			<h3>Address</h3>
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
			
			<br />
			<br />
			
			<h3>Secure Payment</h3>
			<form:form role="form" action="confirmPayment" method="POST"
				modelAttribute="payment">
				<div class="form-group">
					<label>Card Holder</label><input type="text" class="form-control"
						name="cardHolder" id="cardHolder" style="width: 300px;"> 
					<label>CVV</label><input type="text" class="form-control" name="cvv" id="cvv"
						style="width: 300px;">
						
                    <ul class="cards">
                        <li class="visa">Visa</li>
                        <li class="mastercard">MasterCard</li>
                        
                    </ul>
                    <div class="clear"></div>
                                   
                    
					<label>Card Number</label><input type="text" class="form-control" name="cardNumber" id="cardNumber"
						style="width: 300px;"> 
					<label>Expiration Date</label>
					<select style="margin-bottom: 10px; margin-right: 10px; width: 200px" name='expireMM' id='expireMM'>
						<option value=''>Month</option>
						<option value='01'>January</option>
						<option value='02'>February</option>
						<option value='03'>March</option>
						<option value='04'>April</option>
						<option value='05'>May</option>
						<option value='06'>June</option>
						<option value='07'>July</option>
						<option value='08'>August</option>
						<option value='09'>September</option>
						<option value='10'>October</option>
						<option value='11'>November</option>
						<option value='12'>December</option>
					</select>
					<select style="margin-bottom: 10px; width: 90px" name='expireYY' id='expireYY'>
						<option value=''>Year</option>
						<option value='18'>2018</option>
						<option value='19'>2019</option>
						<option value='20'>2020</option>
						<option value='21'>2021</option>
						<option value='22'>2022</option>
						<option value='23'>2023</option>
					</select>
					<label>Zip Code</label><input type="text" class="form-control"
						name="zipcode" id="zipcode" pattern="^\d{5}$" style="width: 300px;"> 
				</div>
				<br />
				<input type="submit" value="Submit" class="btn btn-info" />

			</form:form>
		</div>
		
		<div class="col col_2">
		<!--REVIEW ORDER-->
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3 style="display: inline-block">Review Order</h3> <div class="pull-right"><small><a class="afix-1" href="#">Edit Cart</a></small></div>
                        </div>
                        
                        <div class="panel-body">
                            <div class="form-group">
                                <div class="col-sm-3 col-xs-3">
                                    <img class="img-responsive" src="//c1.staticflickr.com/1/466/19681864394_c332ae87df_t.jpg" />
                                </div>
                                <div class="col-sm-6 col-xs-6">
                                    <div class="col-xs-12">Product name</div>
                                    <div class="col-xs-12"><small>Quantity:<span>1</span></small></div>
                                </div>
                                <div class="col-sm-3 col-xs-3 text-right">
                                    <h6><span>$</span>25.00</h6>
                                </div>
                            </div>
                            <div class="form-group"><hr /></div>
                            <div class="form-group">
                                <div class="col-sm-3 col-xs-3">
                                    <img class="img-responsive" src="//c1.staticflickr.com/1/466/19681864394_c332ae87df_t.jpg" />
                                </div>
                                <div class="col-sm-6 col-xs-6">
                                    <div class="col-xs-12">Product name</div>
                                    <div class="col-xs-12"><small>Quantity:<span>1</span></small></div>
                                </div>
                                <div class="col-sm-3 col-xs-3 text-right">
                                    <h6><span>$</span>25.00</h6>
                                </div>
                            </div>
                            <div class="form-group"><hr /></div>
                            <div class="form-group">
                                <div class="col-sm-3 col-xs-3">
                                    <img class="img-responsive" src="//c1.staticflickr.com/1/466/19681864394_c332ae87df_t.jpg" />
                                </div>
                                <div class="col-sm-6 col-xs-6">
                                    <div class="col-xs-12">Product name</div>
                                    <div class="col-xs-12"><small>Quantity:<span>2</span></small></div>
                                </div>
                                <div class="col-sm-3 col-xs-3 text-right">
                                    <h6><span>$</span>50.00</h6>
                                </div>
                            </div>
                            <div class="form-group"><hr /></div>
                            <div class="form-group">
                                <div class="col-xs-12">
                                    <strong>Subtotal</strong>
                                    <div class="pull-right"><span>$</span><span>200.00</span></div>
                                </div>
                                <div class="col-xs-12">
                                    <small>Shipping</small>
                                    <div class="pull-right"><span>-</span></div>
                                </div>
                            </div>
                            <div class="form-group"><hr /></div>
                            <div class="form-group">
                                <div class="col-xs-12">
                                    <strong>Order Total</strong>
                                    <div class="pull-right"><span>$</span><span>150.00</span></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--REVIEW ORDER END-->
		</div>
		
	</div>

	<div class="clear"></div>
</div>
<!-- END of main -->

<%@ include file = "footer.jsp" %>