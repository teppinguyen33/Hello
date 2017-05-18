<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Result</title>
    
</head>
<body>
    <jsp:include page="./includes/searchPanel.jsp"></jsp:include>
    <h1>Result</h1>
    ${keyword} -- ${total} <br>
    <table>
        <th>#</th>
        <th>Name</th>
        <th>Artist</th>
        <th>Listen</th>
        <c:forEach items="${listSong}" var="song" varStatus="i">
            <tr>
                <td>${i.index + 1}</td>
                <td><a href="<c:url value="/music/song/${song.id}" ></c:url>">${song.title}</a></td>
                <td>${song.artist}</td>
                <td>${song.listen}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>