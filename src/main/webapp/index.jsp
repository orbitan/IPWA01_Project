<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <!-- Page Header -->
    <!-- TODO Find a way to include the Header of the page on all pages without implementing it on each page -->
    <div class="container">
        <div class="logo">
            <a href="index.jsp">
                <img src="icons/co2-cloud.png" alt="logo" width="120" height="120" style="line-height: 0px"/>
            </a>
        </div>

        <div class="navbar">
            <ul>
                <li><a href="index.jsp">Startseite</a></li>
                <li><a href="">Kontakt</a></li>
                <li><a href="">Englisch</a></li>
                <li><a href="">Impressum</a></li>
            </ul>
        </div>
    </div>

    <div class="container-2">
        <a href="HistoricalCourse.xhtml">
            <div class="image" style="padding: 100px">
                <img class="icons" alt="icon" src="icons/time_line.png" width="128" height="128"/><br/>
                <p style="padding-left: 25px">Historischer Verlauf</p>
            </div>
        </a>

        <a href="country_table.xhtml">
            <div class="image" style="padding: 100px">
                <img class="icons" src="icons/graph.png" alt="logo" width="128" height="128"/><br/>
                <p style="padding-left: 20px">Ausstoß nach Ländern</p>
            </div>
        </a>
    </div>




</body>
</html>