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

	<div class="container col-md-8 col-md-offset-2">
		<h1>Monthly Reports</h1>
		<form id="monthlyForm">
			<fieldset class="form-group">
				<legend>Select month and year</legend>
				<label>Month</label>
				<select required class="form-control" name="month">
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
				</select>
				<label>Year</label>
				<select required class="form-control" name="year">
					<option>12</option>
					<option>13</option>
					<option>14</option>
					<option>16</option>
					<option>17</option>
					<option>18</option>
					<option>19</option>
					<option>20</option>
				</select>
			</fieldset>
			<button id="generateMonthly" class="btn btn-primary btn-md">Generate Report</button>
		</form>
	</div>

	<jsp:include page="js-includes.jsp" />
	<script src="${pageContext.request.contextPath}/monthly.js"></script>
</body>
</html>
