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
<title>Mom and Pop Books | Cart</title>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<div class="row">
			<h1>Cart</h1>
		</div>
		<div class="container">
			<div class="row">
				<c:forEach var="item" items="${sessionScope['cart'].get()}">
					<div class="col-md-12">
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
						<button type="button" class="remove">Remove</button>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

	<script
		src="${pageContext.request.contextPath}/<%= org.webjars.AssetLocator.getWebJarPath("jquery.min.js") %>"></script>
	<script
		src="${pageContext.request.contextPath}/<%= org.webjars.AssetLocator.getWebJarPath("bootstrap.min.js") %>"></script>
	<script src="js/login.js"></script>
</body>
</html>
