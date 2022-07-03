package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import conexao.Conexao;
import model.Funcionario;

public class FuncionarioDAO {
	
	public void cadastrar(Funcionario funcionario) throws SQLException {
		String sql = "INSERT INTO funcionarios (nome,endereco,telefone) VALUES (?,?,?);";
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = Conexao.conectar();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, funcionario.getNome());
			pstm.setString(2, funcionario.getEndereco());
			pstm.setString(3, funcionario.getTelefone());
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
	
	public List<Funcionario> listar() {
		PreparedStatement pstm = null;
		Connection con = null;
		String sql = "SELECT * FROM funcionarios;";
		List<Funcionario> funcionarios = null;
		ResultSet rs = null;
		
		try {
			con = Conexao.conectar();
			pstm = con.prepareStatement(sql);

			rs = pstm.executeQuery();
			while(rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setNome(rs.getString("nome"));
				funcionario.setEndereco(rs.getNString("endereco"));
				funcionario.setTelefone(rs.getString("telefone"));
				funcionarios.add(funcionario);
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
		return funcionarios;
	}
	
	public void remover(int id) {
		PreparedStatement pstm = null;
		Connection con = null;
		String sql = "DELETE FROM funcionarios WHERE id = ?;";
		
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
	
	public void atualizar(Funcionario funcionario){
		PreparedStatement pstm = null;
		Connection con = null;
		String sql = "UPDATE funcnionarios SET nome = ?, endereco = ?, telefone = ? WHERE id = ?;";
		
		try {
			con = Conexao.conectar();
			pstm = con.prepareStatement(sql);
			pstm.setInt(4, funcionario.getId());
			pstm.setString(1, funcionario.getNome());
			pstm.setString(2, funcionario.getEndereco());
			pstm.setString(3, funcionario.getTelefone());
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
	
	public Funcionario pegarPorId(int id) {
		PreparedStatement pstm = null;
		Connection con = null;
		String sql = "SELECT nome,endereco,telefone FROM funcionarios WHERE id = ?;";
		Funcionario funcionario = null;
		ResultSet rs = null;
		
		try {
			con = Conexao.conectar();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			
			rs = pstm.executeQuery();
			while(rs.next()) {
				funcionario = new Funcionario();
				funcionario.setNome(rs.getString("nome"));
				funcionario.setEndereco(rs.getString("enderco"));
				funcionario.setTelefone(rs.getString("telefone"));
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
				
		return funcionario;
	}

}
