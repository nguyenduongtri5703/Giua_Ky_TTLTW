<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 5/5/2024
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<form action="/gk_war/dangky" method="post">
    <div class="form-group">
        <label for="exampleInputFullName1">Tên</label>
        <input type="text" class="form-control" id="exampleInputFullName1"
               aria-describedby="fullNameHelp" required="required" name="name">
    </div>

    <div class="form-group">
        <label for="exampleInputEmail1">Email</label>
        <input type="email" class="form-control" id="exampleInputEmail1"
               aria-describedby="emailHelp" required="required" name="email">
    </div>

    <div class="form-group">
        <label for="exampleInputPhone1">Số điện thoại</label>
        <input type="tel" class="form-control" id="exampleInputPhone1"
               aria-describedby="phoneHelp" required="required" name="tel">
    </div>

    <div class="form-group">
        <label for="exampleInputPassword1">Mật khẩu</label>
        <input type="password" class="form-control" id="exampleInputPassword1" required="required"
               name="password">
    </div>

    <div class="form-group">
        <label for="exampleInputPassword1">Nhập lại mật khẩu</label>
        <input type="password" class="form-control" id="" required="required"
               name="repassword">
    </div>

    <button type="submit" class="btn btn-primary">Đăng ký</button>
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
