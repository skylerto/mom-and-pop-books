$("#add-btn").click(function() {
	$.post({
		url : baseURL + "/cart/add",
		data : $("#bid").serialize(),
		dataType : "json"
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

$("#remove-btn").click(function() {
	$.post({
		url : baseURL + "/cart/remove",
		data : $("#bid").serialize(),
		dataType : "json"
	}).done(function(data, textStatus, jqXHR) {
		if (data.result === "success") {
			location.reload();
		} else {

		}
	});
});