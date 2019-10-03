package unn.jdbctest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//ORM

public class XDAO { // Data Access Object
	private Connection conn;
	private PreparedStatement findAllPs = null;
	private PreparedStatement insertPs = null;
	
	public XDAO(final Connection c) {
		conn = c;
	}
	
	public void insert(X x) throws Throwable {
		initInsertPs();
		insertPs.setString(1, x.getValue1());
		insertPs.setInt(2, x.getValue2());
		insertPs.executeUpdate();
	}
	
	public List<X> findAll() throws Throwable {
		initFindAllPs();
		ResultSet rs = findAllPs.executeQuery();
		List<X> result = new ArrayList<X>();
		while(rs.next()) {
			result.add(new X(rs.getInt(1), rs.getString(2), rs.getInt(3)));
		}
		rs.close();
		return result;
	}
	
	private void initFindAllPs() throws Throwable {
		if(findAllPs == null) {
			findAllPs = conn.prepareStatement("select * from x");
		}
	}
	
	private void initInsertPs() throws Throwable {
		if(insertPs == null) {
			insertPs = conn.prepareStatement("insert into x values((select max(id) + 1 from x), ?, ?)");
		}
	}
}
