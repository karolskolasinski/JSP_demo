<%@ page import="jsp_studnet.model.Grade" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%--
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
<jsp:include page="/navigator.jsp"/>

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
                        <th>Student</th>
                    </tr>
                    <%
                        List<Grade> studentList = (List<Grade>) request.getAttribute("my_lovely_grade_list");
                        for (Grade grade : studentList) {
                            out.println("<tr>");
                            out.println("<td>" + grade.getId() + "</td>");
                            out.println("<td>" + grade.getDateAdded().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm")) + "</td>");
                            out.println("<td>" + grade.getSubject() + "</td>");
                            out.println("<td>" + grade.getValue() + "</td>");
                            if (grade.getStudent() != null) {
                                out.println("<td>" + grade.getStudent().getId() + " " + grade.getStudent().getName() + " " + grade.getStudent().getSurname() + "</td>");
                            } else {
                                out.println("<td></td>");
                            }
                            out.println("</tr>");
                        }
                    %>
                </table>
            </div>
        </div>
    </div>
</div>

</body>
</html>
