<%--
  Created by IntelliJ IDEA.
  User: Urza
  Date: 17.03.2021
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Employee List</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>CRM Table of Employee</h2>
        </div>
    </div>
    <div id="container">
        <div id="content">
            <input type="button" value="Add Employee" onclick="window.location.href='showFormADD';
            return false;" class="add-button"/>
        <table>
            <c:url var="sortByFirstName" value="/employee/list">
                <c:param name="sort" value="sortByFirstName"/>
            </c:url>
            <c:url var="sortByLastName" value="/employee/list">
                <c:param name="sort" value="sortByLastName"/>
            </c:url>
            <tr>
                <th><a href="${sortByFirstName}">First Name</a></th>
                <th><a href="${sortByLastName}">Last Name</a></th>
                <th>Email</th>
                <th>Action</th>
            </tr>
            <!-- loop over the table-->
            <c:forEach var="employees" items="${employees}">
                <c:url var="updateLink" value="/employee/showFormUpdate">
                    <c:param name="employeeId" value="${employees.id}"/>
                </c:url>
                <c:url var="deleteLink" value="/employee/showFormDelete">
                    <c:param name="employeeId" value="${employees.id}"/>
                </c:url>
                <tr>
                    <td>${employees.firstName}</td>
                    <td>${employees.lastName}</td>
                    <td>${employees.email}</td>
                    <td><a href="${updateLink}"> Update</a> |
                        <a href="${deleteLink}" onclick="if (!(confirm('Are you sure ?')))return false"> Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        </div>
    </div>
</body>
</html>
