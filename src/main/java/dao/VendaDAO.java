package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import conexao.Conexao;
import model.Funcionario;
import model.Venda;

public class VendaDAO {
	
	public void cadastrar(Venda venda) throws SQLException {
		String sql = "INSERT INTO vendas (valor,descricao) VALUES (?,?);";
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = Conexao.conectar();
			pstm = con.prepareStatement(sql);
			pstm.setFloat(1, venda.getValor());
			pstm.setString(2, venda.getDescricao());
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
	
	public List<Venda> listar() {
		PreparedStatement pstm = null;
		Connection con = null;
		String sql = "SELECT * FROM vendas;";
		List<Venda> vendas = null;
		ResultSet rs = null;
		
		try {
			con = Conexao.conectar();
			pstm = con.prepareStatement(sql);

			rs = pstm.executeQuery();
			while(rs.next()) {
				Venda venda = new Venda();
				venda.setValor(rs.getFloat("valor"));
				venda.setDescricao(rs.getString("descricao"));
				vendas.add(venda);
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
		return vendas;
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
	
	public void atualizar(Venda venda){
		PreparedStatement pstm = null;
		Connection con = null;
		String sql = "UPDATE funcnionarios SET valor = ?, descricao = ? WHERE id = ?;";
		
		try {
			con = Conexao.conectar();
			pstm = con.prepareStatement(sql);
			pstm.setInt(3, venda.getId());
			pstm.setFloat(1, venda.getValor());
			pstm.setString(2, venda.getDescricao());
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
	
	public Venda pegarPorId(int id) {
		PreparedStatement pstm = null;
		Connection con = null;
		String sql = "SELECT valor,descricao FROM funcionarios WHERE id = ?;";
		Venda venda = null;
		ResultSet rs = null;
		
		try {
			con = Conexao.conectar();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			
			rs = pstm.executeQuery();
			while(rs.next()) {
				venda = new Venda();
				venda.setValor(rs.getFloat("valor"));
				venda.setDescricao(rs.getString("descricao"));
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
				
		return venda;
	}

}
