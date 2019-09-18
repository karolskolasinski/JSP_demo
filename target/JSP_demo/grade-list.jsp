<%@ page import="JSP_demo.model.Grade" %>
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
    <title>Grade List</title>
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
                        <th>Date Added</th>
                        <th>Subject</th>
                        <th>Value</th>
                    </tr>
                    <%
                        List<Grade> studentList = (List<Grade>) request.getAttribute("my_lovely_grade_list");
                        for (Grade grade : studentList) {
                            out.println("<tr>");
                            out.println("<td>" + grade.getId());
                            out.println("<td>" + grade.getDateAdded().toLocalDate());
                            out.println("<td>" + grade.getSubject());
                            out.println("<td>" + grade.getValue());
                            out.println("</tr>");
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
