<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sagarmatha Marketplace - Admin</title>

<meta name="keywords" content="" />
<meta name="description" content="" />

<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link href="<c:url value='/resources/css/tooplate_style.css'/>"
	rel="stylesheet" />
<link href="<c:url value='/resources/css/ddsmoothmenu.css'/>"
	rel="stylesheet" />
<link href="<c:url value='/resources/css/admindashboard.css'/>"
	rel="stylesheet" />



<script type="text/javascript"
	src="<c:url value='/resources/js/jquery.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/ddsmoothmenu.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/custom.js'/>"></script>


<script type="text/javascript"
	src="<c:url value='/resources/js/jquery-1.3.2.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery.easing.1.3.js'/>"></script>
<link href="<c:url value='/resources/css/slimbox2.css'/>"
	rel="stylesheet" media="screen" />
<script type="text/javascript"
	src="<c:url value='/resources/js/slimbox2.js'/>"></script>

</head>
<body>
	<div id="tooplate_wrapper">
		<div id="tooplate_header">
			<div id="header_top">
				<div id="site_title">
					<a href="<c:url value='/'/>">Sagarmatha Marketplace</a>
				</div>
				<tags:header></tags:header>
			</div>
			
			<!-- END of header top -->