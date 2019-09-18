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
    <title>Grade Add</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

<br>
<div class="container">
    <div class="row">
        <div class="col-sm">
            <form action="/grade-add" method="post">
                <div class="form-group">
                    <label>wybierz przedmiot:</label>
                    <select class="form-control" name="subject">
                        <option value="ENGLISH">English</option>
                        <option value="IT">IT</option>
                        <option value="POLISH">Polish</option>
                        <option value="HISTORY">History</option>
                        <option value="MATH">Math</option>
                        <option value="PHYSICS">Physics</option>
                        <option value="CHEMISTRY">Chemistry</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>Ocena:</label>
                    <input type="number" name="value" min="1" max="6" class="form-control" placeholder="Wprowadź ocenę">
                </div>
                <button type="submit" class="btn btn-primary">Zapisz</button>
            </form>
        </div>
        <div class="col-sm"></div>
        <div class="col-sm"></div>
    </div>
</div>

</body>
</html>
