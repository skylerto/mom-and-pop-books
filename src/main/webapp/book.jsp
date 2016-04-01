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
							<img class="thumbnail" src="" alt="Science" width="250" height="250">
						</c:when>
						<c:when test="${book.getCategory() eq 'Engineering'}">
							<img class="thumbnail" src="" alt="Engineering" width="250" height="250">
						</c:when>
						<c:when test="${book.getCategory() eq 'Fiction'}">
							<img class="thumbnail" src="" alt="Fiction" width="250" height="250">
						</c:when>
					</c:choose>
				</div>
				<div class="col-lg-6">
					<div class="caption">
						<h3>${book.getTitle()}</h3>
						<h4><fmt:formatNumber type="currency">${book.getPrice()}</fmt:formatNumber></h4>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>

						<!-- TODO: Add button for adding to cart -->

					</div>
				</div>
			</div>
		</div>

		<div class="container">
			<div class="col-sm-12">

				<form id="reviewForm" role="form">
					<div class="panel panel-default">
						<c:choose>
							<c:when test="${true}">
								<div class="panel-heading">New Comment -- Anonymous User</div>
							</c:when>
							<c:otherwise>
								<div class="panel-heading">New Comment -- Logged In User</div>
							</c:otherwise>
						</c:choose>
						<div class="panel-body">
							<textarea name="review" class="form-control" rows="5"></textarea>
							<input type="hidden" name="bid" value="${param.book}">
							<button id="review-btn" type="button" class="btn btn-success">Submit</button>
						</div>
					</div>
				</form>

				<c:forEach var="review" items="${reviews}">
					<div class="panel panel-default">
						<c:choose>
							<c:when test="${empty review.getUser()}">
								<div class="panel-heading">Anonymous User</div>
							</c:when>
							<c:otherwise>
								<div class="panel-heading">${ review.getUser().getUserName()}</div>
							</c:otherwise>
						</c:choose>
						<div class="panel-body">
							${review.getReview()}
						</div>
					</div>
				</c:forEach>
			</div>
		</div>

		<jsp:include page="js-includes.jsp" />
	</body>
</html>
