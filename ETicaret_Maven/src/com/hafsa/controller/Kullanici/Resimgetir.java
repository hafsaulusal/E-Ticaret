package com.hafsa.controller.Kullanici;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hafsa.dao.UrunDao;

@WebServlet("/Resimgetir")
public class Resimgetir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int resim = Integer.parseInt(request.getParameter("resim"));
		response.setContentType("image/jpeg");
		byte[] image = UrunDao.getImageByUrunid(resim);
		response.setContentLength(image.length);
		response.getOutputStream().write(image);
		
	}

}
