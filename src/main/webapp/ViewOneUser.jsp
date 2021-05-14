<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Students Managment</title>
</head>
<body>
<center>
    <h1>Students Management</h1>
    <h2>
        <a href="/JspStudentCrud_war_exploded/new">Add New Student</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/JspStudentCrud_war_exploded/list">List All Students</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2 c:out value="${listStudent.firstName}"> profile</h2></caption>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Gender</th>
            <th></th>
        </tr>

            <tr>
                <td><c:out value="${listStudent.id}" /></td>
                <td><c:out value="${listStudent.firstName}" /></td>
                <td><c:out value="${listStudent.lastName}" /></td>
                <td><c:out value="${listStudent.gender}" /></td>
                <td>
                    <a href="/JspStudentCrud_war_exploded/edit?id=<c:out value='${listStudent.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/JspStudentCrud_war_exploded/delete?id=<c:out value='${listStudent.id}' />">Delete</a>

                </td>
            </tr>

    </table>
</div>
</body>
</html>