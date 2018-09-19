<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <!-- Bootstrap core CSS -->
    <link href="../resources/css/bootstrap.css" rel="stylesheet">
    <link href="../resources/css/jumbotron.css" rel="stylesheet">
<body>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="#">ExamOl</a>

    <%--分辨率适配--%>
    <button class="navbar-toggler" type="button"
            data-toggle="collapse"
            data-target="#navbarsExampleDefault"
            aria-controls="navbarsExampleDefault"
            aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <%--导航栏--%>
    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <%--主页--%>
            <li class="nav-item active">
                <a class="nav-link" href="../user/homePage">
                    主页
                    <span class="sr-only">(current)</span>
                </a>
            </li>

            <%--个人资料--%>
            <li class="nav-item">
                <a class="nav-link" href="#">个人资料</a>
            </li>

            <%--消息--%>
            <li class="nav-item">
                <a class="nav-link" href="#">消息</a>
            </li>

            <%--功能--%>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com"
                   id="dropdown01" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    试卷
                </a>

                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="../paper/paperCollectionPage">收藏</a>
                    <a class="dropdown-item" href="../paper/paperAppliedPage">已报名</a>
                </div>
            </li>
        </ul>

        <%--搜索试卷--%>
        <form class="form-inline my-2 my-lg-0" method="post" action="../paper/searchPaper">
            <input class="form-control mr-sm-2" type="text"
                   placeholder="搜索试卷" aria-label="Search"
                   id="keyWord" name="keyWord">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">
                Search
            </button>
        </form>
    </div>
</nav>
</body>
</html>
