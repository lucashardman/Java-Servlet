<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="entrada" var="linkServletNovaEmpresa"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<c:import url="logout.jsp"/>
		<form action="${linkServletNovaEmpresa }" method="post">
			Nome: <input type="text" name=nome value="${empresa.nome }"><br/>
			Data de abertura: <input type="text" name=data value="<fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/>"><br/>
			<input type="hidden" name="id" value="${empresa.id }"><br/>
			<input type="hidden" name="acao" value="AlteraEmpresa"><br/>
			<input type="submit">
		</form>
	</body>
</html>