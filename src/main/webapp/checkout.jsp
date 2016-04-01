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
			<h1>Checkout</h1>
		</div>
		<div class="container">
			<div class="row">
				<h2>Cart Items</h2>
			</div>
			<ol>
				<c:forEach var="item"
					items="${sessionScope['cart'].get().getBooks()}">
						<li>
							<a href="book/?book=${item.getBid()}">
								<div class="caption">
									<h3>${item.getTitle()}</h3>
								</div>
							</a>
							<button type="button" class="remove">Remove</button>
						</li>
				</c:forEach>
			</ol>
		</div>

		<div class="container">
			<div class="row">
				<h2>Address Information</h2>
				<!--  Show the users address information -->
				<c:if test="${not empty sessionScope['user']}">
					<c:if test="${not empty sessionScope['address']}">

						<div class="">
							<strong>Street:</strong> ${sessionScope['address'].getStreet() }
						</div>
						<div class="">
							<strong>Province:</strong>
							${sessionScope['address'].getProvince() }
						</div>
						<div class="">
							<strong>Country:</strong> ${sessionScope['address'].getCountry() }
						</div>
						<div class="">
							<strong>Zip:</strong> ${sessionScope['address'].getZip() }
						</div>
						<div class="">
							<strong>Phone:</strong> ${sessionScope['address'].getPhone() }
						</div>
					</c:if>
				</c:if>
			</div>
		</div>
		<div class="container">
			<div class="row" style="width: 60%;">
				<h3>Credit Card Information</h3>
				<form>
					<fieldset class="form-group">
						<label for="formGroupExampleInput">Card Holder First Name</label>
						<input type="text" class="form-control" required id="fname"
							placeholder="Card Holder First Name">
					</fieldset>
					<fieldset class="form-group">
						<label for="formGroupExampleInput">Card Holder Last Name</label> <input
							type="text" class="form-control" required id="lname"
							placeholder="Card Holder First Last">
					</fieldset>
					<fieldset class="form-group">
						<label for="formGroupExampleInput required">Card Number</label> <input
							type="text" class="form-control" id="ccnumber"
							placeholder="Credit Card Number required"> <label
							for="formGroupExampleInput">Security Code</label> <input
							type="text" class="form-control" id="lname"
							placeholder="Security Code">
					</fieldset>

					<fieldset class="form-group">
						<label for="exampleSelect1">Expiration Month</label> <select
							required class="form-control" id="emonth">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
							<option>6</option>
							<option>7</option>
							<option>8</option>
							<option>9</option>
							<option>10</option>
							<option>11</option>
							<option>12</option>
						</select> <label for="exampleSelect1">Expiration Yeah</label> <select
							required class="form-control" id="eyear">
							<option>16</option>
							<option>17</option>
							<option>18</option>
							<option>19</option>
							<option>20</option>
						</select>
					</fieldset>
				</form>
			</div>
		</div>
		<div class="container">
			<div class="row" style="float: right; padding-right: 2em;">
				<h3>
					Total Value:
					<fmt:formatNumber type="currency" currencySymbol="$">${ sessionScope['cart'].getSum()}</fmt:formatNumber>
				</h3>
				<h3>
					<a href="${pageContext.request.contextPath}/purchase">Purchase</a>
				</h3>
			</div>
		</div>
	</div>

	<script
		src="${pageContext.request.contextPath}/<%= org.webjars.AssetLocator.getWebJarPath("jquery.min.js") %>"></script>
	<script
		src="${pageContext.request.contextPath}/<%= org.webjars.AssetLocator.getWebJarPath("bootstrap.min.js") %>"></script>
	<script src="js/authentication.js"></script>
</body>
</html>
