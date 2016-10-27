package com.hafsa.controller.Kullanici;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hafsa.dao.UrunDao;
import com.hafsa.model.Urun;

@WebServlet("/Kategoriurun")
public class Kategoriurun extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int kategorino = Integer.parseInt(request.getParameter("kategorino"));
		if (kategorino !=0) {
			ArrayList<Urun> Kategoriurun = UrunDao.kategoriurungetir(kategorino);
			if (Kategoriurun.isEmpty()) {
				String message="Bu katagoride Ürün bulunmamaktadýr!";
				request.setAttribute("state", message);
			}
			request.setAttribute("Kategoriurun", Kategoriurun);
			request.getRequestDispatcher("index").forward(request, response);
		}
	
	}

}
