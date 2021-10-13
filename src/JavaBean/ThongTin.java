package JavaBean;

public class ThongTin {
	private int masp;
	private int chieucao;
	private String hinhct;
	
	public ThongTin() {
		super();
	}

	public ThongTin(int masp, int chieucao, String hinhct) {
		super();
		this.masp = masp;
		this.chieucao = chieucao;
		this.hinhct = hinhct;
	}

	public int getMasp() {
		return masp;
	}

	public void setMasp(int masp) {
		this.masp = masp;
	}

	public int getChieucao() {
		return chieucao;
	}

	public void setChieucao(int chieucao) {
		this.chieucao = chieucao;
	}

	public String getHinhct() {
		return hinhct;
	}

	public void setHinhct(String hinhct) {
		this.hinhct = hinhct;
	}
	
	
}
