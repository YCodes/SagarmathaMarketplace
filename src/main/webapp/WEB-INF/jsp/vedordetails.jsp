<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value='/resources/css/home.css'/>" rel="stylesheet" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Clinic Appointment System</title>
<tags:basecss></tags:basecss>
</head>
<body>
	<div id="main">
		<!-- <h2>Welcome!</h2> -->
		<c:if test="${empty currentUser}">
			<p>Nothing to displacy</p>
		</c:if>
		<c:if test="${not empty currentUser}">
			<!-- <p>Select a task that you would like to perform:</p> -->
			<c:choose>
				<c:when test="${currentUser.role == 'Admin'}">
				
				</c:when>
				<c:when test="${currentUser.role == 'Vendor'}">
				<a class="list-group-item"
						href="<c:url value="vendorSignup" />">View vendor
						Details</a>
				</c:when>
				<c:when test="${currentUser.role == 'Customer'}">
					<a class="list-group-item"
						href="<c:url value="customerSignup" />">View Personal
						Details</a>
					
				</c:when>

			</c:choose>
		</c:if>
	</div>

</body>
</html>