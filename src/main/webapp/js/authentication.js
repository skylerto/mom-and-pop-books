var baseURL = window.location.pathname.substring(0,
	window.location.pathname.indexOf("/", 1) + 1);

$("#login-btn").click(function() {
	$.post({
		url: baseURL + "/Login",
		data: $("#loginForm").serialize(),
		dataType: "json"
	}).done(function(data, textStatus, jqXHR) {
		if (data.result === "success") {
			location.reload();
		} else {
			$("#loginAlertContainer").load("alert.html", function() {
				$("#loginAlertContainer span").html(data.message);
				$("#loginAlertContainer div").fadeIn();
			});
		}
	});
});

$("#register-btn").click(function() {
	if ($("#userPassword").val() !== $("#userPassword2").val()) {
		$("#registerAlertContainer").load("alert.html", function() {
			$("#registerAlertContainer span").html("<span>Passwords do not match!</span>");
			$("#registerAlertContainer div").fadeIn();
		});
	} else {
		$.post({
			url: baseURL + "Register",
			data: $("#registerForm").serialize(),
			dataType: "json"
		}).done(function(data, textStatus, jqXHR) {
			if (data.result === "success") {
				location.reload();
			} else {
				$("#registerAlertContainer").load("alert.html", function() {
					$("#registerAlertContainer span").html(data.message);
					$("#registerAlertContainer div").fadeIn();
				});
			}
		});
	}
});
