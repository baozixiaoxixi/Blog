<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="zh-cn" xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>登陆</title>
  <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css"/>
  <link rel="stylesheet" href="/css/footer.css"/>
  <link rel="stylesheet" href="/css/sidbar.css"/>
  <link rel="stylesheet" href="/css/blog.css"/>
  <link rel="stylesheet" href="/css/login.css"/>
  <link rel="stylesheet" href="/css/highlight.css"/>
  <script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
  <script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <div class="container">

    <form class="form-signin" method="post" action="${pageContext.request.contextPath}/login">
      <h2 class="form-signin-heading">Please sign in</h2>
      <label for="username" class="sr-only">Username</label>
      <input type="text" id="username" name="username" class="form-control" placeholder="Username"/>
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password"/>
      <c:if test="${fail}">
        <p class="error">用户名和密码不匹配，请重试</p>
      </c:if>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>

  </div> <!-- /container -->

</div>

</body>
</html>