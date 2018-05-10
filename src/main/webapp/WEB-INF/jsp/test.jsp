<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Sagarmatha Marketplace</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Dropdown Hover CSS -->
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/bootstrap-dropdownhover.min.css" rel="stylesheet">

<link href="<c:url value='/resources/css/test.css'/>" rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



</head>
<body>
	<div class="header">
		<a href="<c:url value='/'/>">Sagarmatha Marketplace</a>
	</div>
	<nav class="navbar navbar-inverse bg-primary" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" style="color: white" href="/home">Home</a>
			</div>

			<ul class="nav navbar-nav navbar-center">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> Category </a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<c:forEach var="category" items="${categories}">
							<li><a
								href="<c:url value='/home?categoryId=${category.categoryId}' />">${category.categoryName}</a>
							</li>
						</c:forEach>

					</ul></li>
			</ul>
		</div>
	</nav>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Bootstrap Dropdown Hover JS -->
	<script src="js/bootstrap-dropdownhover.min.js"></script>
</body>
</html>
