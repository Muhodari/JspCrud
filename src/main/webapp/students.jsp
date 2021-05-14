<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Students Managment</title>
    <style>
        #customers {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #customers td, #customers th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #customers tr:nth-child(even){background-color: #f2f2f2;}

        #customers tr:hover {background-color: #ddd;}

        #customers th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #4CAF50;
            color: white;
        }

        h2 a{
            text-decoration: none;
        }

    </style>







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
    <table border="1" cellpadding="5" id="customers">
        <caption><h2>List of Students</h2></caption>
        <tr>
            <th>ID</th>
            <th> First Name</th>
            <th>Last Name</th>
            <th>Gender</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="student" items="${listStudent}">
            <tr>
                <td ><c:out value="${student.id}" /></td>
                <td ><c:out value="${student.firstName}" /></td>
                <td><c:out value="${student.lastName}" /></td>
                <td><c:out value="${student.gender}" /></td>
                <td>
                    <a href="/JspStudentCrud_war_exploded/edit?id=<c:out value='${student.id}' />">Edit</a> </td>
                <td>
                    <a href="/JspStudentCrud_war_exploded/viewUser?id=<c:out value='${student.id}' />">View</a> </td>
                  <td>
                    <a href="/JspStudentCrud_war_exploded/delete?id=<c:out value='${student.id}' />">Delete</a>

                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>