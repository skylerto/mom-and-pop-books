$("#login-btn").click(function() {
  $.post(window.location.pathname + "/Login", $("#loginForm").serialize())
      .done(function(data, textStatus, jqXHR) {
    if (data.result === "PASS") {
      location.reload();
    } else {
      $("#loginAlertContainer").load("loginAlert.html", function() {
        $("#loginAlertContainer div").fadeIn();
      });
    }
  });
});
