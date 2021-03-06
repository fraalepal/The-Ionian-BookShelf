<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="petclinic" tagdir="/WEB-INF/tags"%>
<petclinic:layout pageName="master.page.signUp">

	<h1>Register your new account here</h1>
	<br />
	<h2>Roles are above each image</h2>
	<div>
		<b>Summoner</b>
	</div>
	<span> <a href="createSummoner"> <img alt="Summoner"
			src="<spring:url value="/resources/images/summoner-signup-icon.png" htmlEscape="true" />"
			width="30%" height="30%">
	</a>
	</span>
	<br />
	<br />
	<br />
	<a href="/login" class="btn btn-default">Cancel</a>
</petclinic:layout>