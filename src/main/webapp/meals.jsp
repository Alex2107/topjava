<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 07.03.2018
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<h2>Meals</h2>

<c:if test="${!empty meals}">
    <table class="tg">
        <tr>
            <th width="80">DateTime</th>
            <th width="120">Description</th>
            <th width="60">Calories</th>
        </tr>

        <c:forEach items="${meals}" var="meal">
            <tr>
                <th style="${meal.isExceed() ? 'background-color: green':'background-color: red'}">${meal.getDateTime()}</th>
                <th style="${meal.isExceed() ? 'background-color: green':'background-color: red'}">${meal.getDescription()}</th>
                <th style="${meal.isExceed() ? 'background-color: green':'background-color: red'}">${meal.getCalories()}</th>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
