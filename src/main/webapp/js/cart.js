$("#add-btn").click(function() {
	console.log("ADD BUTTON")
	var bid = document.getElementsByClassName("bid")[0].innerHTML
	$.post({
		url : baseURL + "/cart",
		data : {
			"bid" : bid,
			"method" : "add"
		},
		dataType : "json"

	}).done(function(data, textStatus, jqXHR) {
		location.reload();
		if (data.result === "success") {
			location.reload();
		} else {

		}
	});
});

$("#remove-btn").click(function() {
	console.log("ADD BUTTON")
	var bid = document.getElementsByClassName("bid")[0].innerHTML
	$.post({
		url : baseURL + "/cart",
		data : {
			"bid" : bid,
			"method" : "remove"
		},
		dataType : "json"

	}).done(function(data, textStatus, jqXHR) {
		location.reload();
		if (data.result === "success") {
			location.reload();
		} else {

		}
	});
});
