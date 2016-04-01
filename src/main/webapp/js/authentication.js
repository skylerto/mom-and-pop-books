$("#login-btn").click(function() {
	$.post({
		url: window.location.pathname + "Login",
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
			url: window.location.pathname + "Register",
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
