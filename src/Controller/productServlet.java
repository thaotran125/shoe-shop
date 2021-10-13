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
 * Servlet implementation class productServlet
 */
@WebServlet({ "/productServlet", "/product.html" })
public class productServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ThuongHieu> dsth=ThuongHieuBL.loadAdd();
		request.setAttribute("dsth", dsth);
		
		List<SanPham> arr=sanphamBL.loadAllsp();
		int tongsp=arr.size();
		String sql="SELECT * FROM `sanpham` ORDER by masp DESC";
		int tongSoTrang=sanphamBL.TongSoTrang(5, sql);
		int trang;
		if(request.getParameter("trang")==null)
			trang=1;
		else
			trang=Integer.parseInt(request.getParameter("trang"));
		List<SanPham> ds=sanphamBL.phanTrangSP(5, trang);
		
		HttpSession session=request.getSession();
		if(session.getAttribute("alert") != null) {
			Object alert=session.getAttribute("alert");
			session.removeAttribute("alert");
			request.setAttribute("alert", alert);
		}
		else {
			request.setAttribute("alert", -1);
		}
		request.setAttribute("tongsp", tongsp);
		request.setAttribute("dsp", ds);
		request.setAttribute("trang", trang);
		request.setAttribute("tongSoTrang", tongSoTrang);
		request.getRequestDispatcher("admin/ManagerP.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
