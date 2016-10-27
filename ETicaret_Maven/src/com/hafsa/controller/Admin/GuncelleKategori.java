package com.hafsa.controller.Admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hafsa.dao.KategoriDao;
import com.hafsa.model.Kategori;

@WebServlet("/guncellekategori")
public class GuncelleKategori extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		Kategori kategori = new Kategori();
		kategori.setKategoriid(Integer.parseInt(request.getParameter("kategoriid")));
		kategori.setKategoriad(request.getParameter("kategoriad"));
		boolean state = false;
		try {
			state = KategoriDao.kategoriguncelle(kategori);
			String message;
			if(state == true){
				message = "Kategori bilgileri güncellendi.";
			}else{
				message = "Ýþlem sýrasýnda bir hata oluþtu";
			}
			request.setAttribute("stateGuncelle", message);
			request.getRequestDispatcher("kategori").forward(request, response);
		} catch (Exception e) {
			
		}
	}

}
