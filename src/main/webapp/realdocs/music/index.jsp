<!DOCTYPE html>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <meta charset="UTF-8">
  <%-- Bootstrap in maven lib --%>
  <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css">

  <%-- Bootstrap in contents download --%>
  <%-- <link rel="stylesheet" type="text/css" href="contents/bootstrap/css/bootstrap.min.css"> --%>

<title>Music</title>
</head>
<body>
	<h1>Music</h1>
	<jsp:include page="./includes/searchPanel.jsp"></jsp:include>
	<core:if
		test="${song.qualities.audio128 != null || song.qualities.audio128 == ''}">
		<audio controls autoplay loop>
			<source src="${song.qualities.audio128}" type="audio/mpeg">
		</audio>
	</core:if>

<script type="text/javascript" src="webjars/jquery/2.1.4/jquery.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>