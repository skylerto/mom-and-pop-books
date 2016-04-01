<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
			<div class="col-lg-6">
				<c:choose>
					<c:when test="${book.getCategory() eq 'Science'}">
						<img class="thumbnail" src="" alt="Science" width="500"
							height="500">
					</c:when>
					<c:when test="${book.getCategory() eq 'Engineering'}">
						<img class="thumbnail" src="" alt="Engineering" width="500"
							height="500">
					</c:when>
					<c:when test="${book.getCategory() eq 'Fiction'}">
						<img class="thumbnail" src="" alt="Fiction" width="500"
							height="500">
					</c:when>
				</c:choose>
			</div>
			<div class="col-lg-6">
				<div class="caption">
					<h3>${book.getTitle()}</h3>
					<h4>
						<fmt:formatNumber type="currency">${book.getPrice()}</fmt:formatNumber>
					</h4>
					<p>${book.getDescription()}</p>
					<!-- TODO: Add button for adding to cart -->

					<!-- TODO: Add review system for logged in users -->

				</div>
			</div>
		</div>
	</div>

	<jsp:include page="js-includes.jsp" />
</body>
</html>
