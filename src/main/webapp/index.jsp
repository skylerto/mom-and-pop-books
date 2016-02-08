<html>
	<head>
		<script src="<%= org.webjars.AssetLocator.getWebJarPath(" jquery.min.js") %>"></script>
	</head>
	<body>
		<h2>Hello World!</h2>
	</body>
	<script>
	$(document).ready(function () {
		$("h2").text("jQuery is working");
	});
	</script>
</html>
