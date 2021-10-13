package BUSlogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import JavaBean.SanPham;
import JavaBean.ThongTin;

public class sanphamBL {
	
		public static List<SanPham> LoadDB(String sql) {
			List<SanPham> list=new ArrayList<SanPham>();
			try (Connection conn=SQLConncect.getConn()){
				Statement stm=conn.createStatement();
				ResultSet rs=stm.executeQuery(sql);
				
				while(rs.next()) {
					SanPham sp=new SanPham();
					sp.setMasp(rs.getInt(1));
					sp.setMaThuongHieu(rs.getInt(2));
					sp.setTensp(rs.getString(3));
					sp.setGia(rs.getInt(4));
					sp.setGiaGiam(rs.getInt(5));
					sp.setHinh(rs.getString(6));
					sp.setSl(rs.getInt(7));
					sp.setPhai(rs.getInt(8));
					sp.setTitle(rs.getString(9));
					sp.setMota(rs.getString(10));
					list.add(sp);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			return list;
		}
		
		public static List<SanPham> loadAllsp() {
			String sql="SELECT * FROM `sanpham` ORDER by masp DESC";
			List<SanPham> list=LoadDB(sql);
			return list;
		}
		
		public static int TongSoTrang(int soDongTrang, String sql) {
			int tongSoTrang, tongSoDong;
			List<SanPham> ds=LoadDB(sql);
			tongSoDong=ds.size();
			tongSoTrang=tongSoDong/soDongTrang+(tongSoDong%soDongTrang==0?0:1);
			return tongSoTrang;
		}
		
		public static List<SanPham> phanTrangSP(int soDongTrang, int trang){
			int vitri=(trang-1)*soDongTrang;
			String sql="SELECT * FROM `sanpham` ORDER by masp DESC limit "+vitri+" , " +soDongTrang;
			List<SanPham> ds=LoadDB(sql);
			return ds;
		}
		
		public static SanPham getSanPham(int id) {
			SanPham sp=null;
			try (Connection conn=SQLConncect.getConn()){
				Statement stm=conn.createStatement();
				String sql="select * from sanpham where masp='"+id+"'" ;
				ResultSet rs=stm.executeQuery(sql);
				if(rs.next()) {
					int masp=rs.getInt(1);
					int math=rs.getInt(2);
					String tensp=rs.getString(3);
					int gia=rs.getInt(4);
					int giagiam=rs.getInt(5);
					String hinh=rs.getString(6);
					int sl=rs.getInt(7);
					int phai=rs.getInt(8);
					String title=rs.getString(9);
					String mota=rs.getString(10);
					sp=new SanPham(masp, math, tensp, gia, giagiam, hinh, sl, phai, title, mota);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return sp;
		}
		
		public static ThongTin getThongTin(int id) {
			ThongTin tt=null;
			try (Connection conn=SQLConncect.getConn()){
				Statement stm=conn.createStatement();
				String sql="SELECT * FROM `thongtinsp`";
				ResultSet rs=stm.executeQuery(sql);
				
				if(rs.next()) {
					int masp=rs.getInt(1);
					int chieucao=rs.getInt(2);
					String hinhct=rs.getString(3);
					tt=new ThongTin(masp, chieucao, hinhct);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return tt;
		}
		
		public static List<SanPham> loadspTheoTH(int id){
			String sql="SELECT * FROM `sanpham` WHERE mathuonghieu="+id;
			List<SanPham> ds=LoadDB(sql);
			return ds;
		}
		
		public static List<SanPham> searchProductt(String txt){
			String sql="SELECT masp, sanpham.mathuonghieu,tensp,giaban,giadagiam, hinh,soluong,phai,Title,mota FROM `sanpham`, thuonghieu where tensp like '%"+txt+"%' OR tenThuongHieu LIKE '%"+txt+"%' and sanpham.mathuonghieu=thuonghieu.maThuongHieu GROUP by masp";
			List<SanPham> ds=LoadDB(sql);
			return ds;
		}
		
		public static List<SanPham> phanTrangSearch(int soDongTrang, int trang, String txt){
			int vitri=(trang-1)*soDongTrang;
			String sql="SELECT masp, sanpham.mathuonghieu,tensp,giaban,giadagiam, hinh,soluong,phai,Title,mota FROM `sanpham`, thuonghieu where tensp like '%"+txt+"%' OR tenThuongHieu LIKE '%"+txt+"%' and sanpham.mathuonghieu=thuonghieu.maThuongHieu GROUP by masp limit "+vitri+" , " +soDongTrang;
			List<SanPham> ds=LoadDB(sql);
			return ds;
		}
		
		public static long insertSP(SanPham sp) {
			long kq=0;
			String sql="INSERT INTO `sanpham` (`masp`, `mathuonghieu`, `tensp`, `giaban`, `giadagiam`, `hinh`, `soluong`, `phai`, `Title`, `mota`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?);";
			try (Connection cnn=SQLConncect.getConn()){
				PreparedStatement pstm=cnn.prepareStatement(sql);
				pstm.setInt(1, sp.getMasp());
				pstm.setInt(2, sp.getMaThuongHieu());
				pstm.setString(3, sp.getTensp());
				pstm.setInt(4, sp.getGia());
				pstm.setInt(5, sp.getGiaGiam());
				pstm.setString(6, sp.getHinh());
				pstm.setInt(7, sp.getSl());
				pstm.setInt(8, sp.getPhai());
				pstm.setString(9, sp.getTitle());
				pstm.setString(10, sp.getMota());
			    kq=pstm.executeLargeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return kq;
		}
		
		public static long updateSP(SanPham sp) {
			long kq=0;
			String sql="UPDATE `sanpham` SET `mathuonghieu` = ?, `tensp` = ?, `giaban` = ?, `giadagiam` = ?, `hinh` = ?, `soluong` = ?, `phai` = ?, `Title` = ?, `mota` = ? WHERE `sanpham`.`masp` = ?;";
			try (Connection cnn=SQLConncect.getConn()){
				PreparedStatement pstm=cnn.prepareStatement(sql);
				pstm.setInt(10, sp.getMasp());
				pstm.setInt(1, sp.getMaThuongHieu());
				pstm.setString(2, sp.getTensp());
				pstm.setInt(3, sp.getGia());
				pstm.setInt(4, sp.getGiaGiam());
				pstm.setString(5, sp.getHinh());
				pstm.setInt(6, sp.getSl());
				pstm.setInt(7, sp.getPhai());
				pstm.setString(8, sp.getTitle());
				pstm.setString(9, sp.getMota());
			    kq=pstm.executeLargeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return kq;
		}
		
		public static int delete (int id) {
			int kq=0;
			try (Connection cnn=SQLConncect.getConn()){
				Statement stm=cnn.createStatement();
				String sql="delete from sanpham where masp='"+id+"'";
				kq=stm.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return kq;
		}
		
		public static SanPham getspTop1() {
			String sql="SELECT *FROM `sanpham` ORDER BY masp DESC LIMIT 1";
			SanPham sp=null;
			try (Connection conn=SQLConncect.getConn()){
				Statement stm=conn.createStatement();
				ResultSet rs=stm.executeQuery(sql);
				if(rs.next()) {
					int masp=rs.getInt(1);
					int math=rs.getInt(2);
					String tensp=rs.getString(3);
					int gia=rs.getInt(4);
					int giagiam=rs.getInt(5);
					String hinh=rs.getString(6);
					int sl=rs.getInt(7);
					int phai=rs.getInt(8);
					String title=rs.getString(9);
					String mota=rs.getString(10);
					sp=new SanPham(masp, math, tensp, gia, giagiam, hinh, sl, phai, title, mota);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return sp;
		}
}














