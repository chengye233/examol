<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

    <title>试卷</title>

    <!-- Bootstrap core CSS -->
    <link href="../resources/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../resources/css/dashboard.css" rel="stylesheet">
</head>

<body>
<%--公共头--%>
<jsp:include page="../common/header.jsp" flush="true"/>

<div class="container-fluid">
    <div class="row">
        <%--侧栏--%>
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
            <div class="sidebar-sticky">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active" href="#">
                            <span data-feather="home"></span>
                            Dashboard <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <span data-feather="file"></span>
                            Orders
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <span data-feather="users"></span>
                            Customers
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <span data-feather="bar-chart-2"></span>
                            Reports
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <span data-feather="layers"></span>
                            Integrations
                        </a>
                    </li>
                </ul>

            </div>
        </nav>

        <%--表格--%>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <h2>搜索结果</h2>
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead>
                        <tr class="table-warning">
                            <th>id</th>
                            <th>试卷名</th>
                            <th>分数</th>
                            <th>报名</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${paperList}" var="paper">
                            <form method="post" action="">
                                <tr>
                                    <th>
                                        ${paper.id}
                                        <input type="hidden" value="${paper.id}">
                                    </th>
                                    <th>
                                        ${paper.name}
                                        <input type="hidden" value="${paper.name}">
                                    </th>
                                    <th>
                                        ${paper.fullScore}
                                        <input type="hidden" value="${paper.fullScore}">
                                    </th>
                                    <th>
                                        <button type="submit" class="btn btn-outline-primary btn-sm">
                                            报名
                                        </button>
                                    </th>
                                </tr>
                            </form>

                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </main>
    </div>
</div>

<%--公共尾--%>
<jsp:include page="../common/footer.jsp" flush="true"/>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="../resources/js/vendor/popper.min.js"></script>
<script src="../resources/js/bootstrap.min.js"></script>

<!-- Icons -->
<script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>
<script>
    feather.replace()
</script>


</body>
</html>
