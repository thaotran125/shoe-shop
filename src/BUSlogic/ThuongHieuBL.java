package BUSlogic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import JavaBean.ThuongHieu;

public class ThuongHieuBL {
	public static List<ThuongHieu> loadBD(String sql){
	 List<ThuongHieu> ds=new ArrayList<ThuongHieu>();
	 try (Connection conn=SQLConncect.getConn()){
		Statement stm=conn.createStatement();
		ResultSet rs=stm.executeQuery(sql);
		
		while(rs.next()) {
			ThuongHieu th=new ThuongHieu();
			th.setMaThuongHieu(rs.getInt(1));
			th.setTenThuongHieu(rs.getString(2));
			th.setLogo(rs.getString(3));
			ds.add(th);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return ds;
  }
	
	public static List<ThuongHieu> loadAdd() {
		String sql="select * from thuonghieu";
		List<ThuongHieu> ds=loadBD(sql);
		return ds;
	}
}
