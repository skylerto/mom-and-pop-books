<%@ page isELIgnored="false" %>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="${pageContext.request.contextPath}/">Mom and Pop Books</a>
    </div>
    <div id="navbar" class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
        <li><a href="${pageContext.request.contextPath}/"/>Home</a></li>

      </ul>

      <ul class="nav navbar-nav navbar-right">
        <li><a data-toggle="modal" data-target="#loginModal">Login</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="loginModalLabel">Login</h4>
      </div>
      <div class="modal-body">
        <div id="loginAlertContainer"></div>
        <form id="loginForm">
          <div class="form-group">
            <input name="userName" type="text" placeholder="Username" class="form-control">
          </div>
          <div class="form-group">
            <input name="userPassword" type="password" placeholder="Password" class="form-control">
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" id="login-btn" class="btn btn-primary">Login</button>
      </div>
    </div>
  </div>
</div>
