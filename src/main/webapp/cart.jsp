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
			<c:if test="${not empty sessionScope['error']}">
				<div class="alert alert-danger" role="alert">
					<span class="glyphicon glyphicon-exclamation-sign"
						aria-hidden="true"></span> <span class="sr-only">Error:</span>
					${sessionScope['error'] }
				</div>
			</c:if>
			<ol>
				<c:forEach var="item"
					items="${sessionScope['cart'].get().getBooks()}">
					<span id="bid" style="visibility: hidden"> ${ item.getBid()}</span>
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
						</a> <span id="bid" style="display: none;" class="bid"> ${ item.getBid()}</span>
						<button type="button" class="remove-btn" id="remove-btn">Remove</button>
					</div>
				</c:forEach>
			</ol>
			<div class="row" style="float: right; padding-right: 2em;">
				<h3>
					Total Value:
					<fmt:formatNumber type="currency" currencySymbol="$">${ sessionScope['cart'].getSum()}</fmt:formatNumber>
				</h3>
				<h3>
					<a href="${pageContext.request.contextPath}/checkout">Check Out</a>
				</h3>
			</div>
		</div>
	</div>

	<jsp:include page="js-includes.jsp" />
</body>
</html>
