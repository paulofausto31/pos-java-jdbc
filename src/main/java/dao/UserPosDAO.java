package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.Userposjava;

public class UserPosDAO {
	
	private Connection connection;
	
	public UserPosDAO() {
		connection = SingleConnection.getConnection();
	}
	
	public void Salvar(Userposjava userPosJava) throws SQLException {
		String sql = "insert into userposjava (nome,email) values (?,?)";
		PreparedStatement insert;
		try {
			insert = connection.prepareStatement(sql);
			insert.setString(1, userPosJava.getNome());
			insert.setString(2, userPosJava.getEmail());
			insert.execute();
			connection.commit(); //Salva no banco
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}

	}
	
	public List<Userposjava> Listar() throws SQLException{
		List<Userposjava> list = new ArrayList<Userposjava>();
		
		String sql = "Select * from userposjava";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		ResultSet resultado = statement.executeQuery();
		
		while (resultado.next()) {
			Userposjava userPosJava = new Userposjava();
			userPosJava.setNome(resultado.getString("nome"));
			userPosJava.setEmail(resultado.getString("email"));
			
			list.add(userPosJava);
		}
		
		return list;
	}

}
