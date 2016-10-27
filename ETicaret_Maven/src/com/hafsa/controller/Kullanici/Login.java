package com.hafsa.controller.Kullanici;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hafsa.dao.KullaniciDao;
import com.hafsa.model.Kullanici;
import com.hafsa.model.Urun;



@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String eposta=request.getParameter("eposta");
	String parola=request.getParameter("parola");
	
	if(eposta!=null && parola!=null && !eposta.equals("")&& !parola.equals("")){
		Kullanici kullanici=new Kullanici();
		kullanici.setEposta(eposta);
		kullanici.setParola(parola);
		
		if(KullaniciDao.login(kullanici)!=null){
			HttpSession session=request.getSession();
			ArrayList<Urun> sepet = new ArrayList<Urun>();
			
			request.getSession().setAttribute("sepet", sepet);
			session.setAttribute("kullanici",kullanici);
			
			System.out.println(kullanici.toString());
			response.sendRedirect("index");	
		}else{
			request.setAttribute("state", "Kullanýcý adý veya parola yanlýþ");
			request.getRequestDispatcher("musterilogin").forward(request,response);
		}
	}else{
		request.setAttribute("state", "Lütfen boþ alan býrakmayýnýz");
		request.getRequestDispatcher("musterilogin").forward(request,response);
	}
		
	}

}
