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


@WebServlet("/UrunAra")
public class UrunAra extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urunad = request.getParameter("urunad");
		if (urunad != null) {
			ArrayList<Urun> Kategoriurun = UrunDao.urunara(urunad);
			request.setAttribute("Kategoriurun", Kategoriurun);
		}
		request.getRequestDispatcher("index").forward(request, response);
	}

}
