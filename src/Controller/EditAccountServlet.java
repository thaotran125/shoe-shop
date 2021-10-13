package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BUSlogic.TaiKhoanBL;
import JavaBean.TaiKhoan;

/**
 * Servlet implementation class EditAccountServlet
 */
@WebServlet({ "/EditAccountServlet", "/editAccount" })
public class EditAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("ida");
		TaiKhoan tk=TaiKhoanBL.getTKByUserName(user);
		//Object alert=request.getAttribute("alert");
		HttpSession session = request.getSession();
		
		if(session.getAttribute("alert") != null) {
			long alert=(long)session.getAttribute("alert");
			session.removeAttribute("alert");
			request.setAttribute("alert", alert);
		}
		else {
			request.setAttribute("alert", -1);
		}
		
		request.setAttribute("o", tk);
		request.getRequestDispatcher("admin/EditAcc.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("txt/html; charset=UTF-8");
		request.setCharacterEncoding("Utf-8");
		response.setCharacterEncoding("UTF-8");
		
		String user=request.getParameter("userName");
		TaiKhoan tk=TaiKhoanBL.getTKByUserName(user);
		String pass=tk.getMatKhau();
		String fullname=request.getParameter("fullName");
		int gt=Integer.parseInt(request.getParameter("phai"));
		String sdt=request.getParameter("phone");
		String mail=request.getParameter("mail");
		String dc=request.getParameter("address");
		int isAdmin=Integer.parseInt(request.getParameter("isAdmin"));
		TaiKhoan acc=new TaiKhoan(user, pass, fullname, gt, sdt, mail, dc, isAdmin);
		long i=TaiKhoanBL.updateAcc(acc);
		HttpSession session = request.getSession();
		session.setAttribute("alert", i);
		response.sendRedirect("editAccount?ida="+user);
	}

}
