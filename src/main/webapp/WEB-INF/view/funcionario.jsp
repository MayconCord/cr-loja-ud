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
			<h2>Cadastro de funcion�rio</h2>
			<form action="LojaServlet" method="POST">
			    <c:if test="${funcionario != null}">
        			<input type="hidden" name="id" value="<c:out value='${funcionario.id}' />" />
        		</c:if> 
				<label>Nome:</label>
				<input type="text" name="nome" value="nome" placeholder="Digite seu nome">
				<label>Endere�o:</label>
				<input type="text" name="endereco" value="endereco" placeholder="Digite seu endere�o">
				<label>Telefone:</label>
				<input type="text" name="endereco" value="endereco" placeholder="Digite seu telefone">
				<button type="submit">Enviar</button>
			</form>
		</main>
	</body>
</html>	
