<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 5/5/2024
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<form action="/gk_war/dangnhap" method="post">
    <div class="form-group">
        <label for="exampleInputEmail1">Email</label>
        <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
               placeholder="Enter email" required>
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Mật khẩu</label>
        <input type="password" name="password" class="form-control" id="exampleInputPassword1"
               placeholder="Password" required>
    </div>
    <button type="submit" class="btn btn-primary">Đăng nhập</button>
</form>
<%
    String error = (String) request.getAttribute("error");
    if (error == null){
        error = "";
    }
%>
<p class="text-danger"><%=error%></p>
</body>
</html>
