<%--
  Created by IntelliJ IDEA.
  User: ������
  Date: 30.08.2022
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=windows-1251" pageEncoding="windows-1251"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>������������� �������</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/client/edit" method="post">
    <input type="hidden" name="id" value="${client.id}">
    <table>
        <tr>
            <td align="right">��� :
            </td>
            <td>
                <input type="text" name="name" value="${client.name}">
            </td>
        </tr>
        <tr>
            <td align="right"> ��� ������� : </td>
            <td>
                <input type="text" name="petName" value="${client.pet.name}">
            </td>
        </tr>
        <tr>
            <td align="right"> ��� ������� : </td>
            <td>
                <input type='radio' name='petType' value='cat'>���
                <input type='radio' name='petType' value='dog'>������
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="��������"/></td>
        </tr>
    </table>
</form>
</body>
</html>
