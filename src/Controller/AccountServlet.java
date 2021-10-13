package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BUSlogic.TaiKhoanBL;
import JavaBean.TaiKhoan;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet({ "/AccountServlet", "/account" })
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql="SELECT * FROM `taikhoan`  where isAdmin = 0 ";
		int tongSoTrang=TaiKhoanBL.TongSoTrang(5, sql);
		int trang;
		if(request.getParameter("trang")==null)
			trang=1;
		else
			trang=Integer.parseInt(request.getParameter("trang"));
		List<TaiKhoan> ds=TaiKhoanBL.phanTrangAcc(5, trang);
		
		request.setAttribute("tongSoTrang", tongSoTrang);
		request.setAttribute("trang", trang);
		request.setAttribute("dsa", ds);
		request.getRequestDispatcher("admin/ManagerAccount.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
