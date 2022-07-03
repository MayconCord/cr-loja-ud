package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import dao.FuncionarioDAO;
import dao.VendaDAO;

public class LojaServlet extends HttpServlet{
	
	private FuncionarioDAO funcionarioDAO;
	private VendaDAO vendaDAO;
	private ClienteDAO clienteDAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		var acao = request.getParameter("acao");
		
		//FOMS
		if (acao.equalsIgnoreCase("funcionario")) {
			request.getRequestDispatcher("/WEB-INF/cadastrar-funcionario.jsp").forward(request, response);
			
		} 
		else if(acao.equalsIgnoreCase("venda")) {
			request.getRequestDispatcher("/WEB-INF/cadastrar-venda.jsp").forward(request, response);
		}
		else if(acao.equalsIgnoreCase("cliente")) {
			request.getRequestDispatcher("/WEB-INF/cadastrar-cliente.jsp").forward(request, response);
		}
		
		//CADASTRAR
		else if (acao.equalsIgnoreCase("cadastrar-funcionario")) {
			String nome = request.getParameter("nome");
			String endereco = request.getParameter("endereco");
			String telefone = request.getParameter("telefone");
			
			Funcionario f = new Funcionario();
			f.setNome(nome);
			f.setEndereco(endereco);
			f.setTelefone(telefone);
			try {
				funcionarioDAO.cadastrar(f);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			response.sendRedirect("http://localhost:8080/ifpe-loja/LojaServlet?acao=listar-funcionarios");
		} 
		
		else if(acao.equalsIgnoreCase("cadastrar-venda")) {
			float valor = Float.parseFloat(request.getParameter("valor"));
			String descricao = request.getParameter("descricao");
			
			Venda v = new Venda();
			v.setValor(valor);
			v.setDescricao(descricao);
			
			try {
				vendaDAO.cadastrar(v);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("http://localhost:8080/ifpe-loja/LojaServlet?acao=listar-vendas");
		}
		
		else if(acao.equalsIgnoreCase("cadastrar-cliente")) {
			String nome = request.getParameter("nome");
			String endereco = request.getParameter("endereco");
			String telefone = request.getParameter("telefone");
			String cpf = request.getParameter("cpf");
			
			Cliente c = new Cliente();
			c.setNome(nome);
			c.setEndereco(endereco);
			c.setTelefone(telefone);
			c.setCpf(cpf);
			
			try {
				clienteDAO.cadastrar(c);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("http://localhost:8080/ifpe-loja/LojaServlet?acao=listar-clientes");
		}
		
		//LISTAR
		else if(acao.equalsIgnoreCase("listar-funcionarios")) {
			List<Funcionario> funcionarios = funcionarioDAO.listar();
			request.setAttribute("funcionarios", funcionarios);
			request.getRequestDispatcher("/WEB-INF/lista-funcionarios.jsp").forward(request,response);
		}
		
		else if(acao.equalsIgnoreCase("listar-vendas")) {
			List<Venda> vendas = vendaDAO.listar();
			request.setAttribute("vendas", vendas);
			request.getRequestDispatcher("/WEB-INF/lista-vendas.jsp").forward(request,response);
		} 
		
		else if(acao.equalsIgnoreCase("listar-clientes")) {
			List<Cliente> clientes = clienteDAO.listar();
			request.setAttribute("clientes", clientes);
			request.getRequestDispatcher("/WEB-INF/lista-clientes.jsp").forward(request,response);
		} 
		
		//REMOVER
		else if(acao.equalsIgnoreCase("remover-funcionario")) {
			int id = Integer.parseInt(request.getParameter("id"));
			funcionarioDAO.remover(id);
			response.sendRedirect("/WEB-INF/lista-funcionarios.jsp");
		}
		
		else if(acao.equalsIgnoreCase("remover-venda")) {
			int id = Integer.parseInt(request.getParameter("id"));
			vendaDAO.remover(id);
			response.sendRedirect("/WEB-INF/lista-vendas.jsp");
		}
		
		else if(acao.equalsIgnoreCase("remover-cliente")) {
			int id = Integer.parseInt(request.getParameter("id"));
			clienteDAO.remover(id);
			response.sendRedirect("/WEB-INF/lista-clientes.jsp");
		}
		
		//ATUALIZAR
		else if(acao.equalsIgnoreCase("atualizar-funcionario")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String nome = request.getParameter("nome");
			String endereco = request.getParameter("endereco");
			String telefone = request.getParameter("telefone");
			
			Funcionario f = new Funcionario();
			f.setNome(nome);
			f.setEndereco(endereco);
			f.setTelefone(telefone);
			funcionarioDAO.atualizar(f);
			response.sendRedirect("/WEB-INF/lista-funcionarios.jsp");
		}

		else if((acao.equalsIgnoreCase("atualizar-venda"))) {
			int id = Integer.parseInt(request.getParameter("id"));
			float valor = Float.parseFloat(request.getParameter("valor"));
			String descricao = request.getParameter("descricao");
			
			Venda v = new Venda();
			v.setValor(valor);
			v.setDescricao(descricao);
			vendaDAO.atualizar(v);
			response.sendRedirect("/WEB-INF/lista-vendas.jsp");
		}
		
		else if((acao.equalsIgnoreCase("atualizar-cliente"))) {
			int id = Integer.parseInt(request.getParameter("id"));
			String nome = request.getParameter("nome");
			String endereco = request.getParameter("endereco");
			String telefone = request.getParameter("telefone");
			String cpf = request.getParameter("cpf");
			
			Cliente c = new Cliente();
			c.setNome(nome);
			c.setEndereco(endereco);
			c.setTelefone(telefone);
			c.setCpf(cpf);
			clienteDAO.atualizar(c);
			response.sendRedirect("/WEB-INF/lista-clientes.jsp");
		}
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
