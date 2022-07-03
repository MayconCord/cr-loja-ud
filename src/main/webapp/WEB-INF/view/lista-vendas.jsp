<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Lista Vendas</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
	            <th>Valor</th>
	            <th>Descrição</th>
	            <th colspan="2">Ação</th>
	        </tr>
		</thead>
		<tbody>
			<c:forEach var="venda" items="${vendas}">
				<tr>
					<td>${venda.valor}</td>
					<td>${venda.descricao}</td>
					<td><a href="LojaServlet?acao=atualizar-venda&id=${venda.id}">Atualizar</a></td>
					<td><a href="UserServlet?acao=remover-venda&id=${venda.id}">Remover</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>