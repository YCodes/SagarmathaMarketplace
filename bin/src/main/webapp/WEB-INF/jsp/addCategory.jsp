<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="<c:url value='/resources/css/login.css'/>" rel="stylesheet" />


<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<strong> Add Product Category</strong>
					</div>
					<div class="panel-body">
						<form:form role="form" action="addProductCategory" method="POST" modelAttribute="category">
							<fieldset>
								<div class="row">
									<div>
										<img class="profile-img"
											src="<c:url value='/resources/images/addProductImage.jpg'/>"
											alt="loginimage">
									</div>
								</div>
								<div class="form-group">
									<label>Category Name</label><input type="text" class="form-control" name="categoryName" id="addCategory">
								</div>
								<div class="form-group">
									<label>Description</label><input type="text" class="form-control" name="categoryDescription" id="description">
								</div>
								
								<input type="submit" value="Submit" class="btn btn-info"/>
							</fieldset>
						</form:form>
					</div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>