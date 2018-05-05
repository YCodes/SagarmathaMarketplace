<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<link href="<c:url value='/resources/css/header.css'/>" rel="stylesheet" />

<div id="header">
	<%-- <security:authorize access="isAnonymous()">
		<a href="<spring:url value='/login' />">Login</a>
	</security:authorize> --%>
	<security:authorize access="isAuthenticated()">
		<span><i><strong>User: <security:authentication
						property="principal.username" /></strong></i></span>
			&nbsp;&nbsp;&nbsp; ||  <i><a id="logout"
			onclick="document.getElementById('logout-form').submit();">Logout</a></i>
		<form id="logout-form"
			action="<spring:url value="/login"></spring:url>" method="post"
			class="hidden">
			<security:csrfInput />
		</form>
	</security:authorize>
</div>