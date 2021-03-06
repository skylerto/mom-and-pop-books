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
		<div class="row">
			<h1>
				Product Catalog
				<c:if test="${not empty sessionScope['category']}">
					| ${sessionScope['category'] }	
				</c:if>
			</h1>
		</div>
		<div class="row">
			<c:if test="${not empty sessionScope['confirm']}">
				<div class="alert alert-success" role="alert">
					<span class="glyphicon glyphicon-exclamation-	sign"
						aria-hidden="true"></span> <span class="sr-only">Error:</span>
					${sessionScope['confirm'] }
				</div>
			</c:if>
		</div>

		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
			do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
			enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
			ut aliquip ex ea commodo consequat. Duis aute irure dolor in
			reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
			pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
			culpa qui officia deserunt mollit anim id est laborum.</p>
	</div>

	<div class="container">
		<div class="row">
			<c:forEach var="item" items="${books}">
				<div class="col-md-4">
					<a href="book/?book=${item.getBid()}"> <c:choose>
							<c:when test="${item.getCategory() eq 'Science'}">
								<img class="thumbnail" src="" alt="Science" width="200"
									height="200">
							</c:when>
							<c:when test="${item.getCategory() eq 'Engineering'}">
								<img class="thumbnail" src="" alt="Engineering" width="200"
									height="200">
							</c:when>
							<c:when test="${item.getCategory() eq 'Fiction'}">
								<img class="thumbnail" src="" alt="Fiction" width="200"
									height="200">
							</c:when>
						</c:choose>
						<div class="caption">
							<h3>${item.getTitle()}</h3>
						</div>
					</a>
				</div>
			</c:forEach>
		</div>
	</div>

	<jsp:include page="js-includes.jsp" />
</body>
</html>
