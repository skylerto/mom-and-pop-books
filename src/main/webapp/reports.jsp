<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/<%= org.webjars.AssetLocator.getWebJarPath("css/bootstrap.min.css")%>">
<style>
body {
	padding-top: 50px;
}
</style>
<title>Mom and Pop Books</title>
</head>
<body>
	<jsp:include page="nav.jsp" />

	<div class="container">
		<h1>Visits</h1>
		<ol>
			<c:forEach var="item" items="${visits}">
				<li><span>${item.key.getTitle()}: ${item.value} visits.<span></li>
			</c:forEach>
		</ol>
	</div>

	<jsp:include page="js-includes.jsp" />
</body>
</html>
