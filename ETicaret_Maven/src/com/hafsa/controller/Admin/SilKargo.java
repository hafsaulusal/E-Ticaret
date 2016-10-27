package com.hafsa.controller.Admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hafsa.dao.KargoDao;
import com.hafsa.model.Kargo;


@WebServlet("/silkargo")
public class SilKargo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		Kargo kargo = new Kargo(Integer.parseInt(request.getParameter("kargoid")));
		try {
			boolean state = KargoDao.kargosil(kargo);
			String message = (state == true) ? "Kargo þirketi baþarýyla silindi" : "Ýþlem sýrasýnda bir hata oluþtu";
			request.setAttribute("stateSil", message);
			request.getRequestDispatcher("kargo").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
