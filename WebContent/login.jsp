<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="WEB-INF/views/header.jsp" %>
<h3>Login</h3>
<form method="post" action="handlers/LoginHandler">
  <div class="form-group">
    <label>Username</label>
    <input class="form-control" name="username"/>
  </div>
  <div class="form-group">
    <label>Password</label>
    <input type="password" class="form-control" name="password"/>
  </div>
  <button class="btn btn-primary">Login</button>
</form>
<%@ include file="WEB-INF/views/footer.jsp" %>
