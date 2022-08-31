<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 30.08.2022
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=windows-1251" pageEncoding="windows-1251" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Просмотр клиентов</title>
</head>
<body>
<a href="${pageContext.servletContext.contextPath}/views/client/CreateClient.jsp">Добавить клиента</a>
<table>
    <tr>
        <td>Имя питомец</td>
        <td>Действия</td>
    </tr>
    <c:forEach items="${clients}" var="client" varStatus="status">
        <tr>
            <td>${client.name} ${client.pet}</td>
            <td>
                <a href="${pageContext.servletContext.contextPath}/client/edit?id=${client.id}">Редактировать</a>
                <a href="${pageContext.servletContext.contextPath}/client/delete?id=${client.id}">Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
