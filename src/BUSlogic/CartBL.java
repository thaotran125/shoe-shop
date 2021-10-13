package BUSlogic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import JavaBean.Order;

public class CartBL {
	public static Order getItem(int id) {
		Order o=null;
		try(Connection cnn=SQLConncect.getConn()) {
			Statement stm=cnn.createStatement();
			String sql="SELECT * FROM `sanpham` WHERE masp='"+id+"'";
			ResultSet rs=stm.executeQuery(sql);
			if(rs.next()) {
				int masp=rs.getInt(1);
				String tensp=rs.getString(3);
				int giagiam=rs.getInt(5);
				String hinh=rs.getString(6);
				o=new Order(masp, tensp, hinh, giagiam, 1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
}
