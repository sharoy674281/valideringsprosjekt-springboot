<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html><body>
<h2>Logg inn</h2>
<c:if test="${not empty feil}">
    <p style="color:red;">${feil}</p>
</c:if>
<form action="/login" method="post">
    E-post: <input type="text" name="epost"/><br/>
    Passord: <input type="password" name="passord"/><br/>
    <button type="submit">Logg inn</button>
</form>
<p><a href="/registrering">Registrer ny bruker</a></p>
</body></html>
