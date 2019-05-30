<%--
  Created by IntelliJ IDEA.
  User: Jerk
  Date: 2019/5/29
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<link href="css/bootstrap-theme.css" rel="stylesheet" />
<link href="css/bootstrap.css" rel="stylesheet" />
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/bootstrap-theme.min.css" rel="stylesheet" />
<body>
<div class="container">
    <input type="text" class=" input-lg">
    <button type="button" class="btn btn-info">搜索</button>
    <div id="w0" class="grid-view">
        <div class="table-responsive">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th nowrap>ID</th>
                    <th nowrap>姓名</th>
                    <th nowrap>年齡</th>
                    <th nowrap>性別</th>
                    <th nowrap>地址</th>
                    <th class="action-column">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pageBean.pageDatas}" var="i">


                </c:forEach>
                </tbody>
            </table>
        </div>

    </div></body>
</html>
