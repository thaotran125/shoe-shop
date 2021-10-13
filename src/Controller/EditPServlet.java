package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import BUSlogic.ThuongHieuBL;
import BUSlogic.sanphamBL;
import JavaBean.SanPham;
import JavaBean.ThuongHieu;

/**
 * Servlet implementation class EditPServlet
 */
@WebServlet({ "/EditPServlet", "/editp.html" })
public class EditPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPServlet() {
        super();
        // TODO Auto-generated constructor stub

		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("idp"));
		List<ThuongHieu> dsth=ThuongHieuBL.loadAdd();
		SanPham sp=sanphamBL.getSanPham(id);
		HttpSession session=request.getSession();
		if(session.getAttribute("alert") != null) {
			long alert=(long)session.getAttribute("alert");
			session.removeAttribute("alert");
			request.setAttribute("alert", alert);
		}
		else {
			request.setAttribute("alert", -1);
		}
		request.setAttribute("o", sp);
		request.setAttribute("dsth", dsth);
		request.getRequestDispatcher("admin/EditP.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("Utf-8");
		response.setCharacterEncoding("UTF-8");
		int masp=Integer.parseInt(request.getParameter("id"));
		int math=Integer.parseInt(request.getParameter("thuonghieu"));
		String ten=request.getParameter("name");
		int gia=Integer.parseInt(request.getParameter("gia"));
		int giagiam=Integer.parseInt(request.getParameter("giagiam"));
		String hinh=request.getParameter("hinh");
		int sl=Integer.parseInt(request.getParameter("sl"));
		int phai=Integer.parseInt(request.getParameter("phai"));
		String title=request.getParameter("title");
		String mota=request.getParameter("mota");
		SanPham s=new SanPham(masp,math, ten, gia, giagiam, hinh, sl, phai, title, mota);
		long a=sanphamBL.updateSP(s);
		HttpSession session=request.getSession();
		session.setAttribute("alert", a);
		response.sendRedirect("editp.html?idp="+masp);
	}

}
