<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Cadastro</title>
	</head>
	<body>	
		<main>
			<h2>Cadastro de venda</h2>
			<form action="LojaServlet" method="POST">
				<c:if test="${venda != null}">
        			<input type="hidden" name="id" value="<c:out value='${venda.id}' />" />
        		</c:if> 
				<label>Valor:</label>
				<input type="text" name="nome" value="nome" placeholder="Digite o valor">
				<label>Descrição:</label>
				<input type="text" name="endereco" value="endereco" placeholder="Digite a descrição">
				<button type="submit">Enviar</button>
			</form>
		</main>
	</body>
</html>