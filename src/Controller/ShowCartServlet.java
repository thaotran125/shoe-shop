package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BUSlogic.CartBL;
import JavaBean.Order;

/**
 * Servlet implementation class ShowCartServlet
 */
@WebServlet({ "/ShowCartServlet", "/showcart.html" })
public class ShowCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie arr[]=request.getCookies();
		List<Order> list=new ArrayList<Order>();
		for (Cookie o : arr) {
			if(o.getName().equals("id")) {
				String txt[]=o.getValue().split("a");
				for (String s : txt) {
					int id=Integer.parseInt(s);
					Order oder=CartBL.getItem(id);
					list.add(oder);
				}
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
            int count = 1;
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getId() == list.get(j).getId()){
                    count++;
                    list.remove(j);
                    j--;
                    list.get(i).setAmount(count);
                }
            }
        }
		double total = 0;
        for (Order o : list) {
            total += o.getAmount() * o.getPrice();
        }
		request.setAttribute("list", list);
        request.setAttribute("total", String.format(Locale.FRANCE, "%,.0f", total));
        request.setAttribute("vat",String.format(Locale.FRANCE, "%,.0f", 0.1 * total));
        request.setAttribute("sum", String.format(Locale.FRANCE, "%,.0f", 1.1 * total));
        request.getRequestDispatcher("views/Cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
