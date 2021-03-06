<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags"%>

<petclinic:layout pageName="banned">

	<spring:url value="/resources/images/pets.png" var="petsImage" />
	<img src="${petsImage}" />

	<h2>You are banned.</h2>

	<p>${exception.message}</p>

</petclinic:layout>
