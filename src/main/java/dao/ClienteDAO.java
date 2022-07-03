package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import conexao.Conexao;
import model.Cliente;

public class ClienteDAO {

	public void cadastrar(Cliente cliente) throws SQLException {
		String sql = "INSERT INTO clientes (nome,endereco,telefone,cpf) VALUES (?,?,?,?);";
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = Conexao.conectar();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getEndereco());
			pstm.setString(3, cliente.getTelefone());
			pstm.setString(4, cliente.getCpf());
			pstm.execute();
			
		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			try {
				pstm.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace(); 
			}
		}
	}
	
	public List<Cliente> listar() {
		PreparedStatement pstm = null;
		Connection con = null;
		String sql = "SELECT * FROM vendas;";
		List<Cliente> clientes = null;
		ResultSet rs = null;
		
		try {
			con = Conexao.conectar();
			pstm = con.prepareStatement(sql);

			rs = pstm.executeQuery();
			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setNome(rs.getString("nome"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setCpf(rs.getString("cpf"));
				clientes.add(cliente);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				con.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return clientes;
	}
	
	public void remover(int id) {
		PreparedStatement pstm = null;
		Connection con = null;
		String sql = "DELETE FROM clientes WHERE id = ?;";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				pstm.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace(); 
			}
		}
	}
	
	public void atualizar(Cliente cliente){
		PreparedStatement pstm = null;
		Connection con = null;
		String sql = "UPDATE funcnionarios SET nome = ?, endereco = ?, telefone = ?, cpf = ? WHERE id = ?;";
		
		try {
			con = Conexao.conectar();
			pstm = con.prepareStatement(sql);
			pstm.setInt(5, cliente.getId());
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getEndereco());
			pstm.setString(3, cliente.getTelefone());
			pstm.setString(4, cliente.getCpf());
			pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Cliente pegarPorId(int id) {
		PreparedStatement pstm = null;
		Connection con = null;
		String sql = "SELECT valor,descricao FROM funcionarios WHERE id = ?;";
		Cliente cliente = null;
		ResultSet rs = null;
		
		try {
			con = Conexao.conectar();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			
			rs = pstm.executeQuery();
			while(rs.next()) {
				cliente = new Cliente();
				cliente.setNome(rs.getString("nome"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setCpf(rs.getString("cpf"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return cliente;
	}
	
}
