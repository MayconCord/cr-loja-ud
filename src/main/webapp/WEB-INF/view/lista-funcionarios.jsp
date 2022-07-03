<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Listar Fucnionarios</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
	            <th>Nome</th>
	            <th>Endereco</th>
	            <th>Telefone</th>
	            <th colspan="2">Ação</th>
	        </tr>
		</thead>
		<tbody>
			<c:forEach var="funcionario" items="${funcionarios}">
				<tr>
					<td>${funcionario.nome}</td>
					<td>${funcionario.endereco}</td>
					<td>${funcionario.telefone}</td>
					<td><a href="LojaServlet?acao=atualizar-funcionario&id=${funcionario.id}">Atualizar</a></td>
					<td><a href="UserServlet?acao=remover-funcionario&id=${funcionario.id}">Remover</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>