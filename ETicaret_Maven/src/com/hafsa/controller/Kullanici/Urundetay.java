package com.hafsa.controller.Kullanici;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hafsa.dao.UrunDao;
import com.hafsa.model.Urun;


@WebServlet("/Urundetay")
public class Urundetay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urunn = request.getParameter("urunid");
		int urunid = 0;
		if(urunn != null){
			try{
				urunid = Integer.parseInt(urunn);
			}catch(NumberFormatException ex){
				ex.printStackTrace();
			}
			Urun urun = null;
			try {
				urun = UrunDao.tekurungetir(urunid);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("seciliUrun", urun);
			request.getRequestDispatcher("urundetay").forward(request, response);
		}
		
		
	}

}
