package com.hafsa.controller.Kullanici;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hafsa.model.Urun;



@WebServlet("/SiparisSil")
public class SiparisSil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("urunid"));
		@SuppressWarnings("unchecked")
		ArrayList<Urun> se = (ArrayList<Urun>) request.getSession().getAttribute("sepet");
		try {
			se.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("sepet").forward(request, response);
	}

}
