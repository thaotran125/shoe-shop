package JavaBean;

import java.util.Date;

public class TaiKhoan {
	private String tenTK;
	private String matKhau;
	private String ten;
	private int phai;
	private String sdt;
	private String mail;
	private String dc;
	private int isAdmin;
	
	public TaiKhoan() {
		super();
	}

	public TaiKhoan(String tenTK, String matKhau, String ten, int phai, String sdt, String mail,
			String dc, int isAdmin) {
		super();
		this.tenTK = tenTK;
		this.matKhau = matKhau;
		this.ten = ten;
		this.phai = phai;
		this.sdt = sdt;
		this.mail = mail;
		this.dc = dc;
		this.isAdmin = isAdmin;
	}

	public String getTenTK() {
		return tenTK;
	}

	public void setTenTK(String tenTK) {
		this.tenTK = tenTK;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getPhai() {
		return phai;
	}

	public void setPhai(int phai) {
		this.phai = phai;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getDc() {
		return dc;
	}

	public void setDc(String dc) {
		this.dc = dc;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
}
