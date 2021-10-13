package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BUSlogic.sanphamBL;

/**
 * Servlet implementation class DelLstPServlet
 */
@WebServlet({ "/DelLstPServlet", "/delLstProduct" })
public class DelLstPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelLstPServlet() {
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] ar=request.getParameterValues("options");
		HttpSession session=request.getSession();
		Object a;
		if(ar.length>0) { a=1;
			session.setAttribute("alert", a);
			for (String id : ar) {
				int masp=Integer.parseInt(id);
				sanphamBL.delete(masp);
			}
		}
		else {a=-1;
			session.setAttribute("alert", a);
		}
		request.getRequestDispatcher("product.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
