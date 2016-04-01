var baseURL = window.location.pathname.substring(0,
	window.location.pathname.indexOf("/", 1) + 1);

$("#generateMontly").click(function() {
	$.post({
		url: baseURL + "/Reports",
		data: $("#monthlyForm").serialize(),
		dataType: "json"
	}).done(function(data, textStatus, jqXHR) {
		if (data.result === "success") {
			location.reload();
		} else {
			$("#loginAlertContainer").load(baseURL + "/alert.html", function() {
				$("#loginAlertContainer span").html(data.message);
				$("#loginAlertContainer div").fadeIn();
			});
		}
	});
})
