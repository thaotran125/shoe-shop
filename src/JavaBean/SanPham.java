package JavaBean;

public class SanPham {
	private int masp;
	private int maThuongHieu;
	private String tensp;
	private int gia;
	private int giaGiam;
	private String hinh;
	private int sl;
	private int phai;
	private String title;
	private String mota;
	public SanPham() {
		super();
	}
	
	public SanPham(int masp, int maThuongHieu, String tensp, int gia, int giaGiam, String hinh, int sl, int phai,
			String title, String mota) {
		super();
		this.masp = masp;
		this.maThuongHieu = maThuongHieu;
		this.tensp = tensp;
		this.gia = gia;
		this.giaGiam = giaGiam;
		this.hinh = hinh;
		this.sl = sl;
		this.phai = phai;
		this.title = title;
		this.mota = mota;
	}

	public int getMasp() {
		return masp;
	}

	public void setMasp(int masp) {
		this.masp = masp;
	}

	public int getMaThuongHieu() {
		return maThuongHieu;
	}

	public void setMaThuongHieu(int maThuongHieu) {
		this.maThuongHieu = maThuongHieu;
	}

	public String getTensp() {
		return tensp;
	}

	public void setTensp(String tensp) {
		this.tensp = tensp;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public int getGiaGiam() {
		return giaGiam;
	}

	public void setGiaGiam(int giaGiam) {
		this.giaGiam = giaGiam;
	}

	public String getHinh() {
		return hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
	}

	public int getSl() {
		return sl;
	}

	public void setSl(int sl) {
		this.sl = sl;
	}

	public int getPhai() {
		return phai;
	}

	public void setPhai(int phai) {
		this.phai = phai;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public SanPham(int maThuongHieu, String tensp, int gia, int giaGiam, String hinh, int sl, int phai, String title,
			String mota) {
		super();
		this.maThuongHieu = maThuongHieu;
		this.tensp = tensp;
		this.gia = gia;
		this.giaGiam = giaGiam;
		this.hinh = hinh;
		this.sl = sl;
		this.phai = phai;
		this.title = title;
		this.mota = mota;
	}
	
	
	
}
