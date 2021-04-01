<%--
  Created by IntelliJ IDEA.
  User: Urza
  Date: 18.03.2021
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Adding Employee</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/addEmployeeStyle.css">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>CR - Custom Relation Manager</h2>
        </div>
    </div>
    <div id="container">
        <h3>Save Employee</h3>
        <form:form action="saveEmployee" modelAttribute="employee" method="post">
            <form:hidden path="id"/>
          <table>
              <tbody>
              <tr>
                <td><label>First  name:</label></td>
                <td>
                    <form:input path="firstName"/>
                    <form:errors path="firstName" cssClass="error"/>
                </td>
              </tr>
              <tr>
                <td><label>Last name:</label></td>
                <td>
                    <form:input path="lastName"/>
                    <form:errors path="lastName" cssClass="error"/>
                </td>
              </tr>
              <tr>
                <td><label>Email:</label></td>
                <td><form:input path="email"/>
                    <form:errors path="email" cssClass="error"/>
                </td>
              </tr>
              <tr>
                  <td><label/></td>
                  <td>
                      <input type="submit" value="SAVE" class="save"/>
                      <input type="button" value="BACK" class="save"
                             onclick="window.location.href='${pageContext.request.contextPath}/employee/list'"/>
                  </td>
              </tr>
              </tbody>
          </table>
        </form:form>

    </div>
</body>
</html>
