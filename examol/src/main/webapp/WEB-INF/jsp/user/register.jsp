<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>

    <title>login</title>

    <!-- Bootstrap core CSS -->
    <link href="../resources/css/bootstrap.css" rel="stylesheet">
    <link href="../resources/css/floating-labels.css" rel="stylesheet">
</head>
<body>

<form class="form-signin" method="post" action="../user/register">
    <div class="text-center mb-4">
        <h1 class="h1 mb-3 font-weight-normal">ExamOl</h1>
        <h2 class="h2 mb-3 font-weight-normal">注册</h2>
        <%--错误信息--%>
        <c:if test="${not empty errMsg}" >
            <div class="alert alert-danger" role="alert">${errMsg}</div>
        </c:if>
    </div>

    <div class="form-label-group">
        <input type="text" name="name" id="name" class="form-control" placeholder="用户名" required autofocus />
        <label for="name">用户名</label>
    </div>

    <div class="form-label-group">
        <input type="password" name="password" id="password" class="form-control" placeholder="密码" required />
        <label for="password">密码</label>
    </div>

    <div class="form-label-group">
        <input type="email" name="email" id="email" class="form-control" placeholder="邮箱" required />
        <label for="email">邮箱</label>
    </div>

    <button class="btn btn-lg btn-primary btn-block" type="submit" id="submit">注册</button>
    <p class="mt-5 mb-3 text-muted text-center">&copy; 2017-2018</p>
</form>
</body>
</html>
