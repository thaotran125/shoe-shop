package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BUSlogic.ThuongHieuBL;
import BUSlogic.sanphamBL;
import JavaBean.SanPham;
import JavaBean.ThuongHieu;

/**
 * Servlet implementation class indexServlet
 */
@WebServlet({"/indexServlet","/index.html"})
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public indexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		List<ThuongHieu> dsth=ThuongHieuBL.loadAdd();
		request.setAttribute("dsth", dsth);
		SanPham sp=sanphamBL.getspTop1();
		
		String sql="SELECT * FROM `sanpham` ORDER by masp ASC";
		int tongSoTrang=sanphamBL.TongSoTrang(6, sql);
		int trang;
		if(request.getParameter("trang")==null)
			trang=1;
		else
			trang=Integer.parseInt(request.getParameter("trang"));
		List<SanPham> ds=sanphamBL.phanTrangSP(6, trang);
		HttpSession session=request.getSession();
		
		request.setAttribute("dsp", ds);
		request.setAttribute("trang", trang);
		request.setAttribute("tongSoTrang", tongSoTrang);
		request.setAttribute("tk",session.getAttribute("tk"));
		request.setAttribute("p", sp);
		//HttpSession session = request.getSession(false);
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
