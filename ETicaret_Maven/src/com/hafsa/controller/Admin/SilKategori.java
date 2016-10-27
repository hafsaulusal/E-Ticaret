package com.hafsa.controller.Admin;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.hafsa.dao.KategoriDao;

import com.hafsa.model.Kategori;

@WebServlet("/silkategori")
public class SilKategori extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		Kategori kategori = new Kategori(Integer.parseInt(request.getParameter("kategoriid")));
		try {
			boolean state = KategoriDao.kategorisil(kategori);
			String message = (state == true) ? "Kategori ba�ar�yla silindi" : "��lem s�ras�nda bir hata olu�tu";
			request.setAttribute("stateSil", message);
			request.getRequestDispatcher("kategori").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
