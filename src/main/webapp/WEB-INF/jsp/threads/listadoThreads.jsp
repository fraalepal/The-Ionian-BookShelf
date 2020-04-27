<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags"%>

<petclinic:layout pageName="threads">
	<h2>Threads</h2>

	<table id="threadsTable" class="table table-striped">
		<thead>
			<tr>
				<th style="width: 150px;">Title</th>
				<th style="width: 200px;">Description</th>
				<th style="width: 120px;">Punctuation</th>
				<security:authorize
					access="isAuthenticated()">
					<th style="width: 120px;">Vote</th>
				</security:authorize>
				<security:authorize
					access="hasAnyAuthority('administrator','reviewer')">
					<th style="width: 120px;">Actions</th>
				</security:authorize>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${threads}" var="thread">
				<tr>
				
					<td><spring:url value="/threads/{threadId}" var="threadUrl">
							<spring:param name="threadId" value="${thread.id}" />
						</spring:url> <a href="${fn:escapeXml(threadUrl)}"><c:out
								value="${thread.title}" /></a></td>
								
					<td><c:out value="${thread.description}" /></td>
					<td><c:out value="${thread.punctuation}" /></td>
					<security:authorize access="isAuthenticated()">
						<td>	
							<spring:url value="/threads/{threadId}/upVote"
								var="threadUpVote">
								<spring:param name="threadId" value="${thread.id}"></spring:param>
							</spring:url> <a href="${fn:escapeXml(threadUpVote)}">Up Vote Thread</a>
							<br>
							<spring:url value="/threads/{threadId}/downVote"
								var="threadUpVote">
								<spring:param name="threadId" value="${thread.id}"></spring:param>
							</spring:url> <a href="${fn:escapeXml(threadUpVote)}">Down Vote Thread</a>
						</td>
					</security:authorize>

					<security:authorize
						access="hasAnyAuthority('administrator','reviewer')">
						<td><spring:url value="/threads/{threadId}/remove"
								var="threadRemoveUrl">
								<spring:param name="threadId" value="${thread.id}"></spring:param>
							</spring:url> <a href="${fn:escapeXml(threadRemoveUrl)}">Remove Thread</a>
						</td>
					</security:authorize>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>

<security:authorize access="isAuthenticated()">
	<spring:url value="/threads/new" var="addThreadUrl" />
	<a href="${fn:escapeXml(addThreadUrl)}" class="btn btn-default">Add
		New Thread</a>
</security:authorize>

</petclinic:layout>
