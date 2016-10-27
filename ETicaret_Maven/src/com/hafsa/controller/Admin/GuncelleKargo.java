package com.hafsa.controller.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hafsa.dao.KargoDao;
import com.hafsa.model.Kargo;


@WebServlet("/guncellekargo")
public class GuncelleKargo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		Kargo kargo = new Kargo();
		kargo.setKargoid(Integer.parseInt(request.getParameter("kargoid")));
		kargo.setKargoad(request.getParameter("kargoad"));
		kargo.setAciklama(request.getParameter("aciklama"));
		boolean state = false;
		try {
			state = KargoDao.kargoguncelle(kargo);
			String message;
			if(state == true){
				message = "Kargo þirketinin bilgileri güncellendi.";
			}else{
				message = "Ýþlem sýrasýnda bir hata oluþtu";
			}
			request.setAttribute("stateGuncelle", message);
			request.getRequestDispatcher("kargo").forward(request, response);
		} catch (Exception e) {
			
		}
		
	}

}
