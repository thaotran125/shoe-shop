package BUSlogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import JavaBean.SanPham;
import JavaBean.TaiKhoan;

public class TaiKhoanBL {
	public static List<TaiKhoan> loadDB(String sql) {
		 List<TaiKhoan> ds=new ArrayList<TaiKhoan>();
		 try(Connection cnn=SQLConncect.getConn()) {
			Statement stm=cnn.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next()) {
				TaiKhoan tk=new TaiKhoan();
				tk.setTenTK(rs.getString(1));
				tk.setMatKhau(rs.getString(2));
				tk.setTen(rs.getString(3));
				tk.setPhai(rs.getInt(4));
				tk.setSdt(rs.getString(5));
				tk.setMail(rs.getString(6));
				tk.setDc(rs.getString(7));
				tk.setIsAdmin(rs.getInt(8));
				ds.add(tk);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return ds;
	}
	
	public static List<TaiKhoan> loadAddAc(){
		String sql="SELECT * FROM `taikhoan` where isAdmin = 0 ";
		List<TaiKhoan> ds=loadDB(sql);
		return ds;
	}
	
	public static int TongSoTrang(int soDongTrang, String sql) {
		int tongSoTrang, tongSoDong;
		List<TaiKhoan> ds=loadDB(sql);
		tongSoDong=ds.size();
		tongSoTrang=tongSoDong/soDongTrang+(tongSoDong%soDongTrang==0?0:1);
		return tongSoTrang;
	}
	
	public static List<TaiKhoan> phanTrangAcc(int soDongTrang, int trang){
		int vitri=(trang-1)*soDongTrang;
		String sql="SELECT * FROM `taikhoan` where isAdmin = 0  ORDER by tentaikhoan DESC limit "+vitri+" , " +soDongTrang;
		List<TaiKhoan> ds=loadDB(sql);
		return ds;
	}
	
	public static TaiKhoan getTaiKhoan(String user, String pass) {
		TaiKhoan tk=null;
		try(Connection cnn=SQLConncect.getConn()) {
			Statement stm=cnn.createStatement();
			String sql="SELECT * FROM `taikhoan` WHERE tentaikhoan='"+user+"' and matkhau='"+pass+"'";
			ResultSet rs=stm.executeQuery(sql);
			
			if(rs.next()) {
				String username=rs.getString(1);
				String mk=rs.getString(2);
				String name=rs.getString(3);
				int phai=rs.getInt(4);
				String sdt=rs.getString(5);
				String mail=rs.getString(6);
				String dc=rs.getString(7);
				int isAdmin=rs.getInt(8);
				tk=new TaiKhoan(username, mk, name, phai, sdt, mail, dc, isAdmin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tk;
	}
	
	public static TaiKhoan getTKByUserName(String user) {
		TaiKhoan tk=null;
		try(Connection cnn=SQLConncect.getConn()) {
			Statement stm=cnn.createStatement();
			String sql="SELECT * FROM `taikhoan` WHERE tentaikhoan='"+user+"'";
			ResultSet rs=stm.executeQuery(sql);
			
			if(rs.next()) {
				String username=rs.getString(1);
				String mk=rs.getString(2);
				String name=rs.getString(3);
				int phai=rs.getInt(4);
				String sdt=rs.getString(5);
				String mail=rs.getString(6);
				String dc=rs.getString(7);
				int isAdmin=rs.getInt(8);
				tk=new TaiKhoan(username, mk, name, phai, sdt, mail, dc, isAdmin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tk;
	}
	
	public static void insertTK(TaiKhoan tk) {
		try (Connection cnn=SQLConncect.getConn()){
			
			String sql="INSERT INTO `taikhoan` (`tentaikhoan`, `matkhau`, `Tenkhachhang`, `phai`, `sodienthoai`, `mail`, `diachi`, `isAdmin`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement pstm=cnn.prepareStatement(sql);
			pstm.setString(1, tk.getTenTK());
			pstm.setString(2, tk.getMatKhau());
			pstm.setString(3, tk.getTen());
			pstm.setInt(4, tk.getPhai());
			pstm.setString(5, tk.getSdt());
			pstm.setString(6, tk.getMail());
			pstm.setString(7, tk.getDc());
			pstm.setInt(8, tk.getIsAdmin());
			pstm.executeLargeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static TaiKhoan checkAccount(String user) {
		TaiKhoan tk=null;;
		try(Connection cnn=SQLConncect.getConn()) {
			Statement stm=cnn.createStatement();
			String sql="SELECT * FROM `taikhoan` WHERE tentaikhoan='"+user+"'";
			ResultSet rs=stm.executeQuery(sql);
			
			if(rs.next()) {
				String username=rs.getString(1);
				String mk=rs.getString(2);
				String name=rs.getString(3);
				int phai=rs.getInt(4);
				String sdt=rs.getString(5);
				String mail=rs.getString(6);
				String dc=rs.getString(7);
				int isAdmin=rs.getInt(8);
				tk=new TaiKhoan(username, mk, name, phai, sdt, mail, dc, isAdmin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tk;
	}
	
	public static void insertAcc(TaiKhoan tk) {
		String sql="INSERT INTO `taikhoan` (`tentaikhoan`, `matkhau`, `Tenkhachhang`, `phai`, `sodienthoai`, `mail`, `diachi`, `isAdmin`) VALUES (?, '?, ?, ?, ?, ?, ?, ?);";
		try (Connection cnn=SQLConncect.getConn()){
			PreparedStatement pstm=cnn.prepareStatement(sql);
			pstm.setString(1, tk.getTenTK());
			pstm.setString(2, tk.getMatKhau());
			pstm.setString(3, tk.getTen());
			pstm.setInt(4, tk.getPhai());
			pstm.setString(5, tk.getSdt());
			pstm.setString(6, tk.getMail());
			pstm.setString(7, tk.getDc());
			pstm.setInt(8, tk.getIsAdmin());
			pstm.executeLargeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static long updateAcc(TaiKhoan tk) {
		long kq=0;
		String sql="UPDATE `taikhoan` SET `Tenkhachhang` = ?, `phai` = ?, `sodienthoai` = ?, `mail` = ?, `diachi` = ?, `isAdmin` = ? WHERE `taikhoan`.`tentaikhoan` = ?; ";
		try (Connection cnn=SQLConncect.getConn()){
			PreparedStatement pstm=cnn.prepareStatement(sql);
			pstm.setString(7, tk.getTenTK());
			pstm.setString(1, tk.getTen());
			pstm.setInt(2, tk.getPhai());
			pstm.setString(3, tk.getSdt());
			pstm.setString(4, tk.getMail());
			pstm.setString(5, tk.getDc());
			pstm.setInt(6, tk.getIsAdmin());
			kq= pstm.executeLargeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kq;
	}
	
	public static int delAcc(String use) {
		int kq=0;
		try (Connection cnn=SQLConncect.getConn()){
			Statement stm=cnn.createStatement();
			String sql="DELETE FROM taikhoan WHERE tentaikhoan='"+use+"'";
			kq=stm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kq;
	}
}
