<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form action="/music/search" method="GET"
	commandName="songSearchParam">
	<form:input path="q" />
	<input type="submit" value="OK">
</form:form>