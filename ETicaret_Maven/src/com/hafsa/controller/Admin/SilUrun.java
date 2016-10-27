package com.hafsa.controller.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hafsa.dao.UrunDao;
import com.hafsa.model.Urun;



@WebServlet("/SilUrun")
public class SilUrun extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		Urun urun = new Urun(Integer.parseInt(request.getParameter("urunid")));
		boolean state=false;
		try {
			state = UrunDao.urunsil(urun);
			String message = (state == true) ? "Seçilen ürün baþarýyla kaldýrýldý." : "Ýþlem sýrasýnda bir hata oluþtu";
			request.setAttribute("stateSilme", message);
			request.getRequestDispatcher("urun").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	
	}

}
