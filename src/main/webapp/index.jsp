<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="<%= org.webjars.AssetLocator.getWebJarPath("css/bootstrap.min.css")%>">
		<style>
		body {
			padding-top: 50px;
		}
		</style>
		<title>Mom and Pop Books</title>
	</head>
	<body>
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Mom and Pop Books</a>
				</div>
				<div id="navbar" class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Home</a></li>
					</ul>
				</div>
			</div>
		</nav>

		<div class="container">
			<p>
				Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
			</p>
		</div>

		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<img class="thumbnail" src="" width="200" height="200">
				</div>
				<div class="col-md-4">
					<img class="thumbnail" src="" width="200" height="200">
				</div>
				<div class="col-md-4">
					<img class="thumbnail" src="" width="200" height="200">
				</div>
			</div>

			<div class="row">
				<div class="col-md-4">
					<img class="thumbnail" src="" width="200" height="200">
				</div>
				<div class="col-md-4">
					<img class="thumbnail" src="" width="200" height="200">
				</div>
				<div class="col-md-4">
					<img class="thumbnail" src="" width="200" height="200">
				</div>
			</div>

			<div class="row">
				<div class="col-md-4">
					<img class="thumbnail" src="" width="200" height="200">
				</div>
				<div class="col-md-4">
					<img class="thumbnail" src="" width="200" height="200">
				</div>
				<div class="col-md-4">
					<img class="thumbnail" src="" width="200" height="200">
				</div>
			</div>
		</div>

		<script src="<%= org.webjars.AssetLocator.getWebJarPath("jquery.min.js") %>"></script>
		<script src="<%= org.webjars.AssetLocator.getWebJarPath("bootstrap.min.js") %>"></script>
	</body>
</html>
