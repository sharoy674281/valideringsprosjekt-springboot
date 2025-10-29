<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html><body>
<h2>Registrering</h2>

<form:form method="post" action="/registrering" modelAttribute="bruker">

    <label>Fornavn</label><br/>
    <form:input path="fornavn"/>
    <form:errors path="fornavn" cssClass="error"/><br/><br/>

    <label>Etternavn</label><br/>
    <form:input path="etternavn"/>
    <form:errors path="etternavn" cssClass="error"/><br/><br/>

    <label>E-post</label><br/>
    <form:input path="epost"/>
    <form:errors path="epost" cssClass="error"/><br/><br/>

    <label>Passord</label><br/>
    <form:password path="passord"/>
    <form:errors path="passord" cssClass="error"/><br/><br/>

    <label>Gjenta passord</label><br/>
    <form:password path="passord2"/>
    <form:errors path="passord2" cssClass="error"/><br/><br/>

    <button type="submit">Send</button>
</form:form>

<style>.error{color:red;}</style>
</body></html>
