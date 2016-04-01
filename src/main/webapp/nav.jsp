<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${pageContext.request.contextPath}/">Mom
				and Pop Books</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="${pageContext.request.contextPath}/" />Home</a></li>
				<c:if test="${sessionScope['admin']}">
					<li><a href="${pageContext.request.contextPath}/Reports" />Reports</a></li>
				</c:if>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Browse By Category<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath}/Science">Science</a></li>
						<li><a href="${pageContext.request.contextPath}/Fiction">Fiction</a></li>
						<li><a href="${pageContext.request.contextPath}/Engineering">Engineering</a></li>
					</ul></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="${pageContext.request.contextPath}/cart">Cart
						(${sessionScope['cart'].size() })</a></li>
				<li><a data-toggle="modal" data-target="#registerModal">Register</a></li>
				<c:if test="${empty sessionScope['user']}">
					<li><a data-toggle="modal" data-target="#loginModal">Login</a></li>
				</c:if>
				<c:if test="${not empty sessionScope['user']}">
					<li><a href="${pageContext.request.contextPath}/Logout">Logout</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</nav>

<div class="modal fade" id="loginModal" tabindex="-1" role="dialog"
	aria-labelledby="loginModalLabel">
	<div class="modal-dialog modal-sm" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="loginModalLabel">Login</h4>
			</div>
			<div class="modal-body">
				<div id="loginAlertContainer"></div>
				<form id="loginForm">
					<div class="form-group">
						<input name="userName" type="text" placeholder="Username"
							class="form-control"></input>
					</div>
					<div class="form-group">
						<input name="userPassword" type="password" placeholder="Password"
							class="form-control"></input>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" id="login-btn" class="btn btn-primary">Login</button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="registerModal" tabindex="-1" role="dialog"
	aria-labelledby="registerModalLabel">
	<div class="modal-dialog modal-sm" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="registerModalLabel">Register</h4>
			</div>
			<div class="modal-body">
				<div id="registerAlertContainer"></div>
				<form id="registerForm">
					<div class="form-group">
						<input name="userName" pattern=".{5,}" required
							title="Minimum 5 characters" type="text"
							placeholder="Enter New Username" class="form-control">
					</div>
					<div class="form-group">
						<input name="userPassword" pattern=".{6,}" required
							title="Minimum 6 characters" type="password"
							placeholder="Enter New Password" class="form-control"
							id="userPassword"></input>
					</div>
					<div class="form-group">
						<input name="userPassword2" pattern=".{6,}" required
							title="Minimum 6 characters" type="password"
							placeholder="Re-Enter Password" class="form-control"
							id="userPassword2">
					</div>
					<c:if test="${sessionScope['admin']}">
						<div class="form-group">
							<input name="isAdmin" type="checkbox" id="isAdmin"></input> <label
								for="isAdmin">Administrator</label>
						</div>
					</c:if>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" id="register-btn" class="btn btn-primary">Register</button>
			</div>
		</div>
	</div>
</div>
