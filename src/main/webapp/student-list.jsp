<%@ page import="JSP_demo.model.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: karol
  Date: 17.09.2019
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student List</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

<br>
<div class="container">
    <div class="row">
        <div class="col-sm">
            <div class="table">
                <table>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Age</th>
                        <th>Is Alive</th>
                    </tr>
                    <%
                        List<Student> studentList = (List<Student>) request.getAttribute("my_lovely_student_list");
                        for (Student student : studentList) {
                            out.println("<tr>");
                            out.println("<td>" + student.getId());
                            out.println("<td>" + student.getName());
                            out.println("<td>" + student.getSurname());
                            out.println("<td>" + student.getAge());
                            out.println("<td>" + student.isAlive());
                            out.println("</td>");
                        }
                    %>
                </table>
            </div>
        </div>
        <div class="col-sm"></div>
        <div class="col-sm"></div>
    </div>
</div>

</body>
</html>
