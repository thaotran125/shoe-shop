package JavaBean;

public class ThuongHieu {
	private int maThuongHieu;
	private String tenThuongHieu;
	private String logo;
	public ThuongHieu() {
		super();
	}
	public ThuongHieu(int maThuongHieu, String tenThuongHieu, String logo) {
		super();
		this.maThuongHieu = maThuongHieu;
		this.tenThuongHieu = tenThuongHieu;
		this.logo = logo;
	}
	public int getMaThuongHieu() {
		return maThuongHieu;
	}
	public void setMaThuongHieu(int maThuongHieu) {
		this.maThuongHieu = maThuongHieu;
	}
	public String getTenThuongHieu() {
		return tenThuongHieu;
	}
	public void setTenThuongHieu(String tenThuongHieu) {
		this.tenThuongHieu = tenThuongHieu;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
}
