<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Lista Clientes</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
	            <th>Nome</th>
	            <th>Endereco</th>
	            <th>Telefone</th>
	            <th>CPF</th>
	            <th colspan="2">Ação</th>
	        </tr>
		</thead>
		<tbody>
			<c:forEach var="cliente" items="${clientes}">
				<tr>
					<td>${cliente.nome}</td>
					<td>${cliente.endereco}</td>
					<td>${cliente.telefone}</td>
					<td>${cliente.cpf}</td>
					<td><a href="LojaServlet?acao=atualizar-venda&id=${cliente.id}">Atualizar</a></td>
					<td><a href="UserServlet?acao=remover-venda&id=${cliente.id}">Remover</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>