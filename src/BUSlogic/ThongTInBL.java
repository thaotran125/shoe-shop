package BUSlogic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import JavaBean.ThongTin;

public class ThongTInBL {
	public static ThongTin loadDBTT(int id){
		ThongTin tt=null;
		try(Connection cnn=SQLConncect.getConn()) {
			Statement stm=cnn.createStatement();
			String sql="SELECT * FROM `thongtinsp`";
			ResultSet rs=stm.executeQuery(sql);
			
			if(rs.next()) {
				int masp=rs.getInt(1);
				int chieucao=rs.getInt(2);
				String hinhct=rs.getString(3);
			    String mota=rs.getString(4);
			    String motact=rs.getString(5);
			    tt=new ThongTin(masp, chieucao, hinhct);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tt;
	}
	
	
}
