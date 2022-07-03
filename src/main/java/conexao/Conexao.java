package conexao;

import java.sql.*;

public class Conexao {
	
	private static final String USER="root";
	private static final String PASSWORD="123456";
	
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/loja";
	
	public static Connection conectar() throws Exception{
		Class.forName("org.postgresql.Driver");
		Connection conexao = DriverManager.getConnection(DATABASE_URL, PASSWORD, USER);
		return conexao;
	}
	
	public static void main (String [] args) throws Exception{
		Connection con = conectar();
		if(con==null) {
			con.close();
		}
	}

}
