<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Titulo</title>
	</head>
	<body>
		<c:if test = "${not empty empresa}">
			<p>Nova empresa: ${empresa}. </p>
		</c:if>
		<c:if test = "${empty empresa}">
			<p>Nenhuma nova empresa. </p>
		</c:if>
		
	</body>
</html>