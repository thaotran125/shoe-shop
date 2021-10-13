package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BUSlogic.TaiKhoanBL;
import JavaBean.TaiKhoan;

/**
 * Servlet implementation class signUpServlet
 */
@WebServlet({ "/signUpServlet", "/signup.html" })
public class signUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("Utf-8");
		response.setCharacterEncoding("UTF-8");
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		String Repass=request.getParameter("repass");
		TaiKhoan ac=TaiKhoanBL.checkAccount(user);
		if(ac==null) {
			if(pass.equals(Repass)) {
				String name=request.getParameter("name");
				int phai=Integer.parseInt(request.getParameter("gender"));
				String sdt=request.getParameter("sdt");
				String mail=request.getParameter("mail");
				String dc=request.getParameter("dc");
				int isAdmin=0;
				TaiKhoan tk=new TaiKhoan();
				tk.setTenTK(user);
				tk.setMatKhau(pass);
				tk.setTen(name);
				tk.setPhai(phai);
				tk.setSdt(sdt);
				tk.setMail(mail);
				tk.setDc(dc);
				tk.setIsAdmin(isAdmin);
				TaiKhoanBL.insertTK(tk);
				request.setAttribute("mess", "success");
				response.sendRedirect("views/Login.jsp");
			}
		}
		else {
			request.setAttribute("mess", "fail sign up");
			request.getRequestDispatcher("views/Login1.jsp").forward(request, response);
		}
	}

}
