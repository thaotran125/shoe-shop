package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
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
 * Servlet implementation class BrowserServlet
 */
@WebServlet({ "/BrowserServlet", "/Browser.html" })
public class BrowserServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BrowserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idth=Integer.parseInt(request.getParameter("maThuongHieu"));
		request.setAttribute("cid", idth);
		
		List<ThuongHieu> dsth=ThuongHieuBL.loadAdd();
		request.setAttribute("dsth", dsth);
		
		List<SanPham> dsp=sanphamBL.loadspTheoTH(idth);
		request.setAttribute("arrp", dsp);
		
		SanPham sp=sanphamBL.getspTop1();
		request.setAttribute("p", sp);
		
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
