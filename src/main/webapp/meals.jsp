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
            <th width="80">DateTime formatted</th>
            <th width="120">Description</th>
            <th width="60">Calories</th>
        </tr>
        <!--
        public MealWithExceed(LocalDateTime dateTime, String description, int calories, boolean exceed)!-->
        <c:forEach items="${meals}" var="meal">
            <tr>
                <td>${meal.getDate()}</td>
                <td><ctg:format value="${meal.getDateTime()}" pattern="dd/MM/yyyy HH:mm:ss"/></td>
                <td>${meal.getDescription()}</td>
                <td>${meal.getCalories()}</td>

                <td>${meal.description}</td>
                <td>${meal.calories}</td>
                <td>${meal.exceed}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
