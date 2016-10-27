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


@WebServlet("/EkleKargo")
public class EkleKargo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		Kargo kargo = new Kargo(request.getParameter("kargoad"), request.getParameter("aciklama"));
		boolean state=false;
		try {
			state = KargoDao.kargoekle(kargo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String message = (state == true) ? "Yeni kargo þirketi baþarýyla eklendi." : "Ýþlem sýrasýnda bir hata oluþtu";
		request.setAttribute("stateEkleme", message);
		request.getRequestDispatcher("kargo").forward(request, response);
		
	}

}
