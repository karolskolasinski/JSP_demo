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
    <title>Student Add</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

<br>
<div class="container">
    <div class="row">
        <div class="col-sm">
            <form action="/student-add" method="post">
                <div class="form-group">
                    <label>Imię</label>
                    <input type="text" name="student_name" class="form-control" placeholder="Wprowadź imię">
                </div>
                <div class="form-group">
                    <label>Nazwisko</label>
                    <input type="text" name="student_last_name" class="form-control" placeholder="Wprowadź nazwisko">
                </div>
                <div class="form-group">
                    <label>Wiek</label>
                    <input type="number" name="student_age" min="1" max="99" class="form-control"
                           placeholder="Wprowadź wiek">
                </div>
                <div class="form-group form-check">
                    <input type="checkbox" name="student_is_alive" class="form-check-input">
                    <label class="form-check-label">Is alive</label>
                </div>
                <button type="submit" class="btn btn-primary">Zapisz</button>
                <%--//lub:
                <input type="submit">--%>
            </form>
        </div>
        <div class="col-sm"></div>
        <div class="col-sm"></div>
    </div>
</div>

</body>
</html>
