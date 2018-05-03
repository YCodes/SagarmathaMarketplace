<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sagarmatha Marketplace</title>

<meta name="keywords" content="" />
<meta name="description" content="" />

<link href="<c:url value='/resources/css/tooplate_style.css'/>" rel="stylesheet" />
<link href="<c:url value='/resources/css/ddsmoothmenu.css'/>" rel="stylesheet" />


<script type="text/javascript" src="<c:url value='/resources/js/jquery.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/ddsmoothmenu.js'/>"></script>


<script type="text/javascript">

ddsmoothmenu.init({
	mainmenuid: "tooplate_menu", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})

</script>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/resources/css/jquery.dualSlider.0.2.css'/>" />

<script type="text/javascript" src="<c:url value='/resources/js/jquery-1.3.2.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery.easing.1.3.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery.timers-1.2.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery.dualSlider.0.3.min.js'/>"></script>


<script type="text/javascript">
    
    $(document).ready(function() {
        
        $("#carousel").dualSlider({
            auto:false,
            autoDelay: 6000,
            easingCarousel: "swing",
            easingDetails: "easeOutBack",
            durationCarousel: 1000,
            durationDetails: 600
        });
        
    });
    
    
</script>

<link href="<c:url value='/resources/css/slimbox2.css'/>" rel="stylesheet" media="screen" />
<script type="text/javascript" src="<c:url value='/resources/js/slimbox2.js'/>"></script>

</head>
<body>
<div id="tooplate_wrapper">
		<div id="tooplate_header">
	    	<div id="header_top">
	        	<div id="site_title"><a href="<c:url value='/'/>">Sagarmatha Marketplace</a></div>
	            <div id="tooplate_menu" class="ddsmoothmenu">
	                <ul>
	                    <li><a href="<c:url value='/'/>" class="selected">Home</a></li>
                    <li><a href="<c:url value='/products'/>">Products</a>
                    
                    <ul>
                        <c:forEach var="category" items="${categories}">
                            <li><a href="<c:url value='/? ${category.categoryId}' />">${category.categoryName}</a></li>
                        </c:forEach>
                    </ul>
                    
	                    <li><a href="contact.html" class="last">Contact</a></li>
	                </ul>
	                <br style="clear: left" />
	            </div> <!-- end of tooplate_menu -->
	        </div> <!-- END of header top -->
	        
	        <div id="header_bottom">
	        	<p>
	            <a href="<c:url value='/shoppingcart'/>">My Cart</a> | 
	            <a href="<c:url value='/checkout'/>">Check Out</a> |
	        	<span>Item in Cart ( 10 )</span>
	            </p>
	            
	             <div id="tooplate_search">
	                <form action="#" method="get">
	                  <input type="text" value=" " name="keyword" id="keyword" title="keyword" onfocus="clearText(this)" onblur="clearText(this)" class="txt_field" />
	                  <input type="submit" name="Search" value=" " alt="Search" id="searchbutton" title="Search" class="sub_btn"  />
	                </form>
	            </div>
	        </div> <!-- END of header bottom -->
	    </div> <!-- END of header -->

