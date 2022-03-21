<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <div class="logo">
        <img src="icons/co2-cloud.png" alt="logo" width="120" height="120" style="line-height: 0px"/>
    </div>
    <div class="navbar">
        <ul>
            <li><a href="index.jsp">Startseite</a></li>
            <li><a href="#kontakt">Kontakt</a></li>
            <li><a href="#english">Englisch</a></li>
            <li><a href="#impressum">Impressum</a></li>
        </ul>
    </div>
</div>


<div class="container-2">
    <div class="image">
        <a href="historischerVerlauf.xhtml">
            <img class="icons" alt="icon" src="icons/time_line.png" width="128" height="128"/><br/>
        </a>
        <p style="padding-left: 25px">Historischer Verlauf</p>
    </div>
    <div class="image">
        <a href="country_table.xhtml">
            <img class="icons" src="icons/graph.png" alt="logo" width="128" height="128"/><br/>
        </a>
        <p style="padding-left: 20px">Austoß nach Ländern</p>
    </div>

</div>



<br/>
<a href="Servlet">Hello Servlet</a>
<a href="test.xhtml">Ein Link auf ein Face</a>
<a href="laender.xhtml">bla</a>
</body>
</html>