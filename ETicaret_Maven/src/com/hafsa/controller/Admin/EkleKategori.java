package com.hafsa.controller.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.hafsa.dao.KategoriDao;
import com.hafsa.model.Kategori;

@WebServlet("/eklekategori")
public class EkleKategori extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		Kategori kategori = new Kategori(request.getParameter("kategoriad"));
		boolean state=false;
		try {
			state = KategoriDao.kategoriekle(kategori);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String message = (state == true) ? "Yeni kategori baþarýyla eklendi." : "Ýþlem sýrasýnda bir hata oluþtu";
		request.setAttribute("stateEkleme", message);
		request.getRequestDispatcher("kategori").forward(request, response);
		
		
	}

}
