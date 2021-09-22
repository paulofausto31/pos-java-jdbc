package pos_java_jdbc.pos_java_jdbc;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import conexaojdbc.SingleConnection;
import dao.UserPosDAO;
import model.Userposjava;

public class TesteBancojdbc {
	
	@Test
	public void initBanco() throws SQLException {
		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userPosJava = new Userposjava();
		
		userPosJava.setNome("Pablo Neves");
		userPosJava.setEmail("pabloneves@gmail.com");
		
		userPosDAO.Salvar(userPosJava);
	}
	
	@Test
	public void initListar() throws SQLException {
		UserPosDAO userPosDAO = new UserPosDAO();
		List<Userposjava> list = userPosDAO.Listar();
		
		for (Userposjava userPosJava : list) {
			System.out.println(userPosJava.toString());
			
		}
		
	}

}
