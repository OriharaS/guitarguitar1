package guitar;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.dao.DAO;
import DAO.daoImple;

/**
 * Servlet implementation class AddGuitar
 */
@WebServlet("/AddGuitar")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String serialNumber = request.getParameter("serialNumber");
		String builder = request.getParameter("builder");
		String model = request.getParameter("model");
		String type = request.getParameter("type");
		String backWood = request.getParameter("backWood");
		String topWood = request.getParameter("topWood");
		String price = request.getParameter("price");
		
		if(!serialNumber.equals("") && serialNumber!=null && !price.equals("") && price!=null){
			System.out.println(serialNumber);
			DAO dao = new daoImple();
			dao.addGuitar(serialNumber, builder, model, type, backWood, topWood, price);
			out.print(1); 
		}else{
			out.print("tianjiachenggong!");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
