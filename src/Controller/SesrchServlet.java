package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BUSlogic.ThuongHieuBL;
import BUSlogic.sanphamBL;
import JavaBean.SanPham;
import JavaBean.ThuongHieu;

/**
 * Servlet implementation class SesrchServlet
 */
@WebServlet({ "/SesrchServlet", "/search.html" })
public class SesrchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SesrchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("txt/html; charset=UTF-8");
		request.setCharacterEncoding("Utf-8");
		response.setCharacterEncoding("UTF-8");
		
		String txtSearch=request.getParameter("txtsearch");
		List<ThuongHieu> dsth=ThuongHieuBL.loadAdd();
		SanPham sp=sanphamBL.getspTop1();
		String sql="SELECT masp, sanpham.mathuonghieu,tensp,giaban,giadagiam, hinh,soluong,phai ,Title,mota  FROM `sanpham`, thuonghieu where tensp like '%"+txtSearch+"%' OR tenThuongHieu LIKE '%"+txtSearch+"%' and sanpham.mathuonghieu=thuonghieu.maThuongHieu GROUP by masp";
		int tongSoTrang=sanphamBL.TongSoTrang(6, sql);
		int trang;
		if(request.getParameter("trang")==null)
			trang=1;
		else
			trang=Integer.parseInt(request.getParameter("trang"));
		List<SanPham> ds=sanphamBL.phanTrangSearch(6, trang, txtSearch);
		if(ds.size()>0) {
			request.setAttribute("trang", trang);
			request.setAttribute("tongSoTrang", tongSoTrang);
			request.setAttribute("p", sp);
			request.setAttribute("dsSearch", ds);
			request.setAttribute("kq", 1);
		}
		else {
			request.setAttribute("mess", "không tìm thấy sản phẩm");
		}
		request.setAttribute("dsth", dsth);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
