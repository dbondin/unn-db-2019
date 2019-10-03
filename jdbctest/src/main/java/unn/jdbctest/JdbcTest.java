package unn.jdbctest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class JdbcTest {

	public static void f1(Connection c) throws Throwable {
		
		c.setAutoCommit(false);
		c.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
		
		String sql = "insert into x values((select max(id) + 1 from x), 'transaction-' || (select max(id) + 1 from x), 0)";
		c.createStatement().executeUpdate(sql);
		
		read(c);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter something: ");
		String userInput = sc.nextLine();

		String sql2 = "insert into x values((select max(id) + 1 from x), 'transaction-' || (select max(id) + 1 from x), 1)";
		c.createStatement().executeUpdate(sql2);
		
		c.commit();
	}
	
	public static void f2(Connection c) throws Throwable {
		c.setAutoCommit(false);
		c.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
		
		read(c);

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter something: ");
		String userInput = sc.nextLine();

		read(c);
				
		c.commit();
	}
	
	public static void read(Connection c) throws Throwable {
		PreparedStatement ps = c.prepareStatement("select * from x order by id desc");
		ResultSet rs = ps.executeQuery();
		int count = rs.getMetaData().getColumnCount();
		int x=5;
		while(rs.next() && x != 0) {
			--x;
			for(int i=0; i<count; ++i) {
				System.out.print(rs.getString(i + 1));
				System.out.print(" | ");
			}
			System.out.println();
		}
		rs.close();
	}
	
	public static void main(String[] args) throws Throwable {
	
		final Connection c = DriverManager.getConnection("jdbc:postgresql://192.168.99.100/test", "test", "test");

		XDAO xdao = new XDAO(c);
		
		List<X> l = xdao.findAll();
		
		for(X x : l) {
			System.out.println(x);
		}
		
		xdao.insert(new X(-1, "HAHAHA", 321));
		
		//Statement s = c.createStatement();

		//f2(c);
		
//		CallableStatement cs = c.prepareCall("{call fffff(?)}");
//		cs.setInt(1, 3);
//		ResultSet rs = cs.executeQuery();
//		rs.next();
//		Object o = rs.getObject(1);
//		System.out.println(o);
		
		
//		for(int i=0; i<10000; ++i) {
//			String sql = "insert into x values(" + i + ", 'Что-то " + i + "', " + (i * 10) + ")";
//			s.executeUpdate(sql);
//			if(i%100 == 0) {
//				System.out.println(i + " " + sql);
//			}
//		}
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter value: ");
//		String userInput = sc.nextLine();
//		System.out.println(String.format("User input '%s'", userInput));
		
		//String sql = "insert into x values((select max(id) + 1 from x), '" + userInput + "', 0)";
		//s.executeUpdate(sql);
//		PreparedStatement ps = c.prepareStatement("insert into x values((select max(id) + 1 from x), ?, 0)");
//		ps.setString(1, userInput);
//		ps.executeUpdate();

//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter search term: ");
//		String userInput = sc.nextLine();
		
		// select * from x where value like '%?%'
//		PreparedStatement ps = c.prepareStatement("select * from x where value1 ilike ?");
//		ps.setString(1, "%" + userInput + "%");
//		ResultSet rs = ps.executeQuery();
//		int count = rs.getMetaData().getColumnCount();
//		for(int i=0; i<count; ++i) {
//			System.out.print(rs.getMetaData().getColumnName(i + 1));
//			System.out.print(" | ");
//		}
//		System.out.println();
//		while(rs.next()) {
//			for(int i=0; i<count; ++i) {
//				System.out.print(rs.getString(i + 1));
//				System.out.print(" | ");
//			}
//			System.out.println();
//		}
		//?? System.out.println("ISOLATION: " + c.getTransactionIsolation());
//		rs.close();
//		s.close();
//		c.close();
//		
//		System.out.println("DONE");
	}
	
}
