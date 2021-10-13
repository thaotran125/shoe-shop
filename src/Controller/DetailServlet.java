package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BUSlogic.ThongTInBL;
import BUSlogic.ThuongHieuBL;
import BUSlogic.sanphamBL;
import JavaBean.SanPham;
import JavaBean.ThongTin;
import JavaBean.ThuongHieu;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet({ "/DetailServlet", "/Detail.html" })
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int maSP=Integer.parseInt(request.getParameter("maSP"));
		List<ThuongHieu> dsth=ThuongHieuBL.loadAdd();
		SanPham sp=sanphamBL.getspTop1();
		SanPham s=sanphamBL.getSanPham(maSP);
		
		request.setAttribute("dsth", dsth);
		request.setAttribute("maSP", maSP);
		request.setAttribute("p", sp);
		request.setAttribute("ctp", s);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
