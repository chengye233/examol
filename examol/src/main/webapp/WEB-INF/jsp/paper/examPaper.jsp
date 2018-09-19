<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>考试</title>

    <!-- Bootstrap core CSS -->
    <link href="../resources/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../resources/css/grid.css" rel="stylesheet">
</head>

<body>
<div class="container">

    <h1>试卷:${paper.name}</h1>
    <p class="lead">
        满分${paper.fullScore}分
    </p>

    <h3>题目:</h3>
    <p>
        以下均为单选题
    </p>

    <c:forEach items="${questionList}" var="question">
        <%--题目--%>
        <div class="alert alert-primary" role="alert">
                ${status.index+1}.${question.title}( )
        </div>
        <%--选项--%>
        <div class="alert alert-secondary" role="alert">
            ${question.option}
        </div>
    </c:forEach>
    <%--交卷--%>
    <form method="post" action="../paper/finishExam">
        <div class="input-group mb-3">
            <input type="hidden" id="paperId" name="paperId" value="${paper.id}" />
            <input type="text" class="form-control" placeholder="填写答案"
                   name="examAnswer" id="examAnswer" required
                   aria-label="Recipient's username" aria-describedby="basic-addon2">
            <div class="input-group-append">
                <button class="btn btn-outline-primary btn-lg" type="submit">交卷</button>
            </div>
        </div>
    </form>

</div>
</body>
</html>

