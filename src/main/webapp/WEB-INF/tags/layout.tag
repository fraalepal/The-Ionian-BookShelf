<%@ tag trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags"%>

<%@ attribute name="pageName" required="true"%>
<%@ attribute name="customScript" required="false" fragment="true"%>

<!doctype html>
<html>
<petclinic:htmlHeader htmlHeader="${pageName}" />
<body>
	<petclinic:bodyHeader menuName="${pageName}" />

	<div class="container-fluid">
		<div class="container xd-container">

			<jsp:doBody />

			<petclinic:pivotal />
		</div>
	</div>
	<petclinic:footer />
	<jsp:invoke fragment="customScript" />

</body>

</html>
