<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 30.08.2022
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=windows-1251" pageEncoding="windows-1251"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Редактировать клиента</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/client/edit" method="post">
    <input type="hidden" name="id" value="${client.id}">
    <table>
        <tr>
            <td align="right">Имя :
            </td>
            <td>
                <input type="text" name="name" value="${client.name}">
            </td>
        </tr>
        <tr>
            <td align="right"> Имя питомца : </td>
            <td>
                <input type="text" name="petName" value="${client.pet.name}">
            </td>
        </tr>
        <tr>
            <td align="right"> Тип питомца : </td>
            <td>
                <input type='radio' name='petType' value='cat'>Кот
                <input type='radio' name='petType' value='dog'>Собака
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Изменить"/></td>
        </tr>
    </table>
</form>
</body>
</html>
