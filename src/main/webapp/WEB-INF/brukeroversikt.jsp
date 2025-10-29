<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html><body>
<h2>Registrerte brukere</h2>

<table border="1" cellpadding="6">
    <tr>
        <th>Fornavn</th>
        <th>Etternavn</th>
        <th>E-post</th>
    </tr>
    <c:forEach var="b" items="${brukere}">
        <tr>
            <td>${b.fornavn}</td>
            <td>${b.etternavn}</td>
            <td>${b.epost}</td>
        </tr>
    </c:forEach>
</table>

<p><a href="/registrering">Ny registrering</a></p>
</body></html>
