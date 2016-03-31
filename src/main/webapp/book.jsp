<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/<%= org.webjars.AssetLocator.getWebJarPath("css/bootstrap.min.css")%>">
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
				<div class="col-lg-6">
				<c:choose>
					<c:when test="${book.getCategory() eq 'Science'}">
						<img class="thumbnail" src="" alt="Science" width="500" height="500">
					</c:when>
					<c:when test="${book.getCategory() eq 'Engineering'}">
						<img class="thumbnail" src="" alt="Engineering" width="500" height="500">
					</c:when>
					<c:when test="${book.getCategory() eq 'Fiction'}">
						<img class="thumbnail" src="" alt="Fiction" width="500" height="500">
					</c:when>
				</c:choose>
			</div>
				<div class="col-lg-6">
				<div class="caption">
					<h3>${book.getTitle()}</h3>
					<h4><fmt:formatNumber type="currency">${book.getPrice()}</fmt:formatNumber></h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>

					<!-- TODO: Add button for adding to cart -->

					<!-- TODO: Add review system for logged in users -->

				</div>
			</div>
		</div>

		<script src="${pageContext.request.contextPath}/<%= org.webjars.AssetLocator.getWebJarPath("jquery.min.js") %>"></script>
		<script src="${pageContext.request.contextPath}/<%= org.webjars.AssetLocator.getWebJarPath("bootstrap.min.js") %>"></script>
	</body>
</html>
