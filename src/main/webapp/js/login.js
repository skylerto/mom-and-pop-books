$("#login-btn").click(function() {
  $.post({
    url: window.location.pathname + "Login",
    data: $("#loginForm").serialize(),
    dataType: "json"
  }).done(function(data, textStatus, jqXHR) {
    if (data.RESULT === "PASS") {
      console.info("pass");
      location.reload();
    } else {
      $("#loginAlertContainer").load("loginAlert.html", function() {
        $("#loginAlertContainer div").fadeIn();
      });
    }
  });
});
