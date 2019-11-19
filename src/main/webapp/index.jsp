<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/style.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>Multiple</title>
</head>
<body>
<jsp:include page="/navigator.jsp"/>

<h2>Tabliczka mnożenia!</h2>
<form action="index.jsp" method="post">
    Rozmiar X: <input type="number" min="1" name="wielkosc_x" value="10">
    <br/>
    <br/>
    Rozmiar Y: <input type="number" min="1" name="wielkosc_y" value="10">
    <br/>
    <input type="submit" value="mnóż">
</form>

<table>
    <%
        String wielkoscX = request.getParameter("wielkosc_x");
        int rozmiarX = 10;
        try {
            rozmiarX = Integer.parseInt(wielkoscX);
        } catch (NumberFormatException nfe) {

        }

        String wielkoscY = request.getParameter("wielkosc_y");
        int rozmiarY = 10;
        try {
            rozmiarY = Integer.parseInt(wielkoscY);
        } catch (NumberFormatException nfe) {

        }

        for (int i = 1; i <= rozmiarY; i++) {
            out.print("<tr>");
            for (int j = 1; j <= rozmiarX; j++) {
                out.print("<td>");
                out.print(i * j);
                out.print("</td>");
            }
            out.print("</tr>");
        }
    %>
</table>

</body>
</html>
