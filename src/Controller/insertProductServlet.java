package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionIdListener;

import BUSlogic.ThuongHieuBL;
import BUSlogic.sanphamBL;
import JavaBean.SanPham;
import JavaBean.ThuongHieu;

/**
 * Servlet implementation class insertProductServlet
 */
@WebServlet({"/insertProductServlet" , "/add.html"})
public class insertProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ThuongHieu> dsth=ThuongHieuBL.loadAdd();
		request.setAttribute("dsth", dsth);
		HttpSession session=request.getSession();
		if(session.getAttribute("alert") != null) {
			long alert=(long)session.getAttribute("alert");
			session.removeAttribute("alert");
			request.setAttribute("alert", alert);
		}
		else {
			request.setAttribute("alert", -1);
		}
		request.getRequestDispatcher("admin/AddProduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("Utf-8");
		response.setCharacterEncoding("UTF-8");
		SanPham p=sanphamBL.getspTop1();
		int masp=p.getMasp()+1;
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
		long a=sanphamBL.insertSP(s);
		HttpSession sesion=request.getSession();
		sesion.setAttribute("alert", a);
		response.sendRedirect("add.html");
	}

}
