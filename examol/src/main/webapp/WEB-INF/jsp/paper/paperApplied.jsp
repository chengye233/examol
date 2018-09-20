<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>已报名</title>

    <!-- Bootstrap core CSS -->
    <link href="../resources/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../resources/cssoffcanvas.css" rel="stylesheet">
</head>

<body class="bg-light">

<%--公共头--%>
<jsp:include page="../common/header.jsp" flush="true"/>

<main role="main" class="container">

    <%--未考式--%>
    <div class="my-3 p-3 bg-white rounded shadow-sm">
        <h6 class="border-bottom border-gray pb-2 mb-0">未考式</h6>
        <%--错误信息--%>
        <c:if test="${not empty errMsg}" >
            <div class="alert alert-danger" role="alert">${errMsg}</div>
        </c:if>
        <ul class="list-group list-group-flush">
            <c:forEach items="${appliedPaperList}" var="paper">
                <li class="list-group-item">
                    <form method="post" action="../paper/startExam">
                        <input type="hidden" name="id" value="${paper.id}" />
                        <img data-src="holder.js/32x32?theme=thumb&bg=e83e8c&fg=e83e8c&size=1"
                             alt="" class="mr-2 rounded"/>
                        试卷名&总分:
                        <a href="#" class="btn btn-info btn-sm disabled"
                           role="button" aria-disabled="true">
                                ${paper.id}
                        </a>
                        <a href="#" class="btn btn-primary btn-sm disabled"
                           role="button" aria-disabled="true">
                                ${paper.name}
                        </a>
                        <a href="#" class="btn btn-secondary btn-sm disabled"
                           role="button" aria-disabled="true">
                                ${paper.fullScore}
                        </a>

                        <button type="submit" class="btn btn-outline-primary btn-sm float-right">
                            开始考试
                        </button>
                    </form>
                </li>
            </c:forEach>
        </ul>


    </div>

    <%--已考试--%>
    <div class="my-3 p-3 bg-white rounded shadow-sm">
        <h6 class="border-bottom border-gray pb-2 mb-0">已考试</h6>
        <%--错误信息--%>
        <c:if test="${not empty errMsg}" >
            <div class="alert alert-danger" role="alert">${errMsg}</div>
        </c:if>
        <ul class="list-group list-group-flush">
            <c:forEach items="${finishedPaperList}" var="userPaper">
                <li class="list-group-item">
                    <form method="post" action="../paper/collectPaper">
                        <input type="hidden" name="id" value="${userPaper.id}" />
                        <img data-src="holder.js/32x32?theme=thumb&bg=007bff&fg=007bff&size=1"
                             alt="" class="mr-2 rounded">
                        试卷&得分&答案:
                        <a href="#" class="btn btn-info btn-sm disabled"
                           role="button" aria-disabled="true">
                                ${userPaper.paperName}
                        </a>
                        <a href="#" class="btn btn-secondary btn-sm disabled"
                           role="button" aria-disabled="true">
                                ${userPaper.examScore}
                        </a>
                        <a href="#" class="btn btn-secondary btn-sm disabled"
                           role="button" aria-disabled="true">
                                ${userPaper.examAnswer}
                        </a>
                        <button type="submit" class="btn btn-outline-warning btn-sm float-right">
                            收藏
                        </button>
                    </form>
                </li>
            </c:forEach>
        </ul>


    </div>
</main>

<%--底部--%>
<jsp:include page="../common/footer.jsp" flush="true" />

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="../resources/js/vendor/popper.min.js"></script>
<script src="../resources/js/bootstrap.js"></script>
<script src="../resources/js/vendor/holder.min.js"></script>
<script src="../resources/js/offcanvas.js"></script>
</body>
</html>

