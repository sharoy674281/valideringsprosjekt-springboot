<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Brukeroversikt</title>
</head>
<body>
<h2>Dine registrerte brukere (session)</h2>

<c:if test="${empty brukere}">
    <p>Ingen brukere registrert ennå.</p>
</c:if>

<c:if test="${not empty brukere}">
    <table border="1" cellpadding="5">
        <tr><th>Fornavn</th><th>Etternavn</th><th>E-post</th></tr>
        <c:forEach var="b" items="${brukere}">
            <tr>
                <td>${b.fornavn}</td>
                <td>${b.etternavn}</td>
                <td>${b.epost}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<p><a href="/registrering">Ny registrering</a></p>
</body>
</html>
