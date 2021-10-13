package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet({ "/CartServlet", "/cart.html" })
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		 String id = request.getParameter("id");
	        Cookie arr[] = request.getCookies();
	        String txt = "";
	        for (Cookie o : arr) {
	            if (o.getName().equals("id")) {
	                txt = txt + o.getValue();
	                o.setMaxAge(0);
	                response.addCookie(o);
	            }
	        }
	        if (txt.isEmpty()) {
	            txt = id;
	        } else {
	            txt = txt + "a" + id;//value cua cookie la chuoi string
	        }
	        Cookie c = new Cookie("id", txt);
	        c.setMaxAge(60 * 10);
	        response.addCookie(c);
		response.sendRedirect("showcart.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
