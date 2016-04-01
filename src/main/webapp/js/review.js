$("#review-btn").click(function(e) {
  $.post({
    url: window.location.pathname + "/Review",
    data: $("#reviewForm").serialize(),
    dataType: "json"
  }).done(function(data, textStatus, jqXHR) {
    location.reload();
  });
});
