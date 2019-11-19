<%@ page import="jsp_studnet.model.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: karol
  Date: 17.09.2019
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Student List</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<jsp:include page="/navigator.jsp"/>

<br>
<div class="container">
    <div class="row">
        <div class="col-xl">
            <div class="table">
                <table>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Age</th>
                        <th>Is Alive</th>
                        <th colspan="4" style="text-align: center">Options</th>
                    </tr>
                    <%
                        List<Student> studentList = (List<Student>) request.getAttribute("my_lovely_student_list");
                        for (Student student : studentList) {
                            out.println("<tr>");
                            out.println("<td>" + student.getId() + "</td>");
                            out.println("<td>" + student.getName() + "</td>");
                            out.println("<td>" + student.getSurname() + "</td>");
                            out.println("<td>" + student.getAge() + "</td>");
                            out.println("<td>" + student.isAlive() + "</td>");
                            out.println("<td><a href=/student-delete?studentId=" + student.getId() + ">Delete</a></td>");
                            out.println("<td><a href=/student-edit?studentId=" + student.getId() + ">Edit</a></td>");
                            out.println("<td><a href=/grade-list?studentId=" + student.getId() + ">List grades</a></td>");
                            out.println("<td><a href=/grade-add?studentId=" + student.getId() + ">Add grade</a></td>");
                            out.println("</tr>");
                        }
                    %>
                </table>

                <br>
                <hr>
                <br>

                <c:forEach var="student" items="${requestScope.my_lovely_student_list}">
                    <tr>
                        <td>${student.getId()}</td>
                        <td>${student.getName()}</td>
                        <td>${student.getSurname()}</td>
                        <td>${student.getAge()}</td>
                        <td>${student.isAlive()}</td>
                        <td>
                            <table>
                                <tr>
                                    <td>
                                        <a href="/student-delete?studentId=${student.getId()}">Delete</a>
                                    </td>
                                    <td>
                                        <a href="/student-edit/?studentId=${student.getId()}">Edit</a>
                                    </td>
                                    <td>
                                        <a href="/grade-list/?studentId=${student.getId()}">List grades</a>
                                    </td>
                                    <td>
                                        <a href="/grade-add/?studentId=${student.getId()}">Add grade</a>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

</body>
</html>
