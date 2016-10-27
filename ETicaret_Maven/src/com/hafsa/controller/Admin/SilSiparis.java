package com.hafsa.controller.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hafsa.dao.SiparisDao;
import com.hafsa.model.Siparis;

@WebServlet("/SilSiparis")
public class SilSiparis extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		boolean state=false;
		try {
			try {
				state = SiparisDao.siparissil(new Siparis(Integer.parseInt(request.getParameter("siparisid"))));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String message = (state == true) ? "Sipariþ baþarýyla iptal edildii" : "Ýþlem sýrasýnda bir hata oluþtu";
			request.setAttribute("stateSilme", message);
			request.getRequestDispatcher("siparis").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
