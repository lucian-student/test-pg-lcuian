<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <table
    </head>
    <body>
        <table id="records" border="1">
            <tr>
                <th>Den</th>
                <th>Pocet</th>
            </tr>
            <c:forEach var="record" items="${requestScope.records}">
                <tr>
                    <td>${record[0]}</td>
                    <td>${record[1]}</td>
                </tr>
            </c:forEach>    
        </table>     
    </body>
</html>