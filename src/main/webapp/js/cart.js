var baseURL = window.location.pathname.substring(0, window.location.pathname
		.indexOf("/", 1) + 1);

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
var items = document.getElementsByClassName("item");
var index;
for (index = 0; index < items.length; index++) {
	var item = items[index];
	var name = item.getElementsByClassName("bid")[0].innerHTML;
	var remove = item.getElementsByClassName("remove-btn")[0];
	(function(_item, _name) {
		remove.addEventListener("click", function() {
			console.log(_name);
			var q = 0;
			var bid = _item.getElementsByClassName("bid")[0].innerHTML
			console.log(bid)
			var cart = document.getElementsByClassName("cart")[0];
			var cartItem = document.createElement('div');
			while (cartItem.firstChild) {
				cart.appendChild(cartItem.firstChild);
			}
			$.post({
				url : baseURL + "/cart/remove",
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
	})(item, name);
}
$("#add-btn").click(function() {
	console.log("ADD BUTTON")
	var bid = document.getElementsByClassName("bid")[0].innerHTML
	$.post({
		url : baseURL + "/cart/remove",
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